package com.example.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByUserId(Long userId);
}

