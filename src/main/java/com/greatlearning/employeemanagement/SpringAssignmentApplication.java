package com.greatlearning.employeemanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.employeemanagement.entity.Role;
import com.greatlearning.employeemanagement.entity.Users;
import com.greatlearning.employeemanagement.repository.UsersRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@SpringBootApplication
public class SpringAssignmentApplication implements CommandLineRunner{

	
	@Autowired
	UsersRepository usersRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAssignmentApplication.class, args);
		System.out.println("yes yes yes");
	}

	@Override
	public void run(String... args) throws Exception {

		Users user = new Users();
		user.setId(1);
		user.setUsername("asmita");
		user.setPassword(new BCryptPasswordEncoder().encode("asmita"));

		List<Role> roles = new ArrayList<>();
		roles.add(new Role("ADMIN"));
		user.setRoles(roles);

		
		usersRepository.save(user);

	}

	
}
