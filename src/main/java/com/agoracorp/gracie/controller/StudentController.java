package com.agoracorp.gracie.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agoracorp.gracie.model.Student;
import com.agoracorp.gracie.service.StudentService;

@CrossOrigin
@Controller
@RequestMapping(value="/gracie-manager/api/")
public class StudentController {
	
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		return  new ResponseEntity<Student>(studentService.createStudent(student),HttpStatus.CREATED);
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudents(){
		return  new ResponseEntity<List<Student>>(studentService.getAllStudents(),HttpStatus.OK);
	}

}
