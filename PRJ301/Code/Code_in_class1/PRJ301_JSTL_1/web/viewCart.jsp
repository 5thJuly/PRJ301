<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
        <h1>Your selected product is here !</h1>
        <c:set var="cart" value="${sessionScope.CART}" />

        <c:if test="${not empty cart and cart.cart.size() > 0}">
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
                    <c:set var="count" value="1" />
                    <c:set var="total" value="0" />
                    <c:forEach var="elem" items="${cart.cart}">
                        <c:set var="total" value="${total + elem.value.price * elem.value.quantity}" />
                    <form action="MainController" method="POST">
                        <tr>
                            <td>${count}</td>
                            <td>
                                <input type="text" name="id" value="${elem.value.id}" readonly=""/>
                            </td>
                            <td>${elem.value.name}</td>
                            <td>${elem.value.price}$</td>
                            <td>
                                <input type="number" value="${elem.value.quantity}" min="1" name="quantity" required=""/>
                            </td>
                            <td>
                                <input type="submit" name="action" value="Edit"/>
                            </td>
                            <td>
                                <input type="submit" name="action" value="Remove"/>
                            </td>
                            <td>${elem.value.price * elem.value.quantity}$</td>
                        </tr>
                    </form>
                    <c:set var="count" value="${count + 1}" />
                </c:forEach>
            </tbody>
        </table>
        <h1>Total: ${total}$</h1>
    </c:if>

    <a href="shopping.html">Add more</a>

    <form action="MainController" method="POST">
        <input type="submit" name="action" value="Checkout" />
    </form>
    <c:if test="${not empty LIST_PRODUCT}">
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
                <c:forEach items="${LIST_PRODUCT}" var="p" varStatus="status">
                <form action="MainController">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td>${p.price}$</td>
                        <td>${p.quantity}</td>
                    </tr>
                </form>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${not empty LIST_PRODUCT}">
    <c:forEach items="${cart.cart}" var="c" varStatus="cartStatus">
        <c:forEach items="${LIST_PRODUCT}" var="pro">
            <c:choose>
                <c:when test="${c.value.id eq 'C01' and pro.id eq 'C01' and c.value.quantity > pro.quantity}">
                    <div style="color:red">Lipstick isn't enough for you to buy</div>
                </c:when>
                <c:when test="${c.value.id eq 'C02' and pro.id eq 'C02' and c.value.quantity > pro.quantity}">
                    <div style="color:red">Body Mist isn't enough for you to buy</div>
                </c:when>
                <c:when test="${c.value.id eq 'C03' and pro.id eq 'C03' and c.value.quantity > pro.quantity}">
                    <div style="color:red">Perfume isn't enough for you to buy</div>
                </c:when>
                <c:when test="${c.value.id eq 'C04' and pro.id eq 'C04' and c.value.quantity > pro.quantity}">
                    <div style="color:red">Sun Cream isn't enough for you to buy</div>
                </c:when>
                <c:when test="${c.value.id eq 'C01' and pro.id eq 'C01' and c.value.quantity <= pro.quantity}">
                    <div style="color:green">Lipstick is enough for you to buy</div>
                </c:when>
                <c:when test="${c.value.id eq 'C02' and pro.id eq 'C02' and c.value.quantity <= pro.quantity}">
                    <div style="color:green">Body Mist is enough for you to buy</div>
                </c:when>
                <c:when test="${c.value.id eq 'C03' and pro.id eq 'C03' and c.value.quantity <= pro.quantity}">
                    <div style="color:green">Perfume is enough for you to buy</div>
                </c:when>
                <c:when test="${c.value.id eq 'C04' and pro.id eq 'C04' and c.value.quantity <= pro.quantity}">
                    <div style="color:green">Sun Cream is enough for you to buy</div>
                </c:when>
            </c:choose>
        </c:forEach>
    </c:forEach>
</c:if>



    </body>
</html>
