package in.gadgethub.utility;

import in.gadgethub.dao.impl.ProductDaoImpl;
import java.util.Date;
import javax.mail.MessagingException;

public class MailMessage {

    public static void registrationSuccess(String recipientMailId, String name) throws MessagingException {
        String subject = "Registration Successfull";
        String htmlTextMessage = "" + "<html>" + "<body>"
                + "<h2 style='color:green;'>Welcome to " + AppInfo.appName + "</h2>" + "" + "Hi " + name + ","
                + "<br><br>Thanks for singing up with " + AppInfo.appName + ".<br>"
                + "We are glad that you choose us. We invite you to check out our latest collection of new electonics appliances."
                + "<br>We are providing upto 60% OFF on most of the electronic gadgets. So please visit our site and explore the collections."
                + "<br><br>Our Online electronics is growing in a larger amount these days and we are in high demand so we thanks all of you for "
                + "making us up to that level. We Deliver Product to your house with no extra delivery charges and we also have collection of most of the"
                + "branded items.<br><br>As a Welcome gift for our New Customers we are providing additional 10% OFF Upto 500 Rs for the first product purchase. "
                + "<br>To avail this offer you only have "
                + "to enter the promo code given below.<br><br><br> PROMO CODE: " + "" + AppInfo.appName.toUpperCase() + "500<br><br><br>"
                + "Have a good day!<br>" + "" + "</body>" + "</html>";
        JavaMailUtil.sendMail(recipientMailId, subject, htmlTextMessage);
    }

    public static void shippedProduct(String recipientMailId, String name) throws MessagingException {
        String subject = "Order Shipped";
        int orderNumber = 12345;
        Date shippingDate = new Date();
        String deliveryDate = "14-01-2025";
        String shippingAddress = "Bhopal";
        String trackingUrl = "Lenovo";

        String htmlTextMessage = ""
                + "<html>"
                + "<body style='font-family: Arial, sans-serif; line-height: 1.6; color: #333;'>"
                + "<div style='max-width: 600px; margin: auto; border: 1px solid #ddd; border-radius: 8px; overflow: hidden; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);'>"
                + "<div style='background-color: #4CAF50; color: white; padding: 20px; text-align: center;'>"
                + "   <h2 style='margin: 0;'>Order Shipped!</h2>"
                + "</div>"
                + "<div style='padding: 20px;'>"
                + "   <p>Dear <strong>" + name + "</strong>,</p>"
                + "   <p>We’re excited to let you know that your order has been shipped and is on its way to your doorstep!</p>"
                + "   <p>Here are your order details:</p>"
                + "   <table style='width: 100%; border-collapse: collapse; margin: 20px 0;'>"
                + "      <tr style='background-color: #f2f2f2;'>"
                + "          <th style='text-align: left; padding: 8px;'>Order Number</th>"
                + "          <td style='padding: 8px;'>" + orderNumber + "</td>"
                + "      </tr>"
                + "      <tr>"
                + "          <th style='text-align: left; padding: 8px;'>Shipping Date</th>"
                + "          <td style='padding: 8px;'>" + shippingDate + "</td>"
                + "      </tr>"
                + "      <tr style='background-color: #f2f2f2;'>"
                + "          <th style='text-align: left; padding: 8px;'>Expected Delivery</th>"
                + "          <td style='padding: 8px;'>" + deliveryDate + "</td>"
                + "      </tr>"
                + "   </table>"
                + "   <p>Your package is being delivered to:</p>"
                + "   <p style='font-size: 16px; color: #555;'><strong>" + shippingAddress + "</strong></p>"
                + "   <p>Track your order <a href='" + trackingUrl + "' style='color: #4CAF50;'>here</a>.</p>"
                + "   <div style='border-top: 1px solid #ddd; margin: 20px 0;'></div>"
                + "   <p style='text-align: center;'>"
                + "       <strong>Need Help?</strong> Our customer support team is here for you!"
                + "       <br>Call us at <a href='tel:+18001234567' style='color: #4CAF50;'>1-800-123-4567</a> or email us at "
                + "       <a href='mailto:support@example.com' style='color: #4CAF50;'>support@example.com</a>."
                + "   </p>"
                + "</div>"
                + "<div style='background-color: #f9f9f9; text-align: center; padding: 10px;'>"
                + "   <p style='margin: 0; font-size: 14px;'>Thank you for choosing <strong>" + AppInfo.appName + "</strong>. We value your trust and look forward to serving you again!</p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";

        JavaMailUtil.sendMail(recipientMailId, subject, htmlTextMessage);

    }

