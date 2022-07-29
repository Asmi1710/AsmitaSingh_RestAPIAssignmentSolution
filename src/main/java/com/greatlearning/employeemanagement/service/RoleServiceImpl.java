package com.greatlearning.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.entity.Role;
import com.greatlearning.employeemanagement.repository.RoleRepository;


@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	
	// this method adds new role to the database of roles
	@Override
	public String addNewRole(String name) {
		Role role = new Role();
		role.setName(name);
		roleRepository.save(role);
		return "New Role "+role+" saved to DB";
	}
}
