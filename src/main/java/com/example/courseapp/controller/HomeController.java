package com.example.courseapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 首页路由
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // 登录页路由：必须是 GET 请求，返回 login.jsp
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 注册页路由
    @GetMapping("/register")
    public String register() {
        return "register";
    }
}