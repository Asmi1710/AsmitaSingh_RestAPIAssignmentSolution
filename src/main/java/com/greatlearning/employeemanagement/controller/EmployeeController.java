package com.greatlearning.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.repository.EmployeeRepository;
import com.greatlearning.employeemanagement.service.EmployeeService;


// this is a controller method for the employee entity -> performs methods for individual employee
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeService employeeService;
  
	
	@PostMapping("/addEmployee")
    public String addEmployee(@RequestBody List<Employee> theEmployees) {
    return	employeeService.save(theEmployees);
}
	
	@DeleteMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("id") Integer id) {
		return employeeService.deleteById(id);
	}
	
	@PutMapping("/updateEmployee")
	public String updateExistingEmployee(@RequestBody Employee employee) {
		return employeeService.updateExistingEmployee(employee);
	}
	
	
	@GetMapping("/getEmployeeById")
	public Employee getEmployeeById( int id) {
		return employeeService.findById(id);
	}
}
	
