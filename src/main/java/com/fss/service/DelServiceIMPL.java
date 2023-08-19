package com.fss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fss.dao.DelUserDao;

@Service
public class DelServiceIMPL implements DelService {

	@Autowired
	DelUserDao del;
	
	@Override
	public void delLineWithSNo(String sNo) {
		String line = del.getLineWithSNo(sNo);
		
		del.delete(line);		
	}

}
