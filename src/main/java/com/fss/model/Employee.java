package com.fss.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	private int id;
	private String name;
	private String empCode;
	private String designation;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpCode() {
		return empCode;
	}
	
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
