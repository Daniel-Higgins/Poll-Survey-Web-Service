<%-- 
    Document   : viewresults
    Created on : Mar 22, 2017, 5:09:09 PM
    Author     : Danny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP</title>
    </head>
    <body>
         <p><%out.println(session.getAttribute("name"));%> </p>
        <p><%out.println(session.getAttribute("a1"));%> <%out.println(session.getAttribute("c1"));%></p>
        <p><%out.println(session.getAttribute("a2"));%> <%out.println(session.getAttribute("c2"));%></p>
        <p><%out.println(session.getAttribute("a3"));%> <%out.println(session.getAttribute("c3"));%></p>
        <p><a href ="http://localhost:8080/Poll/Welcome.jsp"> Back to home page</a></p>
    </body>
</html>
