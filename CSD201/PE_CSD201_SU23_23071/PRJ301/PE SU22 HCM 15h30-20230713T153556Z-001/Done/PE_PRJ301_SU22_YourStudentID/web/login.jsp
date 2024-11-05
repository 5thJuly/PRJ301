<%-- 
    Document   : login
    Created on : 30-06-2022
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
        <!--your code here-->
        <h1>Login information</h1>
        <form method="post" action="login">
            UserName: <input type="text" name="uname"><br>
            Password: <input type="password" name="pass"><br>
            <input type="submit" value="submit">
        </form>
        ${mess}
    </body>
    
</html>

