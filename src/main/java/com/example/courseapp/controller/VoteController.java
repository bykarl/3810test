package com.example.courseapp.controller;

import com.example.courseapp.dao.CourseRepository;
import com.example.courseapp.dao.VoteRepository;
import com.example.courseapp.models.Course;
import com.example.courseapp.models.User;
import com.example.courseapp.models.Vote;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class VoteController {

    private final CourseRepository courseRepository;
    private final VoteRepository voteRepository;

    // 构造器注入（Spring 标准，解决依赖注入报错）
    public VoteController(CourseRepository courseRepository, VoteRepository voteRepository) {
        this.courseRepository = courseRepository;
        this.voteRepository = voteRepository;
    }

    @GetMapping("/vote/{courseId}")
    public String vote(@PathVariable UUID courseId, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        Course course = courseRepository.findById(courseId).orElse(null);
        if (course != null) {
            course.incrementVote();
            courseRepository.save(course);

            // 保存投票记录
            Vote vote = new Vote(
                    loginUser.getId(),
                    loginUser.getUsername(),
                    courseId,
                    course.getCourseName()
            );
            voteRepository.save(vote);
        }
        return "redirect:/courses";
    }
}