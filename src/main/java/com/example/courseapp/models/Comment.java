package com.example.courseapp.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;
    private String username;
    private UUID courseId;
    private String courseName;
    private String content;

    public Comment() {}

    public Comment(UUID userId, String username, UUID courseId, String courseName, String content) {
        this.userId = userId;
        this.username = username;
        this.courseId = courseId;
        this.courseName = courseName;
        this.content = content;
    }

    // Getters & Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public UUID getCourseId() { return courseId; }
    public void setCourseId(UUID courseId) { this.courseId = courseId; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}