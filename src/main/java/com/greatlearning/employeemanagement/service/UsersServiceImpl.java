package com.greatlearning.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.entity.Users;
import com.greatlearning.employeemanagement.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService  {

	@Autowired
	UsersRepository usersRepository;
	
	// this method lists all the users in the database
	@Override
	public List<Users> listUsers() {
		return usersRepository.findAll();
	}
	
	// this method adds new users to the database
	@Override
	public String addUser(Users newUser) {
		 Users user = usersRepository.save(newUser);
	     
	     return "User "+ user+ " saved to the Users DB";
	}
	
	
}
