package com.example.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.example.Repository.UserRepository;

@Service
public class UserService {

	    @Autowired
	    private UserRepository userRepository;

	    public User findByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }

		public com.example.Model.User save(com.example.Model.User user) {
			// TODO Auto-generated method stub
			return null;
		}

	
	}


