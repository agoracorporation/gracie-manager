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

	public Student getStudent(Integer id) {
		return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student with id "+ id + " not found."));
	}

	public void deleteStudent(Integer id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student with id "+ id + " not found."));
		studentRepository.delete(student);
	}

	public Student updateStudent(Integer id, Student updatedStudent) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student with id "+ id + " not found."));
		student.setName(updatedStudent.getName());
		student.setPhoneNumber(updatedStudent.getPhoneNumber());
		student.setCpf(updatedStudent.getCpf());
		student.setAddress(updatedStudent.getAddress());
		student.setPlan(updatedStudent.getPlan());
		student.setPaymentStatus(updatedStudent.getPaymentStatus());
		
		return studentRepository.save(student);
	}

}
