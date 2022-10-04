import java.util.ArrayList;

public class Order {

    private int OrderID;
    private int BuyerID;
    private int ProductID;
    private ArrayList<Product> ProductOnBuyer;

    public Order(int OrderID, int BuyerID, int ProductID, ArrayList<Product> ProductOnBuyer) {
        this.OrderID = OrderID;
        this.BuyerID = BuyerID;
        this.ProductID = ProductID;
        this.ProductOnBuyer = ProductOnBuyer;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getBuyerID() {
        return BuyerID;
    }

    public void setBuyerID(int buyerID) {
        BuyerID = buyerID;
    }

    public ArrayList<Product> getProductOnBuyer() {
        return ProductOnBuyer;
    }

    public void setProductOnBuyer(ArrayList<Product> productOnBuyer) {
        ProductOnBuyer = productOnBuyer;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }
}
