<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="sample.user.UserDTO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <tittle><h1>Uoc duoc dep trai hon thay Hoa <3</h1></tittle>
    </head>
    <body>
        <c:set var="list" value="${requestScope.LIST_TOP}" />

    <c:if test="${not empty list and list.size() > 0}">
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>UserID</th>
                    <th>FullName</th>
                    <th>RoleID</th>
                    <th>Password</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="count" value="1" />
                <c:forEach items="${list}" var="user">
                    <form action="MainController">
                        <tr>
                            <td><c:out value="${count}" /></td>
                            <td>${user.userID}</td>
                            <td>${user.fullName}</td>
                            <td>${user.roleID}</td>
                            <td>${user.password}</td>
                        </tr>
                    </form>
                        <c:set var="count" value="${count + 1}" />
                </c:forEach>
            </tbody>
        </table>
    </c:if>

</body>
</html>