package com.agoracorp.gracie.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.agoracorp.gracie.model.Student;

@Repository
public interface StudentRepository extends ListCrudRepository<Student, Integer>{}
