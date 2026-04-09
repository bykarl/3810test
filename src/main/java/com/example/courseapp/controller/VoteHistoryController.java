package com.example.courseapp.controller;

import com.example.courseapp.dao.VoteRepository;
import com.example.courseapp.models.User;
import com.example.courseapp.models.Vote;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VoteHistoryController {

    private final VoteRepository voteRepository;

    public VoteHistoryController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @GetMapping("/voteHistory")
    public String voteHistory(HttpSession session, Model model) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        List<Vote> history = voteRepository.findByUserId(loginUser.getId());
        model.addAttribute("history", history);
        return "voteHistory";
    }
}