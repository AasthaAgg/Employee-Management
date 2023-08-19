package com.fss.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Repository;

@Repository
public class AddUserDaoIMPL implements AddUserDao{

	@Override
	public String getLastLine() {
		String last = null;
		String line;
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("D:\\training java/EmployeeDetails.txt"));
					
			while ((line = br.readLine()) != null) 	last = line;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return last;
	}

	@Override
	public boolean addRecordInFile(String record) {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("D:\\training java/EmployeeDetails.txt", true);
			fw.append(record);
		} 
		catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}

}
