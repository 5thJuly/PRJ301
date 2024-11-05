<%-- 
    Document   : login
    Created on : May 31, 2023, 2:22:28 PM
    Author     : Vaio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        input your information :
        <form action="MainController" method="POST">
            User ID<input type="text" name="userID" required=""/></br>
            Password<input type="password" name="password" required=""/></br>
            <input type="submit" name="action" value="Login"/>
            <input type="reset" value="Reset"/>
        </form>
        <%
            String error= (String) request.getAttribute("ERROR");
            if (error == null){
                error="";
            }
            %>
            
            <%= error%>
            
    </body>
</html>
