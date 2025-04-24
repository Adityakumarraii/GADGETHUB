<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
 
<!DOCTYPE html> 
<html> 
    <head> 
        <title>Remove Product</title> 
        <meta charset="utf-8"> 
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"> 
 
        <link rel="stylesheet" href="mycss.css"> 
    </head> 
    <body style="background-color: #add8e6;"> 
        <% 
            String userName = (String) session.getAttribute("userName"); 
            String password = (String) session.getAttribute("password"); 
            String userType = (String) session.getAttribute("userType"); 
            if (userType == null || !userType.equalsIgnoreCase("admin")) { 
                response.sendRedirect("login.jsp?message=Access denied ! Please login as admin"); 
            } else if (userName == null || password == null) { 
                response.sendRedirect("login.jsp?message=Session expired ! Please login again"); 
            } 
        %> 
 
        <jsp:include page="header.jsp" /> 
 
        <% 
            String message=request.getParameter("message"); 
        %> 
        <div class="container"> 
            <div class="row justify-content-center m-4"> 
                <form action="./RemoveProductServlet" method="post" 
                      class="col-md-4 col-md-offset-4 myform p-3"> 
                    <div style="font-weight: bold;" class="text-center"> 
                        <h3 class="text-primary">Product Deletion Form</h3> 
                        <% if(message!=null) { 
                        %> 
                        <p style="color: blue;"> 
                           <%=message%> 
                        </p> 
                        <% 
                            } 
                        %> 
                    </div> 
                    <div></div> 
                    <div class="row"> 
                        <div class="col-md-12 form-group mt-3"> 
                            <label for="last_name">Product Id</label><input type="text" 
                                                                            placeholder="Enter Product Id" name="prodid" class="form-control" 
                                                                            id="last_name" required> 
                        </div> 
                    </div> 
                    <div class="row mt-3"> 
                        <div class="col-md-6 text-center" style="margin-bottom: 2px;"> 
                            <a href="AdminViewProductServlet" class="btn btn-info">Cancel</a> 
                        </div> 
                        <div class="col-md-6 text-center"> 
                            <button type="submit" class="btn btn-danger">Remove 
                                Product</button> 
                        </div> 
                    </div> 
                </form> 
            </div> 
        </div> 
 
        <%@ include file="footer.jsp"%> 
    </body> 
</html>