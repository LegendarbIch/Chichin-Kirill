package entities;

import java.util.Arrays;

public class Order {

    private int OrderID;

    private int BuyerID;

    private int ProductsID;

    private int Amount;

    public Order(int OrderID, int BuyerID, int ProductsID, int Amount) {
        this.OrderID = OrderID;
        this.BuyerID = BuyerID;
        this.ProductsID = ProductsID;
        this.Amount = Amount;
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

    public int getProductsID() {
            return ProductsID;
    }

    public void setProductsID(int productID) {
        ProductsID = productID;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    @Override
    public String toString() {
        return "Заказ{" +
                " Номер заказа=" + OrderID +
                ", Номер покупателя=" + BuyerID +
                ", Номер отпущенного товара=" + ProductsID +
                '}';
    }

}
