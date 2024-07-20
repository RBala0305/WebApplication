package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.Comment;
import com.example.Repository.CommentRepository;

import java.util.List;

	@Service
	public class CommentService {

	    @Autowired
	    private CommentRepository commentRepository;

	    public Comment save(Comment comment) {
	        return commentRepository.save(comment);
	    }

	    public List<Comment> findByUserId(Long userId) {
	        return commentRepository.findByUserId(userId);
	    }
	}


