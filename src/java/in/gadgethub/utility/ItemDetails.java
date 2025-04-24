package in.gadgethub.utility;

/**
 *
 * @author Soni
 */
public class ItemDetails {
     
    private String transId;
    private String prodId;
    private String userName;
    private String adress;
    private int quantity;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemDetails() {
    }

    public ItemDetails(String transId, String prodId, String userName, String adress, int quantity) {
        this.transId = transId;
        this.prodId = prodId;
        this.userName = userName;
        this.adress = adress;
        this.quantity = quantity;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}