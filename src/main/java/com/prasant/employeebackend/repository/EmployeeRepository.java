package com.prasant.employeebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prasant.employeebackend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
