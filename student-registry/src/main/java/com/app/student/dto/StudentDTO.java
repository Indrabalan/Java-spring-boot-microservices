package com.app.student.dto;

import lombok.Data;

@Data
public class StudentDTO {

	private Integer studentId;

	private String name;

	private String email;

	private Integer departmentId;

	private DepartmentDTO departmentDTO;

}
