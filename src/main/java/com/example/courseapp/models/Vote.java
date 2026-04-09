package com.example.courseapp.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;
    private String username;
    private UUID courseId;
    private String courseName;

    public Vote() {}

    public Vote(UUID userId, String username, UUID courseId, String courseName) {
        this.userId = userId;
        this.username = username;
        this.courseId = courseId;
        this.courseName = courseName;
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
}