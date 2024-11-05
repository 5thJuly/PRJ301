<%-- 
    Document   : user
    Created on : May 31, 2023, 2:30:39 PM
    Author     : Vaio
--%>

<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"US".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.html");
                loginUser = new UserDTO();
            }
        %>
        User's information :
        User ID <%= loginUser.getUserID()%> </br>
        Full Name <%= loginUser.getFullName()%> </br>
        Role ID <%= loginUser.getRoleID()%> </br>
        Password <%= loginUser.getPassword()%> </br>
    </body>
</html>
