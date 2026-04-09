package com.example.courseapp.controller;

import com.example.courseapp.dao.CommentRepository;
import com.example.courseapp.models.Comment;
import com.example.courseapp.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CommentHistoryController {

    private final CommentRepository commentRepository;

    public CommentHistoryController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/commentHistory")
    public String commentHistory(HttpSession session, Model model) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        List<Comment> comments = commentRepository.findByUserId(loginUser.getId());
        model.addAttribute("comments", comments);
        return "commentHistory";
    }
}