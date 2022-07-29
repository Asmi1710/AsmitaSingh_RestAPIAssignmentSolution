package com.greatlearning.employeemanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
//this defines the Role entity 
@Entity
@Table(name = "ROLE")
public class Role {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer id;
	
	@Column
	private String name;
	
	
	public Integer getId() {
		return id;
	}
	public Role() {
		super();
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Role(String name) {
		super();
	
		this.name = name;
	}
	
}

