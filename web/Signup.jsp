<%-- 
    Document   : Signup
    Created on : Mar 7, 2017, 8:00:38 PM
    Author     : Danny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <title>User Input Form</title>
</head>
 
<body>
<h2>User Input Form</h2>
<form method="post" action="formdata">
  <fieldset>
    <legend>Personal Particular</legend>
    Name: <input type="text" name="username" /><br /><br />
    Password: <input type="password" name="password" /><br /><br />
    Email:<input type="email" name="email" /><br /><br />
    Gender: <input type="radio" name="gender" value="m" checked />Male
    <input type="radio" name="gender" value="f" />Female
    <input type="radio" name= "gender" value = "Other">Other<br /><br />
    Age: <input type="number" name ="age" /><br /><br />
    <legend>Instruction</legend>
    <textarea rows="5" cols="30" name="instruction">Enter your bio</textarea>
  </fieldset>
 
 
 
  <input type="submit" value="SEND" />
  <input type="reset" value="CLEAR" />
</form>


</body>
</html>
