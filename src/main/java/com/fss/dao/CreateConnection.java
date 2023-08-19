package com.fss.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Repository;

@Repository
public class CreateConnection {

	public static final String user="SYSTEM";
    public static final String pwd="xxxxxxx";
    public static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	    
    static {
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");	// to load driver
	    }
	    catch(Exception e) {
	             
	    }
	}
	    
	public static Connection getConnection() {
	        Connection con = null;
	        
	        try {
	        	con = DriverManager.getConnection(url, user, pwd);
	        }
	        catch(Exception e) {
	            
	        }
	        
	        return con;
	    }
}
