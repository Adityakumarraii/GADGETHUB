package in.gadgethub.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.gadgethub.dao.impl.ProductDaoImpl;
import in.gadgethub.pojo.ProductPojo;

public class AdminViewProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDaoImpl productDao = new ProductDaoImpl();
        List<ProductPojo> products = productDao.getAllProducts(); // Assuming you have this method

        if (products != null) {
            System.out.println("Products list size: " + products.size());
            request.setAttribute("products", products);
            System.out.println("Products attribute set successfully.");
        } else {
            System.out.println("Products list is null.");
        }

        request.getRequestDispatcher("adminViewProduct.jsp").forward(request, response);
    }
}