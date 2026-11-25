package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Department;
import com.app.exception.DepartmentNotFoundException;
import com.app.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public ResponseEntity<List<Department>> getAllDepartmets() {

		return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable Integer id) {

		Optional<Department> optionalDept = departmentService.getDepartmentById(id);

		if (optionalDept.isEmpty()) {
			throw new DepartmentNotFoundException("Department Not Found with Id " + id);
		}

		return new ResponseEntity<>(optionalDept.get(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<String> addDepartment(@RequestBody Department request) {

		departmentService.save(request);

		return new ResponseEntity<>("Department add Sucessfully", HttpStatus.CREATED);
	}

}
