package com.codility.coolblue.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codility.coolblue.dao.ItemDao;
import com.codility.coolblue.dao.UserDao;
import com.codility.coolblue.entity.Item;
import com.codility.coolblue.entity.User;
import com.codility.coolblue.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public void addUser(UserDao userDao) {
		User user = mapToEntity(userDao);
		userRepo.save(user);
	}

	public List<UserDao> getAllUsers() {
		List<User> users = (List<User>) userRepo.findAll();
		
		List<UserDao> userDaos = new ArrayList<>();
		
		for (User user : users) {
			UserDao userDao = new UserDao(user.getFirstName(), user.getLastName());
			userDao.setItems(user.getItems().stream().map(i -> new ItemDao(i.getName(), i.getType())).collect(Collectors.toList()));
			userDaos.add(userDao);
		}
		
		return userDaos;
	}

	public UserDao findUserBy(String name) {
		User user = userRepo.findUserBy(name);
		UserDao userDao = new UserDao(user.getFirstName(), user.getLastName());
		userDao.setItems(user.getItems().stream().map(i -> new ItemDao(i.getName(), i.getType())).collect(Collectors.toList()));
		
		return userDao;
	}

	public void deleteUserBy(Long id) {
		userRepo.deleteUserBy(id);

	}
	
	private User mapToEntity(UserDao userDao) {
		User user = new User(userDao.getFirstName(), userDao.getLastName());
		
		List<Item> items = new ArrayList<>();
		for(ItemDao itemDao : userDao.getItems()) {
			items.add(new Item(itemDao.getName(), itemDao.getType()));
		}
		
		user.setItems(items);
		
		return user;
	}
	
	private UserDao mapToDao(User user) {
		UserDao userDao = new UserDao(user.getFirstName(), user.getLastName());
		
		List<ItemDao> itemDaos = new ArrayList<>();
		for(Item item : user.getItems()) {
			itemDaos.add(new ItemDao(item.getName(), item.getType()));
		}
		
		userDao.setItems(itemDaos);
		
		return userDao;
	}
}
