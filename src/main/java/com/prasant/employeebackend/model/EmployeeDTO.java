package com.prasant.employeebackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String designation;

}
