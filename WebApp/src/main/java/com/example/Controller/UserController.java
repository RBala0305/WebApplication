package com.example.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.Model.User;
import com.example.Service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	   @Autowired
	    private UserService userService;
	   @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	   @PostMapping("/signup")
	    public User signUp(@RequestBody User user) {
	        return userService.save(user);
	    }

	   @PostMapping("/login")
	    public User login(@RequestBody User user) {
	        User existingUser = userService.findByEmail(user.getEmail());
	        if (existingUser != null && userService.bCryptPasswordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
	            return existingUser;
	        } else {
	            throw new RuntimeException("Invalid login credentials");
	        }
	    }
	}
