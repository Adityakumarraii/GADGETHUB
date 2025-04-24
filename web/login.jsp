<!doctype html> 
<html lang="en"> 
  <head> 
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>Bootstrap demo</title> 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"> 
    <link rel="stylesheet" href="style.css"> 
    <style>/* Existing styles for the navbar (if any) */
.navbar-custom {
  background-color: #0d6efd;
}

.navbar-brand {
  font-size: 20px;
  color: white;
}

.navbar-brand:hover {
  color: yellow;
}

.navbar-custom,
.navbar-custom .nav-link {
  color: white;
  font-size: 20px;
}

.navbar-custom .nav-link:hover {
  color: yellow;
}

/* Styles for the login form */
.myform {
  background-color: #f8f8f8; /* Light white background */
  box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px,
    rgba(0, 0, 0, 0.3) 0px 30px 60px -30px,
    rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset;
  border-radius: 5px; /* Optional: Add rounded corners to the form */
  transition: transform 0.3s ease-in-out; /* Smooth transition for zoom */
}

.myform:hover {
  transform: scale(1.02); /* Slight zoom in on hover */
}

/* Optional: Zoom effect when the form or its content is focused */
.myform:focus-within {
  transform: scale(1.02);
}

/* You can adjust the styling of other elements within the form as needed */
.form-group label {
  font-weight: bold;
  color: #333; /* Darker text for labels */
}

.form-control {
  border: 1px solid #ccc;
}

.btn-primary {
  background-color: #0d6efd;
  border-color: #0d6efd;
}

.btn-primary:hover {
  background-color: #0b5ed7;
  border-color: #0a58ca;
}

.text-primary {
  color: #0d6efd !important;
}

.text-center p {
  margin-top: 10px;
}</style>
</head> 
  <body> 
      <jsp:include page="header.jsp"/>
      <%
          String message=request.getParameter("message");
          
      %>
    <div class="container mt-2 mb-3"> 
        <div class="row justify-content-center"> 
            <form action="./LoginServlet" class="col-md-4 myform rounded mt-3" method="post"> 
                <div class="text-center mt-3"> 
                    <h2 class="text-primary">Login Form</h2> 
                    <%
                        if(message!=null){%>
                        <p style="color:crimson;"><%=message %></p>
                    <%                                
                        }
                    %>
                </div> 
 
                <div class="row mt-3"> 
                    <div class="col-md-12 form-group"> 
                        <label for="username">Username</label> 
                        <input type="text" class="form-control" id="username" name="username"> 
                    </div> 
                </div> 
 
                <div class="row mt-3"> 
                    <div class="col-md-12 form-group"> 
                        <label for="password">Password</label> 
                        <input type="password" class="form-control" id="password" name="password"> 
                    </div> 
                </div> 
 
                <div class="row mt-3"> 
                    <div class="col-md-12 form-group"> 
                        <label for="loginas">Login As</label> 
                        <select name="userType" id="loginas" class="form-control"> 
                            <option value="customer">Customer</option> 
                            <option value="admin">Admin</option> 
                        </select> 
                    </div> 
                </div> 
 
                <div class="row mt-3 mb-3"> 
                    <div class="col-md-12 text-center"> 
                        <button type="submit" class="btn btn-primary">Login</button> 
                    </div> 
                </div> 
 
            </form> 
        </div> 
    </div> 
    <jsp:include page="footer.jsp"/>
   
  </body> 
</html>