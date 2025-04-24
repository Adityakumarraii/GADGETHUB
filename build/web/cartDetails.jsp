<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
 pageEncoding="ISO-8859-1"%> 
<%@ page import="in.gadgethub.dao.impl.*,in.gadgethub.dao.*,in.gadgethub.pojo.*,javax.servlet.ServletOutputStream,java.io.*,java.util.*" %> 
 

<!DOCTYPE html>
<html>
<head>
    <title>Cart Details</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
    <link rel="stylesheet" href="mycss.css">
</head>
<body style="background-color: #add8e6;">

<jsp:include page="header.jsp" />

<div class="text-center h3 m-3 text-primary"></div>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Picture</th>
            <th>Products</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Add</th>
            <th>Remove</th>
            <th>Amount</th>
        </tr>
        </thead>
        <tbody>
        <%
            String userName = (String) request.getAttribute("userName");
            List<CartPojo> cartItems = (List<CartPojo>) request.getAttribute("cartItems");
            Map<String, Object> map = (Map<String, Object>) request.getAttribute("map");
            double totalAmount = 0.0;

            if (cartItems != null && map != null) {
                for (CartPojo item : cartItems) {
                    String prodId = item.getProdId();
                    int prodQuantity = item.getQuantity();
                    ProductPojo product = (ProductPojo) map.get(prodId);

                    if (product != null && prodQuantity > 0) {
                        double prodPrice = product.getProdPrice();
                        double currAmount = prodQuantity * prodPrice;
                        totalAmount += currAmount;
        %>
        <tr>
            <td><img src="./ShowImageServlet?pid=<%= product.getProdId() %>" style="width: 50px; height: 50px;"></td>
            <td><%= product.getProdName() %></td>
            <td><%= product.getProdPrice() %></td>
            <td>
                <form method="post" action="./UpdateCartServlet">
                    <input type="number" name="pQty" value="<%= prodQuantity %>" style="max-width: 70px;" min="0">
                    <input type="hidden" name="pid" value="<%= product.getProdId() %>">
                    <input type="submit" name="Update" value="Update" style="max-width: 80px;">
                </form>
            </td>
            <td>
                <a href="CartDetailsServlet?add=1&uid=<%= userName %>&pid=<%= product.getProdId() %>&avail=<%= product.getProdQuantity() %>&qty=<%= prodQuantity %>">
                    <i class="fa fa-plus"></i>
                </a>
            </td>
            <td>
                <a href="CartDetailsServlet?add=0&uid=<%= userName %>&pid=<%= product.getProdId() %>&avail=<%= product.getProdQuantity() %>&qty=<%= prodQuantity %>">
                    <i class="fa fa-minus"></i>
                </a>
            </td>
            <td><%= currAmount %></td>
        </tr>
        <%
                    }
                }
        %>
        <tr style="background-color: grey; color: white;">
            <td colspan="6" style="text-align: center;">Total Amount to Pay (in Rupees)</td>
            <td><%= totalAmount %></td>
        </tr>
        <%
            if (totalAmount != 0) {
        %>
        <tr style="background-color: grey; color: white;">
            <td colspan="4" style="text-align: center;"></td>
            <td>
                <form method="post">
                    <button formaction="UserHomeServlet" style="background-color: black; color: white;">Cancel</button>
                </form>
            </td>
            <td colspan="2" align="center">
                <form method="post">
                    <button style="background-color: blue; color: white;"
                            formaction="payment.jsp?amount=<%= totalAmount %>">Pay Now</button>
                </form>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="7" class="text-center text-danger">Cart is empty or session expired.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

<%@ include file="footer.jsp" %>

</body>
</html>