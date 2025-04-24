/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.gadgethub.dao.impl;

import in.gadgethub.dao.ProductDao;
import in.gadgethub.pojo.ProductPojo;
import in.gadgethub.utility.DBUtil;
import in.gadgethub.utility.IDUtil;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author SONI
 */
public class ProductDaoImpl implements ProductDao {
    //add the new product in database
    @Override
    public String addProduct(ProductPojo product) {
        String status = "Product Registration Failed";
        if (product.getProdId() == null) {
            product.setProdId(IDUtil.generateProdId());
        }
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("insert into products values(?,?,?,?,?,?,?,?)");
            ps.setString(1, product.getProdId());
            ps.setString(2, product.getProdName());
            ps.setString(3, product.getProdType());
            ps.setString(4, product.getProdInfo());
            ps.setDouble(5, product.getProdPrice());
            ps.setInt(6, product.getProdQuantity());
            ps.setBlob(7, product.getProdImage());
            ps.setString(8,"Y");
            int count = ps.executeUpdate();
            if (count == 1) {
                status = "Product Added Successfully with Id" + product.getProdId();
            }
        } catch (SQLException ex) {
            System.out.println("Error in addProduct:" + ex);
            ex.printStackTrace();
        }
        DBUtil.closeStatement(ps);

        return status;
    }
    
    //update the details of existing products
    @Override
    public String updateProduct(ProductPojo prevProduct, ProductPojo updatedProduct) {
        String status = "Product Id is not matched";
        if (prevProduct.getProdId().equals(updatedProduct.getProdId())) {
            Connection conn = DBUtil.provideConnection();
            PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement("update products set pname=?,ptype=?,pinfo=?,pprice=?,pquantity=?,image=?,where pid=?");
                ps.setString(1, updatedProduct.getProdName());
                ps.setString(2, updatedProduct.getProdType());
                ps.setString(3, updatedProduct.getProdInfo());
                ps.setDouble(4, updatedProduct.getProdPrice());
                ps.setInt(5, updatedProduct.getProdQuantity());
                ps.setBlob(6, updatedProduct.getProdImage());
                ps.setString(7,updatedProduct.getProdId());
                int count = ps.executeUpdate();
                if (count == 1) {
                    status = "Product Added Successfully with Id";
                }
            } catch (SQLException ex) {
                System.out.println("Error in addProduct:" + ex);
                ex.printStackTrace();
            }
          DBUtil.closeStatement(ps);
        }
       
        return status;
    }
    
    //update the price of the product based on his productId
    @Override
    public String updateProductPrice(String prodId, double updatedPrice) {
        String status="Price Updation Failed!";
        Connection conn=DBUtil.provideConnection();
        PreparedStatement ps=null;
        try{            
            ps=conn.prepareStatement("update products set pprice=? where pid=?");
            ps.setDouble(1,updatedPrice);
            ps.setString(2,prodId);
            int count=ps.executeUpdate();
            if(count==1){
                status="Product Price is Succesfully Updated";                
            }
            
        }catch(SQLException ex){
            System.out.println("Error in updateProduct"+ex);
            ex.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        return status;
       }
    
    //Returns all the products from the database
    @Override
    public List<ProductPojo> getAllProducts() {
        List<ProductPojo> productList=new ArrayList<>();
        Connection conn=DBUtil.provideConnection();
        Statement st=null;
        ResultSet rs=null;
        try{
            st=conn.createStatement();
            rs=st.executeQuery("select * from products");
            while(rs.next()){
                ProductPojo product=new ProductPojo();
                product.setProdId(rs.getString("pid"));
                product.setProdName(rs.getString("pname"));
                product.setProdPrice(rs.getDouble("pprice"));
                product.setProdType(rs.getString("ptype"));
                product.setProdInfo(rs.getString("pinfo"));
                product.setProdQuantity(rs.getInt("pquantity"));
                product.setProdImage(rs.getAsciiStream("image"));  //return image in binary getBinaryStream("image"); for video audio we can use getBinaryStream(); 
                productList.add(product);
            }
        }catch(SQLException ex){
            System.out.println("Error in getAllProduct method");
            ex.printStackTrace();
        }
        DBUtil.closeResultSet(rs);
        return productList;
      }
    
    //returns all the products from database based on the which type of product
    @Override
    public List<ProductPojo> getAllProductsByType(String type) {
        
        List<ProductPojo> productList=new ArrayList<>();
        Connection conn=DBUtil.provideConnection();
        PreparedStatement ps=null;
        type=type.toLowerCase();
        ResultSet rs=null;
        try{
            ps=conn.prepareStatement("select * from product where lower(ptype) like ?");
            ps.setString(1,"%"+type+"%");
            rs=ps.executeQuery();
            while(rs.next()){
                ProductPojo product=new ProductPojo();
                product.setProdId(rs.getString("pid"));
                product.setProdName(rs.getString("pname"));
                product.setProdPrice(rs.getDouble("pprice"));
                product.setProdType(rs.getString("ptype"));
                product.setProdInfo(rs.getString("pinfo"));
                product.setProdQuantity(rs.getInt("pquantity"));
                product.setProdImage(rs.getAsciiStream("image"));  //return image in binary getBinaryStream("image"); for video audio we can use getBinaryStream(); 
                productList.add(product);
            }
        }catch(SQLException ex){
            System.out.println("Error in getAllProduct method");
            ex.printStackTrace();
        }
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps);
        return productList;
         }
    
    //returns all the products by searching
    @Override
    public List<ProductPojo> searchAllProducts(String search) {
        List<ProductPojo> productList=new ArrayList<>();
        Connection conn=DBUtil.provideConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        search=search.toLowerCase();
        try{
            ps=conn.prepareStatement("select * from products where lower(ptype) like ? or lower(pname) like ? or lower(pinfo) like ?");  
            ps.setString(1,"%"+search+"%");
            ps.setString(2,"%"+search+"%");
            ps.setString(3,"%"+search+"%");
            rs=ps.executeQuery();
            while(rs.next()){
                ProductPojo product=new ProductPojo();
                product.setProdId(rs.getString("pid"));
                product.setProdName(rs.getString("pname"));
                product.setProdPrice(rs.getDouble("pprice"));
                product.setProdType(rs.getString("ptype"));
                product.setProdInfo(rs.getString("pinfo"));
                product.setProdQuantity(rs.getInt("pquantity"));
                product.setProdImage(rs.getAsciiStream("image"));  //return image in binary getBinaryStream("image"); for video audio we can use getBinaryStream(); 
                productList.add(product);                
                
            }        
                        
        }catch(SQLException ex){
            System.out.println("Error in searchAllProducts Method");
            ex.printStackTrace();
        }
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps);
        return productList;     
      }
    
    //get product details by prodid
    @Override
    public ProductPojo getProductDetails(String prodId) {
         ProductPojo product =null;
         Connection conn=DBUtil.provideConnection();
         PreparedStatement ps=null;
         ResultSet rs=null;
         try{
             ps=conn.prepareStatement("select * from products where pid=?");
             ps.setString(1,prodId);
             rs=ps.executeQuery();
             if(rs.next()){
                product=new ProductPojo();
                product.setProdId(rs.getString("pid"));
                product.setProdName(rs.getString("pname"));
                product.setProdPrice(rs.getDouble("pprice"));
                product.setProdType(rs.getString("ptype"));
                product.setProdInfo(rs.getString("pinfo"));
                product.setProdQuantity(rs.getInt("pquantity"));
                product.setProdImage(rs.getAsciiStream("image"));  //return image in binary getBinaryStream("image"); for video audio we can use getBinaryStream(); 
              
                 
             }
         }catch(SQLException ex){
             System.out.println("Error in getProductDetails method");
             ex.printStackTrace();
         }
         DBUtil.closeStatement(ps);
         DBUtil.closeResultSet(rs);         
         return product;
         
        }
    
    //returns the product quantity based on product id
    @Override
    public int getProductQuantity(String prodId) {
        int quantity=0;
        Connection conn=DBUtil.provideConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{            
            ps=conn.prepareStatement(" select pquantity from products where pid=? ");
            ps.setString(1,prodId);
            rs=ps.executeQuery();
            if(rs.next()){
                quantity=rs.getInt(1);
            }
            
        }catch(SQLException ex){
            System.out.println("Error in getProductQuantity method"+ex);
            ex.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        DBUtil.closeResultSet(rs);
        return quantity;
        }

    @Override
    public String updateProductWithoutImage(String prevProductId, ProductPojo updatedProduct) {
        String status="Updation Failed!";
        int prevQuantity=0;
        if(prevProductId.equals(updatedProduct.getProdId())){
            status="Product ID's Don Not Match.Updation Failed";
            return status;
        }
       Connection conn=DBUtil.provideConnection();
       PreparedStatement ps=null;       
       try{
           prevQuantity=getProductQuantity(prevProductId);
           ps=conn.prepareStatement("update products set pname=?,ptype=?,pinfo=?,pprice=?,pquantity=?where pid=?");
           ps.setString(1,updatedProduct.getProdName());
           ps.setString(2,updatedProduct.getProdType());
           ps.setString(3,updatedProduct.getProdInfo());
           ps.setDouble(4,updatedProduct.getProdPrice());
           ps.setInt(5,updatedProduct.getProdQuantity());
           ps.setString(6,updatedProduct.getProdId());
           int count=ps.executeUpdate();
           if(count==1 && prevQuantity<updatedProduct.getProdQuantity()){
               status="Product Updated Successfully and Mail Sent";
               //code for email
           }else if(count==1){
               status="Product Updated Successfully";
           }
       }catch(SQLException ex){
           System.out.println("Error in updateProductWithoutImage ");
           ex.printStackTrace();
       }
    
       DBUtil.closeStatement(ps);
       return status;
    }
    
    @Override
    public double getProductPrice(String prodId){
        double price=0.0;
        Connection conn=DBUtil.provideConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{            
            ps=conn.prepareStatement(" select pprice from products where pid=? ");
            ps.setString(1,prodId);
            rs=ps.executeQuery();
            if(rs.next()){
                price=rs.getDouble(1);
            }
            
        }catch(SQLException ex){
            System.out.println("Error in getProductPrice method"+ex);
            ex.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        DBUtil.closeResultSet(rs);
        return price;
    }
    
    //substract the n quantity from db
   
    public boolean sellNProduct(String prodId, int n) {
          boolean result=false;
          Connection conn=DBUtil.provideConnection();
          PreparedStatement ps=null;
          ResultSet rs=null;
          try{
              ;
              conn.prepareStatement("update products set pquantity=(pquantity-?) where pid=? ");
              ps.setInt(1,n);
              ps.setString(2,prodId);
              int count=ps.executeUpdate();
              if(count==1){
                  result=true;
              }             
          
          }catch(SQLException ex){
              System.out.println("Error in sellNProduct method");
              ex.printStackTrace();
          }
          DBUtil.closeStatement(ps);
          DBUtil.closeResultSet(rs);
          return result;
        }

    @Override
    public List<String> getAllProductsType() {
        List<String> productTypeList=new ArrayList<>();
        Connection conn=DBUtil.provideConnection();
        Statement st=null;
        ResultSet rs=null;
        
        try{
            st=conn.createStatement();
            rs=st.executeQuery("select distinct ptype from products");
            while(rs.next()){
                productTypeList.add(rs.getString(1));               
                
            }        
                        
        }catch(SQLException ex){
            System.out.println("Error in getAllProductsType Method");
            ex.printStackTrace();
        }
        DBUtil.closeResultSet(rs);
        return productTypeList;  
         }

    @Override
    public byte[] getImage(String prodId) {
        byte [] arr=null;
        Connection conn=DBUtil.provideConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{            
            ps=conn.prepareStatement("select image from products where pid=? ");
            ps.setString(1,prodId);
            rs=ps.executeQuery();
            if(rs.next()){
                arr=rs.getBytes(1);
            }
            
        }catch(SQLException ex){
            System.out.println("Error in getImage method"+ex);
            ex.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        DBUtil.closeResultSet(rs);
        return arr;
        
        }

    
  
    public String removeProduct(String prodId) {
        
        String status="Product Not Found!";
        Connection conn=DBUtil.provideConnection();
        PreparedStatement ps1=null;
        PreparedStatement ps2=null;
        try{
            ps1=conn.prepareStatement("update products set available='N' where prodId=? and available='Y'");
            ps1.setString(1,prodId);
            int k=ps1.executeUpdate();
            if(k>0){
                status="Product Removed Successfully!";
                ps2=conn.prepareStatement("Delete from usercart where prodId=?");
                ps2.setString(1,prodId);
                k=ps2.executeUpdate();                   
             
                                
            }
                        
        }catch(SQLException ex){
            System.out.println("Error in removeProduct method");
            ex.printStackTrace();
        }
        
        DBUtil.closeStatement(ps1);
        DBUtil.closeStatement(ps2);
        return status;
        
       }

}