package com.example.courseapp.dao;

import com.example.courseapp.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface VoteRepository extends JpaRepository<Vote, UUID> {
    List<Vote> findByUserId(UUID userId);
}