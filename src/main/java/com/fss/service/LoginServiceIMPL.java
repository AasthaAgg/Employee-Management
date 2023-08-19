package com.fss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fss.dao.LoginRegisterDao;
import com.fss.model.Login;

@Service
public class LoginServiceIMPL implements LoginService{
	
	@Autowired
	LoginRegisterDao loginDao;
	
	@Override
	public boolean login(Login login) {
		boolean b = false;
		
		b = loginDao.loginUser(login);
		
		return b;
	}

		
}
