<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.BufferedReader, java.io.FileReader, java.io.IOException" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	table, th, td {
  		border: 1px solid;
  		text-align: center;
	}

	table {
  		width: 100%;
	}
</style>
<body>
	<table>
		<thead>
			<tr>
		    	<th>S.No.</th>
		    	<th>Name</th>
	    		<th>Employee Code</th>
    			<th>Employee Designation</th>
    			<th>Edit</th>
    			<th>Delete</th>
  			</tr>
		</thead>
  		
  		<tbody>
  			<% 
  				try (BufferedReader br = new BufferedReader(new FileReader("D:\\training java/EmployeeDetails.txt"));) {
            		String line;
            		
            		while ((line = br.readLine()) != null) { 
            %>
                <tr>
                    <td><%= line.split("\\|")[0] %></td>
                    <td><%= line.split("\\|")[1] %></td>
                    <td><%= line.split("\\|")[2] %></td>
                    <td><%= line.split("\\|")[3] %></td>
                    <td>
                    	<form id="updateForm" action="showUpdateEmpDetails" method="post">
                    			<input type="hidden" name="sNo" value="<%= line.split("\\|")[0] %>">
                    		 	<button type="submit">Edit</button> 
                    	</form>
                    </td>
                    <td>
                    	<form id="deleteForm" action="deleteEmpDetails" method="post">
                    			<input type="hidden" name="sNo" value="<%= line.split("\\|")[0] %>">
                    		 	<button onclick="deleteRecord()">Delete</button>
                    	</form>
                    </td>
                </tr>
                
           	<%
            		}
        		} 
  				catch (IOException e) {
            		e.printStackTrace();
        		}
           	%>
        </tbody>
	</table>
	
	<script>
	
		const delForm = document.getElementById('deleteForm');	
		
		function deleteRecord(){
			if(!confirm("Are you sure, you want to delete?"))	event.preventDefault();
				
		};
		
	</script>
</body>
</html>