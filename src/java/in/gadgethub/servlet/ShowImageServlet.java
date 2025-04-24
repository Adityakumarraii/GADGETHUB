/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.gadgethub.servlet;


import in.gadgethub.dao.impl.ProductDaoImpl;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aditya Kumar Rai
 */
public class ShowImageServlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String prodId=request.getParameter("pid");
        ProductDaoImpl productDao=new ProductDaoImpl();
        byte[]arr=productDao.getImage(prodId);

        if(arr==null){
            File fnew = new File(request.getServletContext().getRealPath("images/noimage.jpg"));
            BufferedImage originalImage = ImageIO.read(fnew);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, "jpg", baos);
            arr = baos.toByteArray();
        }
        ServletOutputStream stream=response.getOutputStream();
        stream.write(arr);       
        
    }
			
}