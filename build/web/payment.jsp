<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Payments</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<link rel="stylesheet" href="mycss.css">
</head>
<body style="background-color: #add8e6;">

 <%
 String userName= (String)session.getAttribute("userName");
 String password=(String) session.getAttribute("password");
 if(userName == null || password==null){
     response.sendRedirect("login.jsp?message=Session expired! Please login again");
 }
 String sAmount=request.getParameter("amount");
 double amount=0;
 if(sAmount!=null){
     amount=Double.parseDouble(sAmount);
 }
 java.util.Date today=new java.util.Date();
 int currYear=today.getYear()+1900;
 %>
        
 <jsp:include page="header.jsp" />

 <div class="container">
  <div class="row justify-content-center">
   <form action="./OrderServlet" method="post"
    class="col-md-6 col-md-offset-3 myform">
    <div class="text-center mt-3">
     <div class="form-group">
      <img src="images/gateway.png" alt="Payment Proceed" height="100px" />
      <h2 class="text-primary">Credit Card Payment</h2>
     </div>
    </div>
    <div class="row mt-3">
     <div class="col-md-12 form-group">
      <label for="last_name">Name of Card Holder</label> <input
       type="text" placeholder="Enter Card Holder Name"
       name="cardholder" class="form-control" id="last_name" required>
     </div>
    </div>
    <div class="row mt-3">
     <div class="col-md-12 form-group">
      <label for="last_name">Enter Credit Card Number</label> <input
       type="number" placeholder="4242-4242-4242-4242" name="cardnumber"
       class="form-control" id="last_name" required>
     </div>
    </div>
    <div class="row mt-3">
     <div class="col-md-6 form-group">
      <label for="last_name">Expiry Month</label> <input type="number"
       placeholder="MM" name="expmonth" class="form-control" size="2"
       max="12" min="00" id="last_name" required>
     </div>
     <div class="col-md-6 form-group">
      <label for="last_name">Expiry Year</label> <input type="number"
       placeholder="YYYY" class="form-control" size="4" id="last_name"
                                                        min="<%=currYear%>"                                      
       name="expyear" required>
     </div>
    </div>
    <div class="row mt-3 mb-3">
     <div class="col-md-6 form-group">
      <label for="last_name">Enter CVV</label> <input type="number"
       placeholder="123" class="form-control" size="3" id="last_name"
       name="expyear" required> <input type="hidden"
       name="amount" value="<%=amount%>">

     </div>
     <div class="col-md-6 form-group">
      <label>&nbsp;</label>
      <button type="submit" class="form-control btn btn-warning">
       Pay :Rs
       <%=amount%></button>
     </div>
    </div>
   </form>
  </div>
 </div>

 <!-- ENd of Product Items List -->


 <%@ include file="footer.jsp"%>

</body>
</html>