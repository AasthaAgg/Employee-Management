<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
	
	p{
		font-size: 16px;
	}
	
</style>
</head>
<body>
	<h4>${ msg }</h4>

	<form method="post" action="login">
	
		<fieldset>
		
			<legend>Login</legend>
		
			<label>Enter e-mail</label>
			<input type="email" name="email" placeholder="e-mail" required/>
		
			<label>Enter Password</label>
			<input type="password" name="pwd" placeholder="Password" required/>
		
			<button type="submit">Login</button>
		
		</fieldset>
	
	</form>
	
	<p>Don't have an account!! <a href="register">Register</a> </p>
	
</body>
</html>