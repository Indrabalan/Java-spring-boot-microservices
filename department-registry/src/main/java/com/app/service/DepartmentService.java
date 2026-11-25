package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Department;
import com.app.repository.DepartmentRepo;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;

	public List<Department> getAllDepartments() {

		return departmentRepo.findAll();
	}

	public Optional<Department> getDepartmentById(Integer id) {

		return departmentRepo.findById(id);

	}

	public void save(Department request) {
		departmentRepo.save(request);

	}

}
