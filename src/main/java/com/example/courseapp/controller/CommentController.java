package com.example.courseapp.controller;

import com.example.courseapp.dao.CommentRepository;
import com.example.courseapp.dao.CourseRepository;
import com.example.courseapp.models.Comment;
import com.example.courseapp.models.Course;
import com.example.courseapp.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class CommentController {

    private final CommentRepository commentRepository;
    private final CourseRepository courseRepository;

    public CommentController(CommentRepository commentRepository, CourseRepository courseRepository) {
        this.commentRepository = commentRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses/{id}/comments")
    public String showComments(@PathVariable UUID id, Model model) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) {
            return "redirect:/courses";
        }

        List<Comment> comments = commentRepository.findByCourseId(id);
        model.addAttribute("course", course);
        model.addAttribute("comments", comments);
        return "comments";
    }

    @PostMapping("/comments/add")
    public String addComment(@RequestParam UUID courseId,
                            @RequestParam String content,
                            HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        Course course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            return "redirect:/courses";
        }

        Comment comment = new Comment(
                loginUser.getId(),
                loginUser.getUsername(),
                courseId,
                course.getCourseName(),
                content
        );
        commentRepository.save(comment);
        return "redirect:/courses/" + courseId + "/comments";
    }
}