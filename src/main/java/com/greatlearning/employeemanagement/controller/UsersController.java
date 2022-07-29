package com.greatlearning.employeemanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.entity.Users;
import com.greatlearning.employeemanagement.service.UsersService;


//this is a controller method for the Users
@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UsersService usersService;
	
	
	@GetMapping("/list")
	public List<Users> fetchAllUsers() {
		return usersService.listUsers();
	}
	
	@PostMapping("/addUser")
	public String addNewUser( @RequestBody Users user) {
		return usersService.addUser(user);
	}
}
