<%-- 
    Document   : viewCart.jsp
    Created on : 17-06-2023, 13:55:12
    Author     : Hi
--%>
<%@page import="sample.shopping.Cosmetics"%>
<%@page import="sample.shopping.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
        <h1>Your selected products</h1>
        <%
          Cart cart = (Cart) session.getAttribute("CART");
          if (cart != null){
              if (cart.getCart().size() > 0){
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Edit</th>
                    <th>Remove</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total = 0;
                    for (Cosmetics elem : cart.getCart().values()){
                        total += elem.getQuantity()*elem.getPrice();
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%= count++%></td>
                    <td>
                        <input type="text" name="id" value="<%= elem.getId()%>" readonly=""/>
                    </td>
                    <td><%= elem.getName()%></td>
                    <td><%= elem.getPrice()%>$</td>
                    <td>
                        <input type="number" name="quantity" value="<%= elem.getQuantity()%>" min="1" required=""/>
                    </td>
                    <!--edit here-->
                    <td>
                        <input type="submit" name="action" value="Edit"/>
                    </td>
                    <!--remove here-->
                    <td>
                        <input type="submit" name="action" value="Remove"/>
                    </td>
                    
                    <td><%= elem.getQuantity()*elem.getPrice()%>$</td>
                </tr>
            </form>
                <%
                    }
                %>
            </tbody>
        </table>
        <h1>Total: <%= total%>$</h1>
        <%
                }
            }
        %>
        <a href="shopping.html">Add more</a>
    </body>
</html>
