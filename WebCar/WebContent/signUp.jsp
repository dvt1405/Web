<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
	<form action="loginServlet" method="get">
	<p> Name: <input type = "text" name = "name" > <br>
	<p> UserName: <input type = "text" name = "username" > <br>
	<p> Password: <input type = "password" name = "password" ><br>
	<p> Confirm Password: <input type = "password" name = "confirmpassword" > <br>
	<p> Avatar (Url): <input type = "text" name = "avatar" > <br>
	<p> Gender: <input type = "text" name = "gender" > <br>
	<p> Date Of Birth: <input type = "text" name = "dateofbirth" > <br>
	<p> <input type = "submit" value="Đăng kí" > 
	<input type = "submit" value ="Cancel" formmethod="get"> 
	
	</form>
</body>
</html>