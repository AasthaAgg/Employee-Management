package com.fss.dao;

import com.fss.model.Employee;

public interface UpdateDao {
	public Employee getEmpWithSNo(String sNo);

	public void updateUSerDetails(Employee emp);
}
