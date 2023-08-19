<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<form method="post" action="addUser" modelAttribute = "emp">
		<fieldset>
		
			<legend>Add</legend>
		
			<label>Employee Name</label>
			<input type="text" name="name" placeholder="Enter Name" required/>
		
			<label>Employee Code</label>
			<input type="text" name="empCode" placeholder="Enter emp_code" required/>
		
			<label>Employee Designation</label>
			<input type="text" name="designation" placeholder="Enter designation" required/>
			
			<button type="submit">Add</button>
		
		</fieldset>
	</form>
	
</body>
</html>