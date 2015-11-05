<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Addressbook ! This is the Home page</title>
</head>
<body bgcolor=99ffcc>
<center>
<h2>
Welcome !!! Login Now....
</h2>
<form method="post" action="signin">
 Username : <input type="text" name="userName"><br>
 Password : <input type="password" name="password"><br> <br>
 <input type="submit" value="Login">
</form>
<a href="register.jsp">New User ? Sign up !</a>
</center>
</body>
</html>