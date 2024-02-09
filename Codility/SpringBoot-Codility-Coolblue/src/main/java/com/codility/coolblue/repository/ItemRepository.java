package com.codility.coolblue.repository;

import java.util.List;

import com.codility.coolblue.entity.Item;

public interface ItemRepository {
	Item save(Item user);
	
	List<Item> findAll();
}
