package com.prasant.employeebackend.mapper;

//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prasant.employeebackend.entity.Employee;
import com.prasant.employeebackend.model.EmployeeDTO;

//@Mapper
@Component
public class EmployeeMapper {
	
	@Autowired
	private ModelMapper modelMapper;
		
	public EmployeeDTO convertToDTO(Employee employee) {
		EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
		return employeeDTO;
	}
	
	public Employee convertToEntity(EmployeeDTO employeeDTO) {
		Employee employee = modelMapper.map(employeeDTO, Employee.class);
		return employee;
	}
	
	/*
	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
	
	EmployeeDTO employeeToEmployeeDTO(Employee employee);
	
	Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);
	*/
}
