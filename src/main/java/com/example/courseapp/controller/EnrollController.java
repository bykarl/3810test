package com.example.courseapp.controller;

import com.example.courseapp.dao.CourseRepository;
import com.example.courseapp.dao.UserRepository;
import com.example.courseapp.models.Course;
import com.example.courseapp.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class EnrollController {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public EnrollController(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    // 选课
    @GetMapping("/enroll/{courseId}")
    public String enroll(@PathVariable UUID courseId, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        User user = userRepository.findById(loginUser.getId()).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (user != null && course != null) {
            user.getCourses().add(course);
            userRepository.save(user);
        }

        return "redirect:/myCourses";
    }

    // 查看我的课程
    @GetMapping("/myCourses")
    public String myCourses(HttpSession session, Model model) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        User user = userRepository.findById(loginUser.getId()).orElse(null);
        model.addAttribute("myCourses", user.getCourses());
        return "myCourses";
    }
}