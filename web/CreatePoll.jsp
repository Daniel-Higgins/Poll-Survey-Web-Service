<%-- 
    Document   : CreatePoll
    Created on : Mar 7, 2017, 9:25:25 PM
    Author     : Danny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
    </head>
    <body>
        <h1>Create your own poll!</h1>
        <form action="Create" method="post">
            <table align="center">
                <tr>
                    <th align="left">Name:</th>
                    <td><input type="text" name="name" placeholder="name of poll"</td>
                </tr>
                <tr>
                    <th align="left">Question:</th>
                    <td><input type="text" name="question" placeholder="question"</td>
                </tr>
                <br>
                <tr> 
                    <th align="left">Choice 1:</th>
                    <td><input type="text" name="choice1" placeholder="Choice 1"</td>
                </tr>
                <tr>
                    <th align="left">Choice 2:</th>
                    <td><input type="text" name="choice2" placeholder="Choice 2"</td>
                </tr>
                <tr>
                    <th align="left">Choice 3:</th>
                    <td><input type="text" name="choice3" placeholder="Choice 3"</td>
                </tr>
                <tr>
                    <td colspan="2" align="right"><input type="submit" value="Create Poll" class=""</td>
                </tr>
            </table>
        </form>
    </body>
</html>
