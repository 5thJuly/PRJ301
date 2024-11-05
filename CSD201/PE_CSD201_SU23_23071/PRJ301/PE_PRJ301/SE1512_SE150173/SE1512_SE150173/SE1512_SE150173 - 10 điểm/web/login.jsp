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
        <form action="MainController" method="POST">
            User ID 
            <input type="text" name="userId" required /> <br />
            Password 
            <input type="password" name="password" required /> <br />
            <input type="submit" name="action" value="Login" />
        </form>
        ${requestScope.LOGIN_ERROR}
    </body>
</html>
