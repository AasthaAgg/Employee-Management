package com.fss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fss.model.Login;

@Repository
public class LoginRegisterDaoIMPL implements LoginRegisterDao {
	@Autowired
	CreateConnection connection;
	
	@Autowired
	LoginRegisterDaoIMPL loginDao;

	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	@Override
	public boolean loginUser(Login login) {
		try {
			con = connection.getConnection();
			ps = con.prepareStatement("select * from employeeLoginDetails where username=? and password=?");
            ps.setString(1, login.getEmail());
            ps.setString(2, login.getPassword());
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                return true;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}


	@Override
	public boolean registerUser(Login login) {
		
		try
        {
			con = connection.getConnection();
			ps = con.prepareStatement("insert into employeeLoginDetails (username, password) values (?, ?)");
            ps.setString(1, login.getEmail());
            ps.setString(2, login.getPassword());
            
            int i = ps.executeUpdate();
            
            if(i>0)
            {
                return true;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
}
