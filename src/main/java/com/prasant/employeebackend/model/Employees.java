package com.prasant.employeebackend.model;

import java.util.ArrayList;
import java.util.List;

public class Employees {
	
	private List<EmployeeDTO> employees;
	
	public List<EmployeeDTO> getEmployees() {
		if (this.employees == null || this.employees.isEmpty()) {
			this.employees = new ArrayList<EmployeeDTO>();
		}
		return this.employees;
	}

}
