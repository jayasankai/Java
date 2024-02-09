package com.codility.coolblue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.codility.coolblue.entity.User;

public interface JpaUserRepository extends JpaRepository<User, Long>, UserRepository {
	
    @Query(value = "select * from User u where u.first_name = :firstName", nativeQuery = true)
    User findUserBy(@Param("firstName") String firstName);
   
    @Modifying
    @Transactional
    @Query(value = "delete from User u where u.id = :id", nativeQuery = true)
    int deleteUserBy(@Param("id") Long id);
 
}
