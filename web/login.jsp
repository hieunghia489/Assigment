<%-- 
    Document   : login
    Created on : Aug 11, 2022, 2:32:20 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1 style="text-align:  center">Welcome to login page</h1>
        <form action="MainController" method="POST">       
            <table border="0">
                <thead>
                    <tr>
                        <th colspan="2">Login Form</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>User name</td>
                        <td><input type="text" name="txtUserName" value="" size="25"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="txtPassword" value="" size="26"/></td>
                    </tr>
                    <tr> 
                        <td><input type="submit" value="LOGIN" name="btAction" /></td> 
                        <td> <input type="reset" value="Reset" /> </td>
                    </tr>
                </tbody>
            </table>
        </form>
        <h3 style="color: red"> ${requestScope.Error}</h3>
        <a href="LoadDataController">Course Page</a><br/>
    </body>
</html>
