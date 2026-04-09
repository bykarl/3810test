package com.example.courseapp.service;

import com.example.courseapp.dao.UserRepository;
import com.example.courseapp.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(String username, String password, String fullName, String email) {
        User user = new User(
                username,
                passwordEncoder.encode(password), // 加密密码
                fullName,
                email,
                "STUDENT"
        );
        userRepository.save(user);
    }
}