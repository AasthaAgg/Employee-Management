package com.fss.service;

import com.fss.model.Employee;

public interface AddService {

	boolean addInFile(Employee emp);

	Integer getSNo(String line);

}
