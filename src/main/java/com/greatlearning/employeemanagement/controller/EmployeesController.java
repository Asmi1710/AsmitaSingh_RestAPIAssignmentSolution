package com.greatlearning.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.repository.EmployeeRepository;
import com.greatlearning.employeemanagement.service.EmployeeService;


//this is a controller method for the employee entity -> performs methods for all the employees
@RestController
@RequestMapping("/employees")
public class EmployeesController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@ResponseBody
    @GetMapping("/list")
	public List<Employee> handleListAll() {
		return employeeService.findAll();		
	}
	
	@GetMapping("/search")
	public List<Employee> handleListByFirstname(String firstName) {
		return employeeService.employeesByFirstName(firstName);		
	}
	
	
	@GetMapping("/sort")
	public List<Employee> handleListByOrder(Direction order) {
		return employeeService.sortAll(order);	
	}
	
}
