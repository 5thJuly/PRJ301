<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h2>WELCOME ${user.fullName}</h2>
        <form action="main" method="POST">
            <input type="submit" value="Logout" >
            <input type="hidden" name="action" value="logout">
        </form>
        <form action="main" method="get">
            <input type="text" name="name" value="">
            <input type="submit" value="Search" >
            <input type="hidden" name="action" value="search">
        </form>
        <c:if test="${list != null}" >
            <table border="1">
                <thead>
                    <tr>
                        <th>no</th>
                        <th>id</th>
                        <th>name</th>
                        <th>price</th>
                        <th>cooking Time</th>
                        <th>desciption</th>
                        <th>status</th>
                        <th>Dalat</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="o" varStatus="c" >
                        <tr>
                            <td>${c.count}</td>
                            <td>${o.id}</td>
                            <td>${o.name}</td>
                            <td>${o.price}</td>
                            <td>${o.cookTime}</td>
                            <td>${o.desc}</td>
                            <td>${o.status}</td>
                            <td>
                                <a href="main?action=delete&name=${o.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
    </body>
</html>
