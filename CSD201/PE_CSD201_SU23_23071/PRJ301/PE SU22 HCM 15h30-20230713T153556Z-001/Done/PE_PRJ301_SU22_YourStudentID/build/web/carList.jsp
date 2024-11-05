<%-- 
    Document   : carList
    Created on : 30-06-2022
    Author     : hd
--%>

<%@page import="pe.CarErrorDTO"%>
<%@page import="pe.user.UserDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car List Page</title>
    </head>
    <body>
        <!--your code here-->
        <h1>Welcomes ${sessionScope['acc'].getFulName()}</h1>
        <a href="logout">logout</a>

        <form method="get" action="carList">
            Search: <input type="text" name="cname"> 
            <input type="submit" value="search">
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>price</th>
                    <th>speed</th>
                    <th>description</th>
                    <th>status</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="c" items="${clist}">
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.name}</td>
                        <td>${c.price}</td>
                        <td>${c.speed}</td>
                        <td>${c.description}</td>
                        <td>${c.status}</td>
                        <td><a href="delete?cid=${c.id}">delete</a></td>
                    </tr>
                </c:forEach>


            </tbody>
        </table>

    </body>
</html>
