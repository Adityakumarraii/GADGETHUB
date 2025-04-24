package in.gadgethub.utility;

import in.gadgethub.pojo.CartPojo;
import java.util.List;


/**
 *
 * @author hp
 */
public class OrderPlacedEmail {
    private String orderNumber;
    private String orderDate;
    private double orderTotal;
    private List<CartPojo> items;

    public OrderPlacedEmail() {
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public List<CartPojo> getItems() {
        return items;
    }

    public void setItems(List<CartPojo> items) {
        this.items = items;
    }
    
    
    
}