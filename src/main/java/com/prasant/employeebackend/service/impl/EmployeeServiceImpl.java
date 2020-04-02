package com.prasant.employeebackend.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasant.employeebackend.entity.Employee;
import com.prasant.employeebackend.mapper.EmployeeMapper;
import com.prasant.employeebackend.model.EmployeeDTO;
import com.prasant.employeebackend.model.Employees;
import com.prasant.employeebackend.repository.EmployeeRepository;
import com.prasant.employeebackend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public Employees getEmployees() {
		Employees employees = new Employees();
		
		employees.getEmployees().addAll(employeeRepository.findAll()
				.stream()
				.map(employee -> employeeMapper.convertToDTO(employee))
				.collect(Collectors.toList()));
		
		/*
		employees.getEmployees().addAll(employeeRepository.findAll()
				.stream()
				.map(employeeMapper::employeeToEmployeeDTO)
				.collect(Collectors.toList()));
		*/
		return employees;
	}

	@Override
	public EmployeeDTO getEmployeeById(Long id) {
		return employeeRepository.findById(id)
				.map(employee -> employeeMapper.convertToDTO(employee))
				.orElseThrow(RuntimeException::new);
	}

	@Override
	public void createEmployee(EmployeeDTO employeeDTO) {		
		Employee employee = employeeMapper.convertToEntity(employeeDTO);
		employeeRepository.save(employee);
	}

	@Override 
	public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
		Employee employeeFound = employeeRepository.getOne(id);
		if (employeeFound != null) {
			Employee employee = employeeMapper.convertToEntity(employeeDTO);
			employee.setId(id);
			employeeRepository.save(employee);
			return employeeMapper.convertToDTO(employee);			
		}
		return null;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

}
