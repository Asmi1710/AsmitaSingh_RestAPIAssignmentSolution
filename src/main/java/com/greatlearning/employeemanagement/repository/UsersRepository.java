package com.greatlearning.employeemanagement.repository; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.greatlearning.employeemanagement.entity.Users;

//Through the JPA repository, all the commonly used CRUD operations will be supported 
//We don't create any implementation class but Spring Boot takes the responsibility to 
//dynamically create the class for StudentRepository during runtime
@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

	@Query("SELECT u FROM Users u WHERE u.username = ?1")
	Users getUserByUsername(String username);

}

