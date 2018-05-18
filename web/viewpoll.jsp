<%-- 
    Document   : viewpoll
    Created on : Mar 22, 2017, 5:11:45 PM
    Author     : Danny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Poll Booth</title>
    </head>
    <body>
        <h2>User Input Form</h2>
<form method="get" action="vote2">
  
  <fieldset>
    <legend>Vote for one</legend>
    <%out.println(session.getAttribute("name"));%>
    <p> <%out.println(session.getAttribute("question"));%> </p>
    
    Options: <input type="radio" name="options" value= "c1" checked /><%out.println(session.getAttribute("c1"));%>
    <input type="radio" name="options" value= "c2" /><%out.println(session.getAttribute("c2"));%>
    <input type="radio" name="options" value = "c3" /> <%out.println(session.getAttribute("c2"));%><br /><br />

  </fieldset>
 
 
 
  <input type="submit" value="SEND" />
  <input type="reset" value="CLEAR" />
</form>
    </body>
</html>
