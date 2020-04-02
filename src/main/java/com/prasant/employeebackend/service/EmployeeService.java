package com.prasant.employeebackend.service;

import com.prasant.employeebackend.model.EmployeeDTO;
import com.prasant.employeebackend.model.Employees;

public interface EmployeeService {
	
	Employees getEmployees();
	
	EmployeeDTO getEmployeeById(Long id);
	
	void createEmployee(EmployeeDTO employeeDTO);
	
	EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);
	
	void deleteEmployeeById(Long id);

}
