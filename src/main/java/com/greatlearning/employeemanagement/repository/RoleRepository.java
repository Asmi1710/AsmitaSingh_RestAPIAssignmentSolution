package com.greatlearning.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeemanagement.entity.Role;

//Through the JPA repository, all the commonly used CRUD operations will be supported 
//We don't create any implementation class but Spring Boot takes the responsibility to 
//dynamically create the class for StudentRepository during runtime
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
