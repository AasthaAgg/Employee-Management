package com.fss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fss.dao.UpdateDao;
import com.fss.model.Employee;

@Service
public class UpdateServiceIMPL implements UpdateService {

	@Autowired
	Employee emp;
	
	@Autowired
	UpdateDao updateDao;
	
	@Override
	public Employee getUserWithSNo(String sNo) {
		
		emp = updateDao.getEmpWithSNo(sNo);
		
		return emp;
		
	}
	
	@Override
	public void updateUser(Employee emp) {
		
		updateDao.updateUSerDetails(emp);
	}

}
