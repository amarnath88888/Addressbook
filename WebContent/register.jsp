<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register in AddressBook</title>
</head>
<script type="text/javascript">
function validate()
{
 var fn=document.f1.firstName;
 var ln=document.f1.lastName;
 var un=document.f1.userName;
 var pw=document.f1.password;
 var rpw=document.f1.rpassword;
 var pno=document.f1.mobileNo;
 var email=document.f1.emailId;
 if(fn.value==0)
 {
  window.alert("Enter first name");
  fn.focus();
  return false;
 }
 if(ln.value==0)
 {
  window.alert("Enter last name");
  ln.focus();
  return false;
 }
 if(un.value==0)
 {
  window.alert("Enter user name");
  un.focus();
  return false;
 }
 if(pw.value==0)
 {
  window.alert("Enter Password");
  pw.focus();
  return false;
 }
 if(rpw.value==0)
 {
  window.alert("Enter Retype Password");
  rpw.focus();
  return false;
 }
 if(pw.value!=rpw.value)
 {
  window.alert("Password Didnot match!");
  rpw.focus();
  return false;
 }
 if(pno.value==0)
 {
  window.alert("Enter mobile no");
  pno.focus();
  return false;
 }
 if(email.value==0)
 {
  window.alert("Enter Email Address");
  email.focus();
  return false;
 }
}
function check()
{
 var m=document.f1.mobileNo.value;
 if(isNaN(m) || m.indexOf(" ")!=-1)
 {
  window.alert("Enter integer numbers");
  m.focus();
  return false;
 }
 if(m.length<10)
 {
  window.alert("Enter 10 digit mobile number");
  m.focus();
  return false;
 }
}
</script>
<body bgcolor=99ffcc>
<center>
<b>
<u>
<h2>Enter User Details</h2>
</u>
</b>
<hr>
<form action="signup" method="post" name="f1" onSubmit = "return validate()">
 First name <input type="text" name="firstName" size=20><br><br>
 Last name <input type="text" name="lastName" size=20><br><br>
 User name <input type="text" name="userName" size=20><br><br>
 Password <input type="password" name="password" size=20><br><br>
 Retype Password <input type="password" name="rpassword" size=20><br><br>
 Mobile no <input type="text" name="mobileNo" size=20 onChange="return check()"><br><br>
 Email ID <input type="text" name="emailId" size=35><br><br><br>
 <input type="submit" value="sign up">
 </form>
 <a href="home.jsp">Already have account? Sign in</a>
 </center>
 </body>
</html>