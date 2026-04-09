package com.example.courseapp.dao;

import com.example.courseapp.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findByUserId(UUID userId);
    List<Comment> findByCourseId(UUID courseId);
}