package com.nit.dto;

import com.nit.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeResponse {
	
	private Employee employee;
	
	private DepartmentDto department;
	
	private String message;

}
