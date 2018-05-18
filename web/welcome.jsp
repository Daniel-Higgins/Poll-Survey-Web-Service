<%-- 
    Document   : welcome
    Created on : Feb 15, 2017, 5:36:46 PM
    Author     : Danny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h2>Welcome User</h2>
        
        <p><%=session.getAttribute("Name")%> </p>
        <p><%=session.getAttribute("Email")%> </p>
        <p><%=session.getAttribute("Age")%> </p>
        <p><%=session.getAttribute("Gender")%> </p>
        <p><%=session.getAttribute("Bio")%> </p>
        
        <form action="CreatePoll.jsp" method="post">
            <table align="center">
                <center><pre>Create a new poll</pre></center>
                <td colspan="2" alight="right"><input type="submit" value="Create a poll" class=""></td>
            </table>
        </form>
        
        <form action="pickapoll.jsp" method="post">
            <table align="center">
                <center><pre></pre></center>
                <td colspan="2" alight="right"><input type="submit" value="Vote on a Poll" class=""></td>
            </table>
        </form>
    </body>
</html>
