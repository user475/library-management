package com.virtusa.jpmc.management.service;

import org.springframework.stereotype.Service;

import com.virtusa.jpmc.management.models.User;


public interface UserService {

	public void register(User user);
	
	public User getUserByUsername(String username);
}
