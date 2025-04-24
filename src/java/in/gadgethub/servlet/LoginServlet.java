package in.gadgethub.servlet;

import in.gadgethub.dao.impl.UserDaoImpl;
import in.gadgethub.pojo.UserPojo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response); // Handle GET requests the same way as POST
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        // * KEY CHANGE: Check for nulls FIRST *
        if (userName == null || password == null || userType == null) {
            String errorMessage = "Username, password, and user type are required.";
            request.setAttribute("error", errorMessage); // Set error message for display
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); // Redirect back to login
            rd.forward(request, response);
            return; // Stop processing to prevent NullPointerException
        }

        String status = "Login denied! Invalid userid or password";

        if (userType.equals("admin")) {
            if (userName.equals("admin@gmail.com") && password.equals("admin")) {
                System.out.println("yes");
                RequestDispatcher rd = request.getRequestDispatcher("./AdminViewServlet");
                HttpSession session = request.getSession();
                session.setAttribute("userName", userName);
                session.setAttribute("password", password);
                session.setAttribute("userType", userType);
                rd.forward(request, response);
            } else {
                request.setAttribute("message", status); // Use setAttribute
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); // Forward, not include
                rd.forward(request, response);
            }
        } else if (userType.equalsIgnoreCase("customer")) {
            System.out.println("done1");
            UserDaoImpl userDao = new UserDaoImpl();
            status = userDao.isValidCredentials(userName, password);
                         
            if (status.equalsIgnoreCase("Login Succesful")) {
                System.out.println("done, check");
                        
                UserPojo userPojo = userDao.getUserDetails(userName);
                HttpSession session = request.getSession();
                session.setAttribute("userdata", userPojo);
                session.setAttribute("userName", userName);
                session.setAttribute("password", password);
                session.setAttribute("userType", userType);
                RequestDispatcher rd = request.getRequestDispatcher("./UserHomeServlet");
                rd.forward(request, response);
            } 
           
            else {
                
                request.setAttribute("message", status); // Use setAttribute
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp?message="+status);
                //rd.include(request, response);// Forward, not include
                rd.forward(request, response);
            }
        }
    }

    // ... (getServletInfo() remains the same)
}