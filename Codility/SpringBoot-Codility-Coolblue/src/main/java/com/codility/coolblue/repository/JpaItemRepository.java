package com.codility.coolblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codility.coolblue.entity.Item;

public interface JpaItemRepository extends JpaRepository<Item, Long>, ItemRepository {

}
