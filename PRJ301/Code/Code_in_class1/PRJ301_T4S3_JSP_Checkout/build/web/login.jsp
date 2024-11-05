<%-- 
    Document   : login
    Created on : 31-05-2023, 14:26:23
    Author     : Hi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        Input your information:
        <form action="MainController" method="POST"> 
            User ID<input type="text" name="userID" required=""/></br>
            Password<input type="password" name="password" required=""/></br>
            <input type="submit" name="action" value="Login"/>
            <input type="reset" value="Reset"/>      
        </form>
        <a href="MainController?action=CreatePage">Create user</a></br>
        <a href="MainController?action=ShoppingPage">Quynh's Store</a>
    </body>
    <%
        String error = (String) request.getAttribute("ERROR");
        if (error == null){
            error = "";
        }
    %>
    <%= error%>
</html>
