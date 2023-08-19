package com.fss.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fss.model.Employee;

@Repository
public class UpdateDaoIMPL implements UpdateDao {

	@Autowired
	Employee emp;
	
	private static String filePath = "D:\\training java/EmployeeDetails.txt";
	
	@Override
	public Employee getEmpWithSNo(String sNo) {
		
		String line = "";
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(filePath));
			
			while ((line = br.readLine()) != null) {
				if(sNo.equals(line.split("\\|")[0])) {
					emp.setId(Integer.parseInt(line.split("\\|")[0]));
					emp.setName(line.split("\\|")[1]);
					emp.setEmpCode(line.split("\\|")[2]);
					emp.setDesignation(line.split("\\|")[3]);

					return emp;
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public void updateUSerDetails(Employee emp) {
		String line = "";
		String text = "";
				
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			
			while ((line = br.readLine()) != null) {
				if(emp.getId() == (Integer.parseInt(line.split("\\|")[0]))) {
					line = emp.getId() + "|" + emp.getName() + "|" + emp.getEmpCode() + "|" + emp.getDesignation();
				}
				text += line + "\n";
			}
			
			try(FileWriter fw = new FileWriter(filePath);) {
				fw.write(text);
			} 
            catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch (Exception e) {
			
			e.printStackTrace();
			 
		}
	}
	
}
