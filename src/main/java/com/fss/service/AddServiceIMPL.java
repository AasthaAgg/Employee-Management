package com.fss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fss.dao.AddUserDao;
import com.fss.model.Employee;

@Service
public class AddServiceIMPL implements AddService {

	@Autowired
	AddUserDao add;
	
	@Override
	public boolean addInFile(Employee emp) {
			
		String record = getSNo(add.getLastLine()) + "|" + emp.getName() + "|" + emp.getEmpCode() + "|" + emp.getDesignation() + "\n";
		
		boolean b = false;
		try {
			b = add.addRecordInFile(record);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	@Override
	public Integer getSNo(String line) {
		
		return Integer.parseInt(line.split("\\|")[0]) + 1;
	}
	
}
