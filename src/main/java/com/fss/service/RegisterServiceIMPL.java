package com.fss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fss.dao.LoginRegisterDao;
import com.fss.model.Login;

@Service
public class RegisterServiceIMPL implements RegisterService {

	@Autowired
	LoginRegisterDao loginDao;
	
	@Override
	public boolean register(Login login) {
		return loginDao.registerUser(login);
	}

}
