package com.greatlearning.employeemanagement.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.employeemanagement.entity.Employee;

// interface for defining services for employee entity
public interface EmployeeService {
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	String deleteById(int theId);

	String save(List<Employee> theEmployees);
	
	List<Employee> employeesByFirstName (String firstName);
	
	List<Employee> sortAll(Direction order);
}
