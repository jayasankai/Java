package com.codility.coolblue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codility.coolblue.dao.UserDao;
import com.codility.coolblue.service.UserService;



@RestController
public class UserContoller {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<UserDao> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/users")
	public void addUser(@RequestBody UserDao user) {
		userService.addUser(user);
	}

	@GetMapping("/users/{name}")
	public UserDao getUser(@PathVariable String name) {
		return userService.findUserBy(name);
	}

	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable Long id) {
		userService.deleteUserBy(id);
	}

}
