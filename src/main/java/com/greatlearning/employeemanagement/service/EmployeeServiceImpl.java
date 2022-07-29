package com.greatlearning.employeemanagement.service;

import java.util.List;
import com.greatlearning.employeemanagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;
import com.greatlearning.employeemanagement.repository.EmployeeRepository;

//implementation of services mentioned in the interface
@Repository
public class EmployeeServiceImpl implements EmployeeService{
	// for Spring to create dynamic implementation of StudentRepository
		@Autowired
		private EmployeeRepository employeeRepository;
		
		
		// this method lists all the employees
		@Override
		public List<Employee> findAll() {
			
			return employeeRepository.findAll();
		}
		
		// this method saves the new employees
		@Override
		public String save(List<Employee> theEmployees) {

			employeeRepository.saveAll(theEmployees);
			employeeRepository.flush();
			
			return "Employee saved to DB";
			//return theEmployee;
		}

		// this method finds the employee based on given id
		@Override
		public Employee findById(int id) {
			return employeeRepository.findById(id).get();
		}

		// this method deletes an employee based on given id
		@Override
		public String deleteById(int theId) {
			
			employeeRepository.deleteById(theId);
			return "This id "+theId+" is deleted";
			
		}
		
		// this method lists all the employees with given first name
		@Override
		public List<Employee> employeesByFirstName(String firstName) {
			Employee employeeWithFirstname = new Employee();
			
			employeeWithFirstname.setFirstName(firstName);
			ExampleMatcher example= ExampleMatcher.matching()
					.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact())
					.withIgnorePaths("id","lastName","email");
			Example<Employee> solutionList= Example.of(employeeWithFirstname, example);
			return employeeRepository.findAll(solutionList);
			
		}

		// this method sorts all the employees based on given direction- ascending or descending
		@Override
		public List<Employee> sortAll(Direction order){
			return employeeRepository.findAll(Sort.by(order, "firstName"));
		}

}
