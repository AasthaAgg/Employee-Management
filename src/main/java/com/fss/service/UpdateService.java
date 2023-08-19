package com.fss.service;

import com.fss.model.Employee;

public interface UpdateService {
	
	public Employee getUserWithSNo(String sNo);

	public void updateUser(Employee emp);
	
}
