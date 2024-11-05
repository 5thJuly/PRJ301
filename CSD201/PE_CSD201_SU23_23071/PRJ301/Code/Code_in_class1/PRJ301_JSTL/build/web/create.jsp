<%-- 
    Document   : create.jsp
    Created on : 10-06-2023, 14:40:19
    Author     : Admin
--%>
<%@page import="sample.user.UserError"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
    </head>
    <body>
        <jsp:useBean id="USER_ERROR" class="sample.user.UserError">
            <jsp:setProperty name="USER_ERROR" property="userIDError" value="1234"/>
        </jsp:useBean>
        
        <form action="MainController" method="POST">
            User ID <input type="text" name="userID" required="" />
            ${pageScope.USER_ERROR.getUserIDError()} </br>
            <jsp:getProperty name="USER_ERROR" property="userIDError"/></br>
            
            FullName <input type="text" name="fullName" required="" />
            ${requestScope.USER_ERROR.getFullnameError()} </br>
            
            Role ID <input type="text" name="roleID" required="" />
            
            ${requestScope.USER_ERROR.getRoleIDError()}</br>
            
            Password<input type="password" name="password" required=""/>
            
            ${requestScope.USER_ERROR.passwordError}</br>
            
            Confirm<input type="password" name="confirm" required="" />
            
            $${requestScope.USER_ERROR.confirmPasswordError}</br>
            <input type="submit" name="action" value="Create"/>
            <input type="reset" value="Reset"/>
        </form>

        
    </body>
</html>
