<%-- 
    Document   : shopping
    Created on : 17-06-2023, 00:15:44
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cometics STORE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>My Store</h1>
        <form action="MainController" method="POST">
            <select name="cmbComestic">
                <option value="C01-Lipstick-100">Lipstick-100$</option>
                <option value="C02-Body Mist-200">Body Mist-200$</option>
                <option value="C03-Perfume-350">Perfume-350$</option>
                <option value="C04-Sun Cream-50">Sun Cream-50$</option>
                
            </select>
            <select name="cmbQuantity">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="10">10</option>

            </select>
            <input type="submit" name="action" value="Add"/>
            <input type="submit" name="action" value="View"/>
        </form>
        <%
            String message = (String) request.getAttribute("MESSAGE");
            if(message == null) message="";
        %>
        <%= message %>
    </body>
    
</html>
