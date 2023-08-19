package com.fss.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Repository;

@Repository
public class DelUserDaoIMPL implements DelUserDao {
	
	private static String filePath = "D:\\training java/EmployeeDetails.txt";

	@Override
	public String getLineWithSNo(String sNo) {
		String line = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			
			while ((line = br.readLine()) != null) {
				if(sNo.equals(line.split("\\|")[0]))
					return line;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return line;
	}

	@Override
	public void delete(String matchLine) {
		
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(filePath));
			
			String line = "";
			String oldText = "";
			
			while ((line = br.readLine()) != null) { 	
				
                oldText += line + "\n";
            }

            String newText = oldText.replace(matchLine+"\n", "");
            
            FileWriter fw = null;
            
            try{
            	fw = new FileWriter(filePath);
				fw.write(newText);
			} 
            catch (Exception e) {
				e.printStackTrace();
			}
            finally {
				fw.close();
			}

			
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
		
	}

}
