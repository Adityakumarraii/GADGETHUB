<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page import="java.util.*,in.gadgethub.pojo.*,in.gadgethub.dao.*,in.gadgethub.dao.impl.*,javax.servlet.*,java.io.*"%>

<!DOCTYPE html>
<html>
<head>
<title>View Products</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<link rel="stylesheet" href="mycss.css">
</head>
<body style="background-color: #add8e6;">

        <jsp:include page="header.jsp" />
        <div class="text-center h3 text-primary m-3"><%=request.getAttribute("message")%></div>
	<!-- Start of Product Items List -->
	<div class="container" style="background-color: #E6F9E6;">
		<div class="row text-center">
        	<%
                  List<ProductPojo >products=(ArrayList<ProductPojo>)request.getAttribute("products");
                  for(ProductPojo product:products){
		%>
			<div class="col-sm-4"s>
				<div class="thumbnail mt-3 mb-3">
					<img src="./ShowImageServlet?pid=<%=product.getProdId()%>" alt="Product"
						style="height: 150px; max-width: 180px;" class="mt-3">
					<p class="productname"><%=product.getProdName()%>
						(
                                                <%=product.getProdId()%>
						)
					</p>
					<p class="productinfo"><%=product.getProdInfo()%></p>
					<p class="price">
						Rs<%=product.getProdPrice()%>
					</p>

					<form method="post">
						<button type="submit"
							formaction="./RemoveProductServlet?prodid=<%=product.getProdId()%>"
							class="btn btn-danger">Remove Product</button>
						&nbsp;&nbsp;&nbsp;
						<button type="submit"
							formaction="./UpdateProductByIdServlet?prodid=<%=product.getProdId()%>"
							class="btn btn-primary">Update Product</button>
					</form>
<br>
				</div>
			</div>

			<%
			}
			%>

		</div>
	</div>
	<!-- ENd of Product Items List -->

	<%@ include file="footer.jsp"%>

</body>
</html>