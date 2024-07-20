package com.example.Controller;


import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Model.User;
import com.example.Service.CommentService;
import com.example.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

	    @Autowired
	    private CommentService commentService;
 
	    @Autowired
	    private UserService userService;

	    @PostMapping
	    public Comment addComment(@RequestParam String email, @RequestParam String comment) {
	        User user = userService.findByEmail(email);
	        if (user != null) {
	            Comment newComment = new Comment();
	            newComment.setUser(user);
	            newComment.setComment(comment);
	            return commentService.save(newComment);
	        } else {
	            throw new RuntimeException("User not found");
	        }
	    }

	    @GetMapping
	    public List<Comment> getAllComments(@RequestParam String email) {
	        User user = userService.findByEmail(email);
	        if (user != null) {
	            return commentService.findByUserId(user.getId());
	        } else {
	            throw new RuntimeException("User not found");
	        }
	    }
	}

