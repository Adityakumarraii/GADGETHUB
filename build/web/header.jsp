<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="in.gadgethub.dao.impl.*,in.gadgethub.dao.*,in.gadgethub.utility.*" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Logout Header</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            />

        <link rel="stylesheet" href="mycss.css" />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
            />
    </head>
    <body style="background-color: #2196F3">
        <%
            String userType = (String) session.getAttribute("userType");
            if (userType == null) {

                //GUEST
%>

        <nav class="navbar navbar-expand-lg navbar-custom" style="background-color: #1976D2;">
            <div class="container-fluid">
                <a class="navbar-brand" href="LandingServlet" style="color: white;">
                    <%=AppInfo.appName%>
                </a>
                <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarNav"
                    aria-controls="navbarNav"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                    >
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <jsp:include page="category.jsp" />
                        <li class="nav-item">
                            <a class="nav-link" href="./LandingServlet" style="color: white;">Products</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp" style="color: white;">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="register.jsp" style="color: white;">Register</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <% } else if (userType.equalsIgnoreCase("Customer")) {
            //String userName = (String) request.getAttribute("userName");
            String userName = (String) session.getAttribute("userName");
            CartDaoImpl cartDao = new CartDaoImpl();
            int notf = cartDao.getAllCartItems(userName).size();
        %>
        <nav class="navbar navbar-expand-lg navbar-custom" style="background-color: #1976D2;">
            <div class="container-fluid">
                <a class="navbar-brand" href="UserHomeServlet" style="color: white;">
                    <%=AppInfo.appName%>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <jsp:include page="category.jsp" />
                        <li class="nav-item">
                            <a href="./UserHomeServlet" class="nav-link" style="color: white;">Products</a>
                        </li>
                        <%
                            if (notf == 0) {
                        %>
                        <li class="nav-item"><a class="nav-link" href="./CartDetailsServlet" style="color: white;"><span
                                    class="glyphiconglyphicon-shopping-cart"></span>Cart
                                </a></li>

                        <%
                            } else {
                        %>
                        <li class="nav-item"><a class="nav-link" href="./CartDetailsServlet"
                                                style="margin: 0px; padding: 0px; color: white;" id="mycart"><i
                                    data-count="<%=notf%>"
                                    class="fa fa-shopping-cart fa-3x icon-white badge"
                                    style="background-color: #64B5F6; margin: 0px; padding: 0px; padding-bottom: 0px; padding-top: 5px;">
                                </i></a></li>
                                <%
                                    }
                                %>
                        <li class="nav-item"><a class="nav-link" href="./OrderServlet" style="color: white;">Orders</a></li>
                        <li class="nav-item"><a class="nav-link" href="./UserProfileServlet" style="color: white;">Profile</a></li>
                        <li class="nav-item"><a class="nav-link" href="./LogoutServlet" style="color: white;">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <%
            } else {%>
        <nav class="navbar navbar-expand-lg navbar-custom" style="background-color: #1976D2;">
            <div class="container-fluid">
                <a class="navbar-brand" href="./AdminViewServlet" style="color: white;">
                    <%=AppInfo.appName%>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="./AdminViewServlet" style="color: white;">Products</a>
                        </li>
                        <li class="nav-item dropdown">

                            <jsp:include page="category.jsp" />
                        </li>
                        <li class="nav-item"><a class="nav-link" href="./AdminStockServlet" style="color: white;">Stock</a></li>
                        <li class="nav-item"><a class="nav-link" href="./ShippedItemServlet" style="color: white;">Shipped</a></li>
                        <li class="nav-item"><a class="nav-link" href="./UnshippedItemServlet" style="color: white;">Orders</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                               aria-expanded="false" style="color: white;">
                                Update Item
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a href="addproduct.jsp" class="dropdown-item">Add Product</a></li>
                                <li><a href="removeProduct.jsp" class="dropdown-item">Remove Product</a></li>
                                <li><a href="updateProductById.jsp" class="dropdown-item">Update Product</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./LogoutServlet" style="color: white;">Logout</a>
                        </li>

                    </ul>
                </div>
            </div>
        </nav>


        <%}
        %>
        <div class="container-fluid text-center mt-0 p-3"
        style="background-color: #64B5F6; color: white;">



                <h2><%=AppInfo.appName%></h2>
                <h6>We specialize in Electronics</h6>
                <form class="form-inline" action="LandingServlet" method="get">
                    <div class="input-group">
                        <input
                            type="text"
                            class="form-control"
                            name="search"
                            placeholder="Search Items"
                            required
                            />

                        <input type="submit" class="btn btn-primary" value="Search" />
                    </div>
                </form>
                <p
                    align="center"
                    style="
                    color: #64B5F6;
                    font-weight: bold;
                    margin-top: 5px;
                    margin-bottom: 5px;
                    "
                    id="message"
                    >

                </p>
            </div>
            </body>
</html>