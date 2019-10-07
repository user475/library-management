package com.virtusa.jpmc.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.jpmc.management.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	 User findByUsername(String username);
}
