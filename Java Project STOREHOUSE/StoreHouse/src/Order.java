import java.util.ArrayList;

public class Order {

    private int OrderID;

    private int BuyerID;

    private int ProductID;
    private ArrayList<Product> ProductOnBuyer = new ArrayList<>();
    private Sklad sklad = new Sklad();
    public Order(int OrderID, int BuyerID, int ProductID) {
        this.OrderID = OrderID;
        this.BuyerID = BuyerID;
        this.ProductID = ProductID;
        this.ProductOnBuyer.add(sklad.getProductByID(ProductID));
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

    @Override
    public String toString() {
        return "Order{" +
                "OrderID=" + OrderID +
                ", BuyerID=" + BuyerID +
                ", ProductID=" + ProductID +
                ", ProductOnBuyer=" + ProductOnBuyer +
                '}' + "\n";
    }

}
