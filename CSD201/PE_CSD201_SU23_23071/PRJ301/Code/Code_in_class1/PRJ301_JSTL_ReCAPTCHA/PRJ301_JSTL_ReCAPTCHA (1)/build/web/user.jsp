<%-- 
    Document   : user
    Created on : 31-05-2023, 14:30:40
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>

    <c:set var="loginUser" value="${sessionScope.LOGIN_USER}" />

    <c:choose>
        <c:when test="${empty loginUser or loginUser.roleID ne 'US'}">
            <c:redirect url="login.html" />
        </c:when>
        <c:otherwise>
            User's information: <br />
            UserID: ${loginUser.userID} <br />
            FullName: ${loginUser.fullName} <br />
            RoleID: ${loginUser.roleID} <br />
            Password: ${loginUser.password}
        </c:otherwise>
    </c:choose>

</html>
