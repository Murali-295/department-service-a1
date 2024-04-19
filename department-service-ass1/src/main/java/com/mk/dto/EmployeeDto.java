package com.mk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	private Integer empId;
	private String empName;
	private Double empSalary;
	private Long empYOJ;
	private String empDepartment;
}
