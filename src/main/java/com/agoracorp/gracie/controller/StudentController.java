package com.agoracorp.gracie.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agoracorp.gracie.model.Student;
import com.agoracorp.gracie.service.StudentService;

@CrossOrigin
@RestController
@RequestMapping(value="/gracie-manager/student")
public class StudentController {
	
	private static final Logger logger = LogManager.getLogger(StudentController.class);
	
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping()
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.createStudent(student),HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable(name = "id") Integer id ){
		return new ResponseEntity<Student>(studentService.getStudent(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") Integer id){
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Stundent with id "+ id + " successfully deleted.",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(name = "id") Integer id, @RequestBody Student updateDstudent){
		Student student = studentService.updateStudent(id, updateDstudent);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

}
