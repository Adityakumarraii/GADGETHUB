<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="in.gadgethub.utility.*"%>
<%@page import="in.gadgethub.pojo.ProductPojo"%>
<%@page import="in.gadgethub.dao.impl.ProductDaoImpl"%>
<%@page import="in.gadgethub.dao.impl.*,in.gadgethub.dao.*"%>
<%@page import="in.gadgethub.pojo.*,javax.servlet.ServletOutputStream,java.io.*"%>
<!DOCTYPE html>
<html>
<head>
    <title><%=AppInfo.appName%> Application</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="myCSS.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>

<body style="background-color:#add8e6;">
    <jsp:include page="header.jsp" />

    <div class="text-center m-3 text-primary h3"><%=request.getAttribute("message")%></div>
    <div class="container">
        <div class="row text-center">
            <%
            Map<String, Integer> mapList = (HashMap) request.getAttribute("map");
            String userName = (String) request.getAttribute("userName");
            List<ProductPojo> prodList = (ArrayList<ProductPojo>) request.getAttribute("products");

            if (prodList != null && mapList != null) {
                for (ProductPojo product : prodList) {
                    if (product != null && product.getProdId() != null) {
                        Integer cartQty = mapList.containsKey(product.getProdId()) ? mapList.get(product.getProdId()) : 0; //Default to 0 if no cart quantity.

                        if (cartQty == null) {
                            cartQty = 0; // Ensure cartQty is not null
                        }

            %>
            <div class="col-sm-4">
                <div class="thumbnail mt-3 mb-3">
                    <img src="./ShowImageServlet?pid=<%=product.getProdId()%>" alt="Product" style="height: 150px; max-width: 180px" class="mt-3" />
                    <p class="productname"><%=product.getProdName()%></p>
                    <%
                    String description = product.getProdInfo();
                    description = description.substring(0, Math.min(100, description.length()));
                    %>
                    <p class="productinfo"><%=description%>..</p>
                    <p class="price">Rs <%=product.getProdPrice()%></p>
                    <form method="post">
                        <% if (cartQty == 0) { %>
                        <button type="submit" formaction="./AddToCartServlet?uid=<%=userName%>&pid=<%=product.getProdId()%>&pqty=1" class="btn btn-warning">
                            Add to Cart
                        </button>
                        &nbsp;&nbsp;&nbsp;
                        <button type="submit" formaction="./AddToCartServlet?uid=<%=userName%>&pid=<%=product.getProdId()%>&pqty=1" class="btn btn-primary">
                            Buy Now
                        </button>
                        <% } else { %>
                        <button type="submit" formaction="./AddToCartServlet?uid=<%=userName%>&pid=<%=product.getProdId()%>&pqty=0" class="btn btn-danger">
                            Remove From Cart
                        </button>
                        &nbsp;&nbsp;&nbsp;
                        <button type="submit" formaction="cartDetails.jsp" class="btn btn-success">
                            Checkout
                        </button>
                        <% } %>
                    </form>
                    <br />
                </div>
            </div>
            <%
                    } else {
                        out.println("Product or product ID is null.");
                    }
                }
            } else {
                out.println("");
            }
            %>
        </div>
    </div>
    <%@ include file="footer.jsp"%>
</body>
</html>