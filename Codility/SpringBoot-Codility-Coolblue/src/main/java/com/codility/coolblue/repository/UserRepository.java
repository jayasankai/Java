package com.codility.coolblue.repository;

import java.util.List;

import com.codility.coolblue.entity.User;

public interface UserRepository {
	
	User save(User user);
	
	List<User> findAll();
	
	User findUserBy(String firstName);

	int deleteUserBy(Long id);

}
