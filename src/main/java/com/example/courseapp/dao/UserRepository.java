package com.example.courseapp.dao;

import com.example.courseapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, java.util.UUID> {
    Optional<User> findByUsername(String username);
}