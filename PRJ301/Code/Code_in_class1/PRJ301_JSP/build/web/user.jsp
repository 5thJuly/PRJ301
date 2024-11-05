<%-- 
    Document   : user
    Created on : 31-05-2023, 14:30:40
    Author     : Admin
--%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if(loginUser == null || !"US".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.html");
                return;
            }
        %>
        User's information: </br>
        UserID: <%= loginUser.getUserID()%></br>
        FullName: <%= loginUser.getFullName()%></br>
        RoleID: <%= loginUser.getRoleID()%></br>
        Password: <%= loginUser.getPassword()%>
    </body>
</html>
