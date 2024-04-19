package com.mk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mk.dto.ResponseDto;
import com.mk.entity.Department;
import com.mk.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	@PostMapping("/save")
	public Department saveDepartment(@RequestBody Department department) {
		return service.saveDepartment(department);
	}
	
	@GetMapping("/id")
	public ResponseDto findDepartmentById(@RequestParam Integer departmentId) {
		return service.findDepartmentById(departmentId); 
	}
	
}
