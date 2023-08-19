package com.fss.dao;

public interface DelUserDao {

	String getLineWithSNo(String sNo);

	void delete(String matchLine);

}
