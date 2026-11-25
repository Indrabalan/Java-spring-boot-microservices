package com.app.student.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.student.dto.DepartmentDTO;

@FeignClient("DEPARTMENT-REGISTRY")
public interface DepartmentClient {

	@GetMapping("departments/{id}")
	public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Integer id);
}
