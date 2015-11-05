<%@page import="org.apache.catalina.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To Addressbook</title>
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
Welcome <%=userName %>
<form action="logout" method="post">
<input type="submit" value="logout" align="right"></form>
<br><br>
<a href="addcontact.jsp">add contact</a><br>
<a href="searchcontact.jsp">view contact</a><br>
</body>
</html>