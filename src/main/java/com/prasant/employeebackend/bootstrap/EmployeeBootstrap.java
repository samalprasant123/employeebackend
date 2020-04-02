 package com.prasant.employeebackend.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.prasant.employeebackend.entity.Employee;
import com.prasant.employeebackend.repository.EmployeeRepository;

@Component
public class EmployeeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadEmployees();		
	}
	
	private void loadEmployees() {
		Employee employee1 = new Employee(1L, "John", "Doe", 45, "Developer");
		Employee employee2 = new Employee(2L, "Bat", "Man", 24, "Saviour");
		Employee employee3 = new Employee(3L, "Super", "Man", 30, "Saviour");
		Employee employee4 = new Employee(4L, "Tom", "Hanks", 58, "Director");
		Employee employee5 = new Employee(5L, "Swetapadma", "Samal", 8, "Player");
		
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);
		employeeRepository.save(employee4);
		employeeRepository.save(employee5);		
	}
	
	

}
