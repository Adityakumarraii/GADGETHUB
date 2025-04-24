package in.gadgethub.servlet;

import in.gadgethub.dao.impl.OrderDaoImpl;
import in.gadgethub.dao.impl.TransactionDaoImpl;
import in.gadgethub.dao.impl.UserDaoImpl;
import in.gadgethub.pojo.OrderPojo;
import in.gadgethub.utility.ItemDetails;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SONI
 */
public class ShippedItemServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        String password = (String) session.getAttribute("password");
        if (userName == null || password==null){
            response.sendRedirect("login.jsp?message=Access denied ! Please login as customer");
            return ;            
        }
        OrderDaoImpl orderDao=new OrderDaoImpl();
        List<OrderPojo> orders=orderDao.getShippedOrderDetails();      
        UserDaoImpl userDao=new UserDaoImpl();
        TransactionDaoImpl transaction=new TransactionDaoImpl();
        List<ItemDetails> shippedItems=new ArrayList<>();
        for(OrderPojo order:orders){
            String userId=transaction.getUserId(order.getOrderId());
            ItemDetails items=new ItemDetails();
            items.setTransId(order.getOrderId());
            items.setProdId(order.getProdId());
            items.setQuantity(order.getQuantity());
            items.setAdress(userDao.getUserAddr(userId));
            items.setUserName(userDao.getUserFirstName(userId));
            items.setPrice(order.getAmount());
            shippedItems.add(items);            
        }      
     RequestDispatcher rd=request.getRequestDispatcher("shippedItems.jsp");
        request.setAttribute("orders",shippedItems);        
        rd.include(request, response); 
       
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