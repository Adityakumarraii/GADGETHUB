package in.gadgethub.servlet;

import in.gadgethub.dao.CartDao;
import in.gadgethub.dao.impl.CartDaoImpl;
import in.gadgethub.dao.impl.DemandImpl;
import in.gadgethub.dao.impl.ProductDaoImpl;
import in.gadgethub.pojo.CartPojo;
import in.gadgethub.pojo.DemandPojo;
import in.gadgethub.pojo.ProductPojo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updateCart")
public class UpdateCartServlet extends HttpServlet {

    // Centralize logic here
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); 
        String userName = (session != null) ? (String) session.getAttribute("userName") : null;
        String userType = (session != null) ? (String) session.getAttribute("userType") : null;
        if (!"customer".equalsIgnoreCase(userType) || userName == null) {
            response.sendRedirect("login.jsp?message=Access denied! Please login first");
            return;
        }

        String prodId = request.getParameter("pid");
        int pQty = Integer.parseInt(request.getParameter("pQty"));

        ProductDaoImpl prodDao = new ProductDaoImpl();
        CartDao cartDao = new CartDaoImpl();

        ProductPojo product = prodDao.getProductDetails(prodId);
        int availableQty = product.getProdQuantity();

        String status;
        if (availableQty < pQty) {
            status = "Only " + availableQty + " of " + product.getProdName()
                   + " available. Added maximum you can.";
            // record demand
            boolean flag = new DemandImpl()
                .addProduct(new DemandPojo(userName, prodId, pQty - availableQty));
            if (flag) {
                status += "<br/>We’ll email you when " + product.getProdName() + " is back in stock.";
            }
        } else {
            status = cartDao
                .updateProductInCart(new CartPojo(userName, prodId, pQty));
        }

        request.setAttribute("message", status);
        // forward to show updated cart
        RequestDispatcher rd = request.getRequestDispatcher("CartDetailsServlet");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Either disallow GET, or forward to processRequest()
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }
}
