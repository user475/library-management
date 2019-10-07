package com.virtusa.jpmc.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.jpmc.management.models.User;
import com.virtusa.jpmc.management.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void register(User user) {
		System.out.println("user object"+user.toString());
		 userRepository.save(user);
	}

	@Override
	public User getUserByUsername(String username) {
		User dbUser =userRepository.findByUsername(username);
		return dbUser;
	}

	
}
