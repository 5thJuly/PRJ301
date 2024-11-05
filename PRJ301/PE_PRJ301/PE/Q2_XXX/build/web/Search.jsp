<%-- 
    Document   : Search
    Created on : 12-07-2023, 16:52:55
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST">
            <div>Account: <select name="username">
                    <c:forEach items="${accounts}" var="a">
                        <option value="${a.getUserName()}">${a.getDisplayName()}</option>
                    </c:forEach>    

                </select>
                <button>Search</button>
            </div>
        </form>
        <c:if test="${employees} != null">
            <div>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Employee ID</th>
                            <th>Name</th>
                            <th>DoB</th>
                            <th>Gender</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${employee}" var="e">
                            <tr> 
                                <td>${e.getEmpid()}</td>
                                <td>${e.getEmpname()}</td>
                                <td>${e.getDate()}</td>
                                <td>${e.getGender()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </body>
</html>
