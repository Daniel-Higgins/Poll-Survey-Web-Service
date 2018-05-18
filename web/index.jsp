<%-- 
    Document   : index
    Created on : Feb 15, 2017, 5:24:16 PM
    Author     : Danny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>
    </head>
    <body><br><br><br>
        <center><h1>Login</h1></center>
        <br><br>
        <form action="Controller" method="POST">
            <table align="center">
                <tr>
                    <th align="right">UserName:</th>
                    <td><input type="text" name="txtusername" placeholder="UserName"</td>
                </tr>
                <tr>
                    <th align="right">Password:</th>
                    <td><input type="password" name="txtpassword" placeholder="Password"</td>
                </tr>
                <tr>
                    <td colspan="2" align="right"><input type="submit" value="Log In" class=""</td>
                </tr>
               
            </table>    
        </form>
        <form action="Stateless" method="POST">
            <table align="center">
            <pre>                                                         Don't have an account? Vote as guest!</pre>
            <td colspan="2" align="right"><input type="submit" value="Guest" class=""></td>
            </table>
        </form>
         <form action ="Signup.jsp" method="get">
            <table align="center">
                <center><pre>Or signup and make an account</pre></center>
                <td colspan="2" alight="right"><input type="submit" value ="signup" class="">
            </table>
        </form>
    </body>
</html>