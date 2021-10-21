package com.surendiran.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surendiran.entity.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	public List<Student> students = new ArrayList<>();

	@GetMapping("/list")
	public List<Student> listStudents() {
		
		return this.students;
	}

	@PostConstruct
	private List<Student> getStudentsList() {
		
		this.students.add(new Student("Surendiran", "S"));
		this.students.add(new Student("Yaswanth", "K"));
		this.students.add(new Student("Somnath", "K"));
		return this.students;
		
	}
	
	@GetMapping("/get/{id}")
	public Student getStudent(@PathVariable int id) {
		
		// check the studentid again the list size
		
		if ((id >= this.students.size()) || (id < 0)) {
			throw new StudentNotFoundException("Student id is not found - " + id);
		}
		
		return this.students.get(id);
	}
	
	
}
