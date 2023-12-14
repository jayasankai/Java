package com.jayasanka.jenkins.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jayasanka.jenkins.domain.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
}