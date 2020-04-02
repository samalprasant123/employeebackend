package com.prasant.employeebackend.controllers.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prasant.employeebackend.model.EmployeeDTO;
import com.prasant.employeebackend.model.Employees;
import com.prasant.employeebackend.service.EmployeeService;

@RestController
@RequestMapping(EmployeeController.BASE_URL)
public class EmployeeController {
	
	public static final String BASE_URL = "/api/v1/employee";
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<Employees> getEmployees() {
		return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
		return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		employeeService.createEmployee(employeeDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDTO> saveEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
		return new ResponseEntity<>(employeeService.updateEmployee(id, employeeDTO), HttpStatus.OK);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteEmployeeById(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
