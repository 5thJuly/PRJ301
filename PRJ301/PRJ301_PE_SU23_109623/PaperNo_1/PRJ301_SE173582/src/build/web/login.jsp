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
            UserID  <input type="text" name="userID" required=""/><br>
            Password<input type="password" name="password" required=""/><br>
            <input type="submit" name="action" value="Login">
            <input type="reset" value="Reset">
            
        </form>
        <%
            String error = (String) request.getAttribute("LOGIN_PAGE");
            if(error == null) {
                error = "";
            }
        %>
        <%=error%>
    </body>
    
</html>

