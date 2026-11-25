package com.app.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.student.dto.DepartmentDTO;
import com.app.student.dto.StudentDTO;
import com.app.student.entity.Student;
import com.app.student.feign.DepartmentClient;
import com.app.student.repository.studentRepo;

@Service
public class StudentService {

	@Autowired
	private studentRepo studentRepo;

	@Autowired
	private DepartmentClient departmentClientFeign;

	public void save(Student request) {
		
		departmentClientFeign.getDepartmentById(request.getDepartmentId()); //Feign Exception
		studentRepo.save(request);

	}

	public Optional<Student> getStudentById(Integer id) {

		return studentRepo.findById(id);
	}

	public List<Student> getAllStudent() {

		return studentRepo.findAll();
	}

	public StudentDTO getStudentAndDepartmentDetils(Integer id) {

		Student studentDetails = getStudentById(id).get();

		StudentDTO response = new StudentDTO();
		response.setStudentId(id);
		response.setName(studentDetails.getName());
		response.setEmail(studentDetails.getEmail());

		Integer deptId = studentDetails.getDepartmentId();

		DepartmentDTO departmentDTOResp = departmentClientFeign.getDepartmentById(deptId).getBody();

		response.setDepartmentDTO(departmentDTOResp);

		return response;

	}

}
