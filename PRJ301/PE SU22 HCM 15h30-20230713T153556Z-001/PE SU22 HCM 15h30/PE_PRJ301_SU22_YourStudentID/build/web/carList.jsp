<%-- 
    Document   : carList
    Created on : 30-06-2022
    Author     : hd
--%>

<%@page import="pe.CarErrorDTO"%>
<%@page import="pe.user.UserDTO"%>
<%@page import="pe.CarDTO"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car List Page</title>
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
        Welcome:<h1> <%= loginUser.getFullName()%></h1>
        
        <form action="MainController">
            <input type="submit" name="action" value="Logout"/>
        </form>

        <form action="MainController">
            Search<input type="text" name="search" value="<%=search%>"/>
            <input type="submit" name="action" value="Search"/>
        </form>

        <%
           List<CarDTO> listUser = (List<CarDTO>) request.getAttribute("LIST_CAR");
           if (listUser != null) {
               if (listUser.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Speed</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count =1;
                    for(CarDTO car:listUser){
                %>
            <form action="MainController">

                <tr>
                    <td><%=count++%></td>
                    <td><%=car.getId()%></td>
                    <td><%=car.getName()%></td>
                    <td><%=car.getPrice()%></td>
                    <td><%=car.getSpeed()%></td>
                    <td><%=car.getDescription()%></td>
                    <td><%=car.isStatus()%></td>
                    <td><a href="MainController?action=Delete">Delete</a></td>
                    <td>
                        <input type="hidden" name="id" value="<%=car.getId()%>"/>
                        <input type="hidden" name="search" value="<%=search%>"/>
                        <input type="submit" name="action" value="Update"/>
                    </td>
                    
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
    <%=error%>
    <%
              }
          }
    %>
    


</body>
</html>
