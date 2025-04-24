package in.gadgethub.servlet;

import in.gadgethub.dao.impl.ProductDaoImpl;
import in.gadgethub.pojo.ProductPojo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        String password = (String) session.getAttribute("password");
        String userType = (String) session.getAttribute("userType");

        if (userType == null || !userType.equalsIgnoreCase("admin")) {
            response.sendRedirect("login.jsp?message=Access denied ! Please login as admin");
            return; // Important: Stop further processing
        } else if (userName == null || password == null) {
            response.sendRedirect("login.jsp?message=Session expired ! Please login again");
            return; // Important: Stop further processing
        }

        ProductDaoImpl productDao = new ProductDaoImpl();
        String search = request.getParameter("search");
        String type = request.getParameter("type");
        String message = "All Products";
        List<ProductPojo> products = new ArrayList<>();

        if (search != null) {
            products = productDao.searchAllProducts(search);
            message = "Showing results for '" + search + "'";

        } else if (type != null) {
            products = productDao.getAllProductsByType(type);
            message = "Showing results for '" + type + "'";
        } else {
            products = productDao.getAllProducts();

        }
        if (products.isEmpty()) {
            products = productDao.getAllProducts();
            message = "No items found for '" + (search != null ? search : type) + "'";
        }
        RequestDispatcher rd = request.getRequestDispatcher("adminViewProduct.jsp");
        request.setAttribute("userName", userName);
        request.setAttribute("message", message);
        request.setAttribute("products", products);
        rd.forward(request, response);
    }
}