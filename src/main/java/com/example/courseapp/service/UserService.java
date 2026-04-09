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
        // 🔥 先判断用户名是否已存在
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists!");
        }

        User user = new User(
                username,
                passwordEncoder.encode(password),
                fullName,
                email,
                "STUDENT"
        );
        userRepository.save(user);
    }
}