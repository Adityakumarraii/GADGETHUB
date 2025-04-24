package in.gadgethub.servlet;

import in.gadgethub.dao.impl.ProductDaoImpl;
import in.gadgethub.pojo.ProductPojo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        String password = (String) session.getAttribute("password");
        String userType = (String) session.getAttribute("userType");

        if (userType == null || !userType.equalsIgnoreCase("admin")) {
            response.sendRedirect("login.jsp?message=Access denied! Please login as admin");
            return;
        } else if (userName == null || password == null) {
            response.sendRedirect("login.jsp?message=Session expired! Please login again");
            return;
        }

        String prodId = request.getParameter("pid");
        String prodName = request.getParameter("name");
        String prodType = request.getParameter("type");
        String prodInfo = request.getParameter("info");
        String priceStr = request.getParameter("price");
        String quantityStr = request.getParameter("quantity");

        // Logging input values for debugging
        System.out.println("Received price: " + priceStr);
        System.out.println("Received quantity: " + quantityStr);

        Double prodPrice = 0.0;
        Integer prodQuantity = 0;

        try {
            if (priceStr != null && !priceStr.trim().isEmpty()) {
                prodPrice = Double.parseDouble(priceStr.trim());
            } else {
                System.out.println("Price parameter is missing or empty.");
                response.sendRedirect("updateProduct.jsp?message=Price cannot be empty.");
                return;
            }

            if (quantityStr != null && !quantityStr.trim().isEmpty()) {
                prodQuantity = Integer.parseInt(quantityStr.trim());
            } else {
                System.out.println("Quantity parameter is missing or empty.");
                response.sendRedirect("updateProduct.jsp?message=Quantity cannot be empty.");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
            response.sendRedirect("updateProduct.jsp?message=Invalid input for price or quantity.");
            return;
        }

        ProductPojo product = new ProductPojo();
        product.setProdId(prodId);
        product.setProdName(prodName);
        product.setProdInfo(prodInfo);
        product.setProdPrice(prodPrice);
        product.setProdQuantity(prodQuantity);
        product.setProdType(prodType);

        ProductDaoImpl productDao = new ProductDaoImpl();
        String status = productDao.updateProductWithoutImage(prodId, product);

        RequestDispatcher rd = request.getRequestDispatcher("updateProduct.jsp?message=" + status);
        request.setAttribute("product", product);
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Update product details safely with input validation.";
    }
}