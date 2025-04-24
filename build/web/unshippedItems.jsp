<%@page import="in.gadgethub.utility.ItemDetails"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"/>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
      <%
          List<ItemDetails> orders=(List<ItemDetails>)request.getAttribute("orders"); 
                    
      %> 
      <div class="text-center h3 m-3 text-primary">UnShipped Items</div> 
    <div class="container-fluid mt-5 mb-5">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Transaction ID</th>
                        <th>Product ID</th>
                        <th>UserName</th>
                        <th>Address</th>
                        <th>Quantity</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for(ItemDetails order:orders){
                    %>
                    <tr>
                        <td><%=order.getTransId() %></td>
                        <td><a href="#"><%=order.getProdId() %></a></td>
                        <%
                            String userName=order.getUserName().substring(0,1).toUpperCase()+order.getUserName().substring(1);
                        %>
                        <td><%=userName %></td>
                        <td><%=order.getAdress() %></td>
                        <td><%=order.getQuantity() %></td>
                        <td class="text-primary">READY_TO_SHIP</td>
                        <td><a href="./UnshippedItemServlet?orderId=<%=order.getTransId()%>&prodId=<%=order.getProdId()%>" class="btn btn-warning">Ship Now</a></td>
                    </tr>
                    <%
                        }if(orders.isEmpty()){
                    %>
                    <tr class="text-center">
                        <td colspan="7">
                        No items Available</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>

            </table>
        </div>
    </div>
      <jsp:include page="footer.jsp"/>
    

   
  </body>
</html>