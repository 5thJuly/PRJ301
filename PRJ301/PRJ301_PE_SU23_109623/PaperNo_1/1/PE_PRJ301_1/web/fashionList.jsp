<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>

<%@page import="pe.utils.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="pe.utils.ClothesDTO"%>

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
            if(loginUser == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            String search = request.getParameter("search");
            if(search == null) {
                search = "";
            }
        %>
        Welcome:<%=loginUser.getFullName()%>
        <form action="MainController">
            <input type="submit" name="action" value="Logout">
        </form>
        
        <form action="MainController">
            Search<input type="text" name="search" value="<%=search%>"/>
            <input type="submit" name="action" value="Search"/>
        </form>
            
            <%
                List<ClothesDTO> listClothes =(List<ClothesDTO>) request.getAttribute("LIST_CLO");
                if(listClothes != null) {
                    if(listClothes.size() > 0) {
                
            %>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>price</th>
                        <th>size</th>
                        <th>status</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count =1;
                        for(ClothesDTO cl : listClothes){
                    %>
                    <tr>
                        <td><%=count++%></td>
                        <td><%=cl.getId()%></td>
                    <td><%=cl.getName()%></td>
                    <td><%=cl.getPrice()%></td>
                    <td><%=cl.getSize()%></td>
                    <td><%=cl.getDescription()%></td>
                    <td><%=cl.isStatus()%></td>
                    </tr>
                    
                </tbody>
            </table>

    </body>
</html>
