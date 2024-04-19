package com.mk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.mk.dto.EmployeeDto;
import com.mk.dto.ResponseDto;
import com.mk.entity.Department;
import com.mk.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	@Autowired
	private WebClient webClient;

	public Department saveDepartment(Department department) {

		EmployeeDto employeeDto = webClient.get()
				.uri("http://localhost:8080/employee/id/" + department.getDepartmentId()).retrieve()
				.bodyToMono(EmployeeDto.class).block();

		department.setDepartmentId(department.getDepartmentId());
		department.setDepartmentName(department.getDepartmentName());
		department.setEmployeeDto(employeeDto);

		return repository.save(department);
	}

	public ResponseDto findDepartmentById(Integer departmentId) {

		ResponseDto responseDto = new ResponseDto();
		Department department = repository.findById(departmentId).get();
		EmployeeDto employeeDto = webClient.get()
				.uri("http://localhost:8080/employee/id/" + department.getDepartmentId()).retrieve()
				.bodyToMono(EmployeeDto.class).block();

		responseDto.setDepartment(department);
		responseDto.setEmployeeDto(employeeDto);

		return responseDto;
	}

}
