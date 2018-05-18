<%-- 
    Document   : vote
    Created on : Mar 22, 2017, 5:15:36 PM
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
<form method="get" action="vote2">
  <fieldset>
    <legend>Vote for one</legend>
 	<p> What is your favorite color</p>
    Options: <input type="radio" name="options" value="blue" checked />Blue
    <input type="radio" name="options" value="green" />Green
    <input type="radio" name= "options" value = "purple" />Purple
    <input type="radio" name="options" value = "other" /> Other<br /><br />

  </fieldset>
 
 
 
  <input type="submit" value="SEND" />
  <input type="reset" value="CLEAR" />
</form>
</body>

</html>

