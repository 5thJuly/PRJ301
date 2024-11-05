<%-- 
    Document   : login
    Created on : 31-05-2023, 14:24:11
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        Input your information:
        <form action ="MainController" method ="POST">
            UserID<input type="text" name="userID" required=""/></br>
            Password<input type="password" name="password" required=""/></br>
            <input type="submit" name="action" value="Login"/>
            <input type="reset" value="Reset">
        </form>
        
        ${requestScope.ERROR}
        
        </br></br><a href="MainController?action=CreatePage">Create user</a>
        <a href="MainController?action=ShoppingPage">Shopping Time</a>
        
        <a href="MainController?action=SelectTop3">Select TOP 3</a>
       
        
        
    </body>
</html>