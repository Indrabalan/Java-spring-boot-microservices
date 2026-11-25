package com.app.student.controller;

import java.lang.module.ResolutionException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.student.dto.StudentDTO;
import com.app.student.entity.Student;
import com.app.student.exception.StudentNotFoundException;
import com.app.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<String> addStudent(@RequestBody Student request) {
		try {
			studentService.save(request);

			return new ResponseEntity<>("Student created sucessfully...", HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>("Failed to create student", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

//	@GetMapping("/{id}")
//	public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
//		try {
//			Optional<Student> optionalStudent = studentService.getStudentById(id);
//			if (optionalStudent.isEmpty()) {
//				throw new StudentNotFoundException("Student not  found woth id " + id);
//			}
//			return new ResponseEntity<>(optionalStudent.get(), HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {

		Optional<Student> optionalStudent = studentService.getStudentById(id);
		if (optionalStudent.isEmpty()) {
			throw new StudentNotFoundException("Student not  found woth id " + id);
		}
		return new ResponseEntity<>(optionalStudent.get(), HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudent() {

		return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);

	}

	@GetMapping("/details/{id}")
	public ResponseEntity<StudentDTO> getDetails(@PathVariable Integer id) {
		try {

			StudentDTO studentDTO = studentService.getStudentAndDepartmentDetils(id);

			return new ResponseEntity<>(studentDTO, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
