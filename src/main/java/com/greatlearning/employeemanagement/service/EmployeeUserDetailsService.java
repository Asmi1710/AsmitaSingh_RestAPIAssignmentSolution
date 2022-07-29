package com.greatlearning.employeemanagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.greatlearning.employeemanagement.entity.Users;
import com.greatlearning.employeemanagement.repository.UsersRepository;
import com.greatlearning.employeemanagement.security.MyCustomUserDetails;


@Repository
public class EmployeeUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		
		Users userEntity = userRepository.getUserByUsername(username);
		
		if (userEntity == null){
			// Throw exception
			throw new UsernameNotFoundException("Could not find user");
		}
		
		return new MyCustomUserDetails(userEntity);
	}
}

