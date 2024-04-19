package com.mk.dto;

import com.mk.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

	private Department department;
	private EmployeeDto employeeDto;
}
