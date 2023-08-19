<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.io.BufferedReader, java.io.FileReader, java.io.IOException" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

	body{
		display: flex;
		flex-direction: column;
		align-items: center;
	}
	
	form fieldset{
		display: flex;
		flex-direction: column;
		align-items: center;
		padding: 1rem 3rem;
		margin-top: 20px;
		margin-bottom: 10px;
		border-radius: 25px;
	}
	
	form legend{
		font-weight: 550;
		font-size: 16px;
	}
	
	label,input{
		padding: 10px 15px;
		border-radius: 25px;
	}
	
	button {
		border-radius: 25px;
		padding: 8px 25px;
		margin-top: 15px;
	}
	
	h4{
		color: red;
	}
</style>
</head>
<body>
	
	<form method="post" action="updateEmpDetails" modelAttribute="emp">
	
		<fieldset>
		
			<legend>Update</legend>
		
			<label>Employee Name</label>
			<input type="text" name="name" value="${ emp.getName() }" required/>
		
			<label>Employee Code</label>
			<input type="text" name="empCode" value="${ emp.getEmpCode() }" required/>
		
			<label>Employee Designation</label>
			<input type="text" name="designation" value="${ emp.getDesignation() }" required/>
			
			<input name="id" value="${ emp.getId() }" hidden/>
			
			<button type="submit">Update</button>
		
		</fieldset>
		
	</form>
	
</body>
</html>