    public static void orderPlaced(String recipientMailId, String name,OrderPlacedEmail op) throws MessagingException {
        String subject = "Order Shipped";  
        String trackingUrl="";
        
        String htmlTextMessage = ""
                + "<html>"
                + "<body style='font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 20px; color: #333;'>"
                + "<div style='max-width: 600px; margin: auto; background-color: #ffffff; border-radius: 8px; overflow: hidden; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);'>"
                + "<div style='background-color: #4CAF50; color: white; text-align: center; padding: 20px;'>"
                + "   <h1 style='margin: 0;'>Order Confirmation</h1>"
                + "   <p style='margin: 5px 0;'>Thank you for shopping with us!</p>"
                + "</div>"
                + "<div style='padding: 20px;'>"
                + "   <p>Dear <strong>" + name + "</strong>,</p>"
                + "   <p>We're excited to confirm your order! Below are the details of your purchase:</p>"
                + "   <table style='width: 100%; border-collapse: collapse; margin: 20px 0;'>"
                + "      <tr style='background-color: #f2f2f2;'>"
                + "          <th style='text-align: left; padding: 8px;'>Order Number</th>"
                + "          <td style='padding: 8px;'>" + op.getOrderNumber() + "</td>"
                + "      </tr>"
                + "      <tr>"
                + "          <th style='text-align: left; padding: 8px;'>Order Date</th>"
                + "          <td style='padding: 8px;'>" + op.getOrderDate() + "</td>"
                + "      </tr>"
                + "      <tr style='background-color: #f2f2f2;'>"
                + "          <th style='text-align: left; padding: 8px;'>Total Amount</th>"
                + "          <td style='padding: 8px;'>₹" + op.getOrderTotal() + "</td>"
                + "      </tr>"
                + "       <tr>"
                + "          <th style='text-align: left; padding: 8px;'>Product Name</th>"
                + "          <td style='padding: 8px; color:blue' >₹" + new ProductDaoImpl().getProductDetails(op.getItems().get(0).getProdId()).getProdName() + "</td>"
                + "      </tr>"
                + "   </table>"
                + "   <p style='margin: 20px 0;'>Items Ordered:</p>"
                + "   <div style='text-align: center; margin: 20px 0;'>"
                + "       <a href='" + trackingUrl + "' style='display: inline-block; background-color: #4CAF50; color: white; text-decoration: none; padding: 10px 20px; border-radius: 5px;'>Track My Order</a>"
                + "   </div>"
                + "   <p>We are preparing your order for shipment. You’ll receive another email when your order is on the way.</p>"
                + "   <p>If you have any questions or need assistance, feel free to reach out to our support team.</p>"
                + "   <div style='border-top: 1px solid #ddd; margin: 20px 0;'></div>"
                + "   <p style='text-align: center;'>"
                + "       <strong>Contact Us:</strong> Call us at <a href='tel:+18001234567' style='color: #4CAF50;'>1-800-123-4567</a>"
                + "       or email us at <a href='mailto:support@example.com' style='color: #4CAF50;'>support@example.com</a>."
                + "   </p>"
                + "</div>"
                + "<div style='background-color: #f9f9f9; text-align: center; padding: 10px;'>"
                + "   <p style='margin: 0; font-size: 14px;'>Thank you for choosing <strong>" + AppInfo.appName + "</strong>. We’re thrilled to have you as a customer!</p>"
                + "   <p style='margin: 0;'><strong>Enjoy shopping!</strong></p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";
        
        JavaMailUtil.sendMail(recipientMailId, subject, htmlTextMessage);

    }
}