package com.greatlearning.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.employeemanagement.entity.Employee;

//Through the JPA repository, all the commonly used CRUD operations will be supported 
//We don't create any implementation class but Spring Boot takes the responsibility to 
//dynamically create the class for StudentRepository during runtime
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
