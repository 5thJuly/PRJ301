<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>

<%@page import="pe.user.UserDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if(loginUser == null || !"AD".equals(loginUser.getRoleID())){
                response.sendRedirect("login.jsp");
                return;
            }
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        Welcome <%= loginUser.getFullName()%>
        
        <form action="MainController">           
            <input type="submit" name="action" value="Logout"/>
        </form>
        
        <form action="MainController">
            Search<input type="text" name="search" value="<%= search%>"/>
            <input type="submit" name="action" value="Search"/>
        </form>
        <%
            List<UserDTO> listUser = (List<UserDTO>) request.getAttribute("LIST_USER");
            if (listUser != null) {
                if (listUser.size() > 0) {
        %>
        
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Full Name</th>
                    <th>Role ID</th>
                    <th>Password</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (UserDTO user : listUser) {
                %>
                
            <form action="MainController">
                <tr>
                    <td><%= count++%></td>
                    <td><%= user.getUserID()%></td>
                    <td><%= user.getFullName()%></td>
                    <td><%= user.getRoleID()%></td>
                    <td><%= user.getPassword()%></td>
                    <td><%= user.getStatus()%></td>
                </tr>

            </form>
                <%
                    }
                %>
            </tbody>
        </table>

            <%
                    String error = (String) request.getAttribute("ERROR");
                    if(error == null) {
                        error = "";
                    }
                 %>
                 <%= error%>

        <%
                }
            }
        %>
        
    </body>
</html>