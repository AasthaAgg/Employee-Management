package com.fss.dao;

import com.fss.model.Login;

public interface LoginRegisterDao {
	
	public boolean loginUser(Login login);
	public boolean registerUser(Login login);
	
}
