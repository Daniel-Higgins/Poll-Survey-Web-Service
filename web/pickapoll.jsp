<%-- 
    Document   : pickapoll
    Created on : Mar 22, 2017, 5:13:56 PM
    Author     : Danny
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pick a Poll</title>
    </head>
    <body>

        <h1>Pick a Poll from these options</h1>
        <p><%out.println(session.getAttribute("pollNames"));%></p>
        <form method="post" action="findpoll"> 
            Choice: <input type="text" name="choice" />
            <input type="submit" name="submit"/>
            
        </form>
 
        

    </body>
</html>