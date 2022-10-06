package StoreHouse.src;

import java.util.ArrayList;
import java.util.Arrays;

public class Order {

    private int OrderID;

    private int BuyerID;

    private int[] ProductsID;

    public Order(int OrderID, int BuyerID, int[] ProductsID) {
        this.OrderID = OrderID;
        this.BuyerID = BuyerID;
        this.ProductsID = ProductsID;
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

    public int[] getProductsID() {
        return ProductsID;
    }

    public void setProductsID(int[] productID) {
        ProductsID = productID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrderID=" + OrderID +
                ", BuyerID=" + BuyerID +
                ", ProductsID=" + Arrays.toString(ProductsID) +
                '}';
    }

}
