<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="in.gadgethub.pojo.UserPojo, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile Details</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="mycss.css">
</head>
<body style="background-color: #add8e6;">

    <%
        UserPojo userPojo = (UserPojo) request.getAttribute("user");

        // Check if userPojo is null and handle the error
        if (userPojo == null) {
    %>
        <div class="alert alert-danger text-center">
            <h3>User profile not found!</h3>
        </div>
    <%
            return; // Exit the page if the user profile is not found
        }
    %>

    <jsp:include page="header.jsp" />

    <div class="container mt-5 user-profile">
        <div class="row">
            <div class="col mt-3">
                <nav aria-label="breadcrumb" class="bg-warning rounded-3 p-3 mb-4">
                    <ol class="breadcrumb mb-0">
                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                        <li class="breadcrumb-item"><a href="userProfile.jsp">User Profile</a></li>
                    </ol>
                </nav>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-4">
                <div class="card mb-4">
                    <div class="card-body text-center">
                        <img src="images/profile.jpg" class="rounded-circle img-fluid w-25" alt="Profile Image">
                        <h5 class="my-3">Hello <%= userPojo.getUsername() %> here!!</h5>
                    </div>
                </div>

                <div class="card mb-4">
                    <div class="card-body p-0">
                        <ul class="list-group list-group-flush rounded-3">
                            <li class="text-center list-group-item d-flex justify-content-between align-items-center p-3">
                                <h3>My Profile</h3>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-lg-8">
                <div class="card mb-4">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Full Name</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0"><%= userPojo.getUsername() %></p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Email</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0"><%= userPojo.getUseremail() %></p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Phone</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0"><%= userPojo.getMobile() %></p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Address</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0"><%= userPojo.getAddress() %></p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">PinCode</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0"><%= userPojo.getPincode() %></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <br><br><br>

    <%@ include file="footer.jsp" %>

</body>
</html>