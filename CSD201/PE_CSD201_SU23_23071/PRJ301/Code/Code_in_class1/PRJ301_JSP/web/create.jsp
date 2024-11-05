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
        <%
            UserError userERROR = (UserError) request.getAttribute("USER_ERROR");
            if(userERROR == null) {
                userERROR = new UserError();
            }
        %>
        <form action="MainController" method="POST">
            User ID<input type="text" name="userID" required=""/><%= userERROR.getUserIDError()%>
            </br>FullName<input type="text" name="fullName" required=""/><%= userERROR.getFullNameError()%>
            </br>Role ID<input type="text" name="roleID" value="US" readonly=""/>
            </br>Password<input type="password" name="password" required=""/>
            </br>Confirm<input type="password" name="confirm" required=""/><%= userERROR.getConfirmError()%>
            </br><input type="submit" name="action" value="Create"/>
            <input type="reset" value="Reset"/>
            <%= userERROR.getError()%>

        </form>
    </body>
</html>
