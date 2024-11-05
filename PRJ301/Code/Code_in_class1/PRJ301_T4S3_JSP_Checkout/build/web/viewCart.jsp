<%-- 
    Document   : viewCart.jsp
    Created on : 17-06-2023, 13:55:12
    Author     : Hi
--%>
<%@page import="sample.shopping.Cosmetics"%>
<%@page import="sample.shopping.Cart"%>
<%@page import="sample.shopping.Product"%>
<%@page import="java.util.List"%>
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
        <a href="shopping.html">Add more</a><br><br>
            
        <form action="MainController">           
            <input type="submit" name="action" value="Checkout"/>
        </form>
        
        <%
            List<Cosmetics> listPro = (List<Cosmetics>) request.getAttribute("LIST_PRODUCT");
            if (listPro != null){ 
                if (listPro.size() > 0){
            %>
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 1;
                        for (Cosmetics p : listPro){
                    
                    %>  
                    <form action="MainController">
                        
                        <tr>
                            <td><%= count++%></td>
                            <td><%= p.getId()%></td>
                            <td>                       
                                <%= p.getName()%>
                            </td>
                            <td>
                                <%= p.getPrice()%>$
                            </td>
                            <td><%= p.getQuantity()%></td>
                                                
                        </tr>
                    
                    </form>
                    <%
                        }
                    %>
                </tbody>
            </table>
                
            <%
                }
            }
        %>      
        
        
        <%
        if (listPro != null){ 
            if (listPro.size() > 0){
                for (Cosmetics c : cart.getCart().values()){
                    for (Cosmetics pro : listPro){
                        if (c.getId().equals("C01") && pro.getId().equals("C01") && c.getQuantity() > pro.getQuantity()){
                            %><div style="color:red"> Lipstick isn't enough for u to buy </div><%
                        }
                        else if (c.getId().equals("C02") && pro.getId().equals("C02") && c.getQuantity() > pro.getQuantity()){
                            %><div style="color:red"> Body Mist isn't enough for u to buy </div><%
                        }
                        else if (c.getId().equals("C03") && pro.getId().equals("C03") && c.getQuantity() > pro.getQuantity()){
                            %><div style="color:red"> Perfume isn't enough for u to buy </div><%
                        }
                        else if (c.getId().equals("C04") && pro.getId().equals("C04") && c.getQuantity() > pro.getQuantity()){
                            %><div style="color:red"> Sun Cream isn't enough for u to buy </div><%
                        }
                        if (c.getId().equals("C01") && pro.getId().equals("C01") && c.getQuantity() <= pro.getQuantity()){
                            %><div style="color:blue"> Lipstick is enough for u to buy </div><%
                        }
                        else if (c.getId().equals("C02") && pro.getId().equals("C02") && c.getQuantity() <= pro.getQuantity()){
                            %><div style="color:blue"> Body Mist is enough for u to buy </div><%
                        }
                        else if (c.getId().equals("C03") && pro.getId().equals("C03") && c.getQuantity() <= pro.getQuantity()){
                            %><div style="color:blue"> Perfume is enough for u to buy </div><%
                        }
                        else if (c.getId().equals("C04") && pro.getId().equals("C04") && c.getQuantity() <= pro.getQuantity()){
                            %><div style="color:blue"> Sun Cream is enough for u to buy </div><%
                        }
                    }
                }
            }
        }
        %>

    </body>
</html>
