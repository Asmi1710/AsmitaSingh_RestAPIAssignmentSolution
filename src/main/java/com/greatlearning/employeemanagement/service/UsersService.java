package com.greatlearning.employeemanagement.service;

import java.util.List;

import com.greatlearning.employeemanagement.entity.Users;

//interface for defining services for Users entity
public interface UsersService {

	List<Users> listUsers();

	String addUser(Users user);

}
