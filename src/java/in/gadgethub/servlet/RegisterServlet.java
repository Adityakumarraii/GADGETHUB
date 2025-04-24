package in.gadgethub.servlet;

import in.gadgethub.dao.impl.UserDaoImpl;
import in.gadgethub.pojo.UserPojo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name=request.getParameter("user_name");
        String email=request.getParameter("user_email");
        String address=request.getParameter("address");
        String mobileNumber=request.getParameter("mobile_number");
        int pinCode=Integer.parseInt(request.getParameter("pincode"));
        String password=request.getParameter("password");
        String cpassword=request.getParameter("cpassword");
        
        UserDaoImpl userDao=new UserDaoImpl();
        if(!password.equals(cpassword)){
            RequestDispatcher rd=request.getRequestDispatcher("register.jsp?message=Enter Valid Password");
            rd.forward(request, response);            
        }
        else if(userDao.isRegistered(email)){
            RequestDispatcher rd=request.getRequestDispatcher("register.jsp?message=User is Already Register.Click on <a href='login.jsp'>Login</a>");
            rd.forward(request, response);            
        }
        else if(mobileNumber.length()!=10){
            RequestDispatcher rd=request.getRequestDispatcher("register.jsp?message=Mobile Number must be 10 digit");
            rd.forward(request, response);            
        }
        else if(request.getParameter("pincode").length()!=6){
            RequestDispatcher rd=request.getRequestDispatcher("register.jsp?message=Please Enter Valid Pincode");
            rd.forward(request, response);            
        }
        
        UserPojo userPojo=new UserPojo();
        userPojo.setUsername(name);
        userPojo.setUseremail(email);
        userPojo.setPincode(pinCode);
        userPojo.setPassword(password);
        userPojo.setMobile(mobileNumber);
        userPojo.setAddress(address);
        String status=userDao.registerUser(userPojo);
        RequestDispatcher rd=request.getRequestDispatcher("login.jsp?message="+status);
            rd.forward(request, response);     
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}