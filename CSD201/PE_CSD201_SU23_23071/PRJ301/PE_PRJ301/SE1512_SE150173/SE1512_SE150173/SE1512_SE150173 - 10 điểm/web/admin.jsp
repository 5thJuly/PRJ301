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

        <c:choose>
            <c:when test="${sessionScope.USER == null}">
                <p>You need to login to continue!</p>
                <a href="login.jsp">Login</a>
            </c:when>
            <c:when test="${!(sessionScope.USER.getRoleId().equals('AD'))}">
                <p>You do not have permission to access this page!</p>
                <a href="login.jsp">Login as admin</a>
            </c:when>
            <c:otherwise>
                <h1>Welcome ${sessionScope.USER.getFullName()}</h1>
                <form action="MainController">
                    <input type="submit" name="action" value="Logout"/>
                </form>
                <form action="MainController">
                    <input type="text" name="search" value="${param.search}"/>
                    <input type="submit" name="action" value="Search"/>
                    <input type="submit" name="action" value="GetAllAvailable"/>
                </form>

                <c:if test="${requestScope.FOOD_LIST.size() > 0}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>Food ID</th>
                                <th>Food Name</th>
                                <th>Description</th>
                                <th>Price</th>
                                <th>Cooking Time</th>
                                <th>Status</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="food" items="${requestScope.FOOD_LIST}"> 
                            <form action="MainController">
                                <tr>
                                    <td>
                                        ${food.getFoodId()}
                                        <input type="hidden" name="foodId" value="${food.getFoodId()}" />
                                    </td>
                                    <td>${food.getFoodName()}</td>
                                    <td>${food.getDescription()}</td>
                                    <td>${food.getPrice()}</td>
                                    <td>${food.getCookingTime()}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${food.getStatus() eq true}">Available</c:when>
                                            <c:otherwise>Inavaible</c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td><input type="submit" name="action" value="Remove"/></td>
                                </tr>
                            </form>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </c:otherwise>
    </c:choose>
</body>
</html>
