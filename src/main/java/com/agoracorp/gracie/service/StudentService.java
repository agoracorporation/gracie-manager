package com.agoracorp.gracie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agoracorp.gracie.model.Student;
import com.agoracorp.gracie.repository.StudentRepository;

@Service
public class StudentService {

	private StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);	
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

}
