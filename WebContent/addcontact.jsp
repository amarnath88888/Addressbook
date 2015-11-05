<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add contact details into addressbook</title>
<%!
public boolean isValidUser(String userName){
	if(null == userName)
		return false;
	else
		return true;
}
%>
</head>
<body bgcolor=99ffcc>
<%
String userName = (String)session.getAttribute("userName");
boolean validUser = isValidUser(userName);
if(!validUser)	{
	request.getRequestDispatcher("home.jsp").forward(request, response);
}
%>
<center>
<h2>
Add contact
</h2>
<form action="addcontact" method="post" name="f1" onSubmit = "return validate()">
 Contact Name <input type="text" name="firstName" size=20><br><br>
 Mobile no <input type="text" name="mobileNo" size=20 onChange="return check()"><br><br>
 Email ID <input type="text" name="emailId" size=35><br><br><br>
 <input type="submit" value="Add contact">
 </form>
<center>
</body>
</html>