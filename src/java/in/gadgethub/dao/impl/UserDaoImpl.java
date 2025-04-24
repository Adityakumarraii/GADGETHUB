package in.gadgethub.dao.impl;

import in.gadgethub.dao.UserDao;
import in.gadgethub.pojo.UserPojo;
import in.gadgethub.utility.DBUtil;
import in.gadgethub.utility.MailMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SONI
 */
public class UserDaoImpl implements UserDao {
    public boolean isRegistered(String emailId){
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection conn=DBUtil.provideConnection();
        boolean flag=false;
        try{
               ps=conn.prepareStatement("Select * from users where useremail=?");
               ps.setString(1,emailId);
               rs=ps.executeQuery();
               if(rs.next()){
                   flag=true;                    
                   }
               }
        catch(SQLException ex){
            System.out.println("Error in isRegisterd:"+ex);
            ex.printStackTrace();
        }       
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(ps);
       return flag;           
    
        
    }
public String registerUser(UserPojo user){
        String status="Registration Failed";
        boolean isUserRegistered=isRegistered(user.getUseremail());
        if(isUserRegistered){
            status="Email Already Registered. Try Again";
            return status;
        }
        Connection conn=DBUtil.provideConnection();
        PreparedStatement ps=null;
        try{
            ps=conn.prepareStatement("Insert into users values(?,?,?,?,?,?)");
            ps.setString(1,user.getUseremail());
            ps.setString(2,user.getUsername());
            ps.setString(3,user.getMobile());
            ps.setString(4,user.getAddress());
            ps.setInt(5,user.getPincode());
            ps.setString(6,user.getPassword());
            int count=ps.executeUpdate();
            if(count==1){
                status="Registration Successful";
                MailMessage.registrationSuccess(user.getUseremail(), user.getUsername());
                System.out.println("Mail sent Successfully...");
            }
        }catch(Exception ex){
            System.out.println("Error in registerUser:"+ex);
            ex.printStackTrace();
        } 
        DBUtil.closeStatement(ps);
        return status;
        
    }
    
public String isValidCredentials(String emailId,String password){
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection conn=DBUtil.provideConnection();
        String status="Login Denied. Invalid Usernameor Password";
        try{
               ps=conn.prepareStatement("Select 1 from users where useremail=? and password=?");
               ps.setString(1,emailId);
               ps.setString(2,password);
               rs=ps.executeQuery();
               if(rs.next()){
                   status="Login Succesful";      
                   }
               }
        catch(SQLException ex){
            status="Error:"+ex.getMessage();
            System.out.println("Error in isValidCredentials:"+ex);
            ex.printStackTrace();
        }       
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(ps);
       return status;           
    
    }
public UserPojo getUserDetails(String emailId){
        UserPojo user=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection conn=DBUtil.provideConnection();
        try{
            ps=conn.prepareStatement("Select * from users where useremail=?");
            ps.setString(1,emailId);
            rs=ps.executeQuery();
            if(rs.next()){
                user=new UserPojo();
                user.setUseremail(rs.getString("useremail"));
                user.setUsername(rs.getString("username"));
                user.setMobile(rs.getString("mobile"));
                user.setAddress(rs.getString("address"));
                user.setPincode(rs.getInt("pincode"));
                user.setPassword(rs.getString("password"));                             
            }
        }
        catch(SQLException ex){
            
            System.out.println("Error in getUserDetails:"+ex);
            ex.printStackTrace();
        }       
       DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(ps);
       return user;    
    }
public String getUserFirstName(String emailId){
    String fName=null;
     PreparedStatement ps=null;
        ResultSet rs=null;
        Connection conn=DBUtil.provideConnection();
        try{
            ps=conn.prepareStatement("Select * from users where useremail=?");
            ps.setString(1,emailId);
            rs=ps.executeQuery();
            if(rs.next()){
                String fullName=rs.getString(1);
                fName=fullName.split(" ")[0];
            }
    
}
        catch(SQLException ex){
            System.out.println("Error in getUserDetails: "+ex );
            ex.printStackTrace();
        }
          DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(ps);
       return fName;
}
public String getUserAddr(String emailId){
    String address=null;
    PreparedStatement ps=null;
        ResultSet rs=null;
        Connection conn=DBUtil.provideConnection();
        try{
            ps=conn.prepareStatement("Select * from users where useremail=?");
            ps.setString(1,emailId);
            rs=ps.executeQuery();
            if(rs.next()){
                
            address=rs.getString(1);
            }
}catch(SQLException ex){
            System.out.println("Error in getUserDetails: "+ex);
            ex.printStackTrace();
}
         DBUtil.closeResultSet(rs);
       DBUtil.closeStatement(ps);
       return address;
}
}