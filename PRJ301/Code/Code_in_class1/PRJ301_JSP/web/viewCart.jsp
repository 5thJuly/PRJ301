<%-- 
    Document   : viewCart
    Created on : 16-06-2023, 23:31:16
    Author     : Admin
--%>

<%@page import="sample.shopping.Comestic"%>
<%@page import="sample.shopping.Cart"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
        <h1>Your selected product is here !</h1>
        <%
            Cart c = (Cart) session.getAttribute("CART");
            if(c != null) {
                if(c.getCart().size() > 0) {
                    
        %>
        <table border = "1">
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
                    int count =1;
                    double total = 0;
                    for(Comestic elem : c.getCart().values()) {
                        total += elem.getPrice() * elem.getQuantity();
                    
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td><%= count++%></td>
                    <td>
                        <input type="text" name="id" value="<%=elem.getId()%>" readonly=""/>
                    </td>
                    <td><%=elem.getName()%></td>
                    <td><%=elem.getPrice()%>$</td>
                    <td>
                        <input type="number" value="<%=elem.getQuantity()%>" min="1" name="quantity" required=""/>
                        
                    </td>
                    <td>
                        <input type="submit" name="action" value="Edit"/>
                    </td>
                    
                    <td>
                        <input type="submit" name="action" value="Remove"/>
                    </td>
                    <td><%=elem.getPrice() * elem.getQuantity()%>$</td>
                    
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
