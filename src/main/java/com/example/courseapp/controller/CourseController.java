package com.example.courseapp.controller;

import com.example.courseapp.dao.CourseRepository;
import com.example.courseapp.models.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "courses";
    }

    @GetMapping("/courses/add")
    public String addCourseForm() {
        return "addCourse";
    }

    @PostMapping("/courses/add")
    public String saveCourse(String courseName, String description, String teacherName) {
        Course course = new Course(courseName, description, teacherName);
        courseRepository.save(course);
        return "redirect:/courses";
    }

    // 编辑课程页面
    @GetMapping("/courses/edit/{id}")
    public String editCourseForm(@PathVariable UUID id, Model model) {
        Course course = courseRepository.findById(id).orElse(null);
        model.addAttribute("course", course);
        return "editCourse";
    }

    // 提交更新
    @PostMapping("/courses/edit/{id}")
    public String updateCourse(@PathVariable UUID id, String courseName, String description, String teacherName) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setCourseName(courseName);
            course.setDescription(description);
            course.setTeacherName(teacherName);
            courseRepository.save(course);
        }
        return "redirect:/courses";
    }

    // 删除课程
    @GetMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable UUID id) {
        courseRepository.deleteById(id);
        return "redirect:/courses";
    }
}