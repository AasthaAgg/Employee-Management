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
		margin-top: 50px;
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
	
	<h4>${ msg }</h4>

	<form method="post" action="doRegister">
	
		<fieldset>
		
			<legend>Register</legend>
		
			<label>Enter E-mail</label>
			<input type="text" name="email" id="email" placeholder="e-mail" required/>
		
			<label>Enter Password</label>
			<input type="password" name="pwd1" id="password1" placeholder="Password" required/>
		
			<label>Enter Password again</label>
			<input type="password" name="pwd2" id="password2" placeholder="Password" required/>
		
			<button type="submit">Register</button>
			
		</fieldset>
	</form>
	
	<script>
		const form = document.querySelector('form');
				
		const emailRegex = /^([\w.-_]{5,})@(\w{2,})\.(\w{2,}).*$/;
		const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@_]).{8,}$/;

		form.addEventListener('submit', function(event) {
			
			event.preventDefault(); // Prevent form submission
	  		
			const email = document.getElementById('email').value;
			const pass1 = document.getElementById('password1').value;

	  		if(!emailRegex.test(email))
	  			alert('Please enter a valid email address');

	  		else if(!passwordRegex.test(pass1))
	  	  		alert('Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character');
	  	  	
	  		else
	  			form.submit();
		});
	</script>
		
</body>
</html>