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
	public String deleteEmployee(Integer id) {
		return employeeService.deleteById(id);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployees(int id, String firstName, String lastName, String email) {
		
		if(employeeRepository.findById(id).isPresent()) {
			Employee existingEmployee = employeeRepository.findById(id).get();
			
			existingEmployee.setFirstName(firstName);
			existingEmployee.setLastName(lastName);
			existingEmployee.setEmail(email);
			
			Employee updatedEmployee = employeeRepository.save(existingEmployee);
			
			return new Employee(updatedEmployee.getId(), updatedEmployee.getFirstName(), updatedEmployee.getLastName(),
					updatedEmployee.getEmail());
		}else {
			throw new RuntimeException("There is no Employee present with the id "+ id);
		}
	}
	
	
	@GetMapping("/getEmployeeById")
	public Employee getEmployeeById( int id) {
		return employeeService.findById(id);
	}
}
	
