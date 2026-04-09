package com.example.courseapp.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String courseName;
    private String description;
    private String teacherName;
    // 新增：投票数字段
    private int voteCount = 0;

    public Course() {}

    public Course(String courseName, String description, String teacherName) {
        this.courseName = courseName;
        this.description = description;
        this.teacherName = teacherName;
        this.voteCount = 0;
    }

    // getter & setter
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getTeacherName() { return teacherName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
    public int getVoteCount() { return voteCount; }
    public void setVoteCount(int voteCount) { this.voteCount = voteCount; }
    // 新增：投票+1方法
    public void incrementVote() { this.voteCount++; }
}