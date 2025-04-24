<jsp:include page="header.jsp"/>
<!DOCTYPE html> 
<html lang="en"> 
  <head> 
    <meta charset="utf-8" /> 
    <meta name="viewport" content="width=device-width, initial-scale=1" /> 
    <title>Bootstrap demo</title> 
    <link 
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
      crossorigin="anonymous" 
    /> 
    <link rel="stylesheet" href="style.css"> 
  </head> 
  <style>/* Existing styles for the navbar (if any) */
.navbar-custom {
  background-color: #add8e6;
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
  <body> 
      <%
          String message=request.getParameter("message");
          if(message!=null){
      %>
      <div class="text-center m-3 text-primary h3"><%=message%></div>
      <%
          }
      %>
    <div class="container mt-3 mb-3"> 
      <div class="row justify-content-center"> 
          <form action="./RegisterServlet" method="post" class="col-md-6 myform"> 
          <div class="text-center mt-3"> 
            <h2 class="text-primary">Registration Form</h2> 
          </div> 
          <div class="row"> 
            <div class="col-md-6 form-group"> 
              <label for="user_name">Name</label> 
              <input type="text" name="user_name" class="form-control" id="user_name" required /> 
            </div> 
 
            <div class="col-md-6 form-group"> 
              <label for="user_email">Email</label> 
              <input type="text" name="user_email" class="form-control" id="user_email" required /> 
            </div> 
          </div> 
 
          <div class="form-group"> 
            <label for="address">Address </label> 
            <textarea name="address" id="address" class="form-control" required></textarea> 
          </div> 
 
          <div class="row"> 
            <div class="col-md-6 form-group"> 
              <label for="mobile">Mobile No.</label> 
              <input type="number" name="mobile_number" class="form-control" id="mobile" required/> 
            </div> 
 
            <div class="col-md-6 form-group"> 
              <label for="pincode">Pincode</label> 
              <input type="number" name="pincode" class="form-control" id="pincode" required/> 
            </div> 
          </div> 
 
          <div class="row"> 
            <div class="col-md-6 form-group"> 
              <label for="password">Password</label> 
              <input type="password" name="password" class="form-control" id="password" required /> 
            </div> 
 
            <div class="col-md-6 form-group"> 
              <label for="cpassword">Confirm Password</label> 
              <input type="password" name="cpassword" class="form-control" id="cpassword" required /> 
            </div> 
          </div> 
 
          <div class="row mt-3 mb-3 text-center"> 
 
            <div class="col-md-6 "> 
                <button type="reset" class="btn btn-danger">Reset</button> 
            </div> 
 
            <div class="col-md-6"> 
              <button type="submit" class="btn btn-primary">Register</button> 
            </div> 
          </div> 
 
        </form> 
      </div> 
    </div> 
      <jsp:include page="footer.jsp"/>
 
     
  </body> 
</html>