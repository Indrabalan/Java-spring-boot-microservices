package com.app.student.dto;

import lombok.Data;

@Data
public class DepartmentDTO {
	
	private Integer departmentId;

	private String departmentName;

	private String hod;

	private String location;

	private Boolean isNbaCreated;

}
