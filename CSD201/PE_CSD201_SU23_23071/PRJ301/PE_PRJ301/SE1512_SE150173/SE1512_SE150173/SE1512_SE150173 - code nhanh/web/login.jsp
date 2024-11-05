<%-- 
    Document   : login
    Created on : Mar 11, 2022, 9:02:11 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="main" method="post">
            <input type="text" name="user" value="">
            <input type="text" name="pass" value="">
            <input type="hidden" name="action" value="login">
            <input type="submit" value="Login">
        </form>
        ${loginfail}
    </body>
</html>
