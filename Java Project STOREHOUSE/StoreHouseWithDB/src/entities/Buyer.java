package entities;

import java.util.ArrayList;

// класс Покупатель
public class Buyer {

    private String FIO;
    private int BuyerId;
    public Buyer (String FIO, int BuyerId) {
        this.FIO = FIO;
        this.BuyerId = BuyerId;
    }
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getFIO() { return FIO; }

    public int getBuyerId() {
        return BuyerId;
    }
    public void setBuyerId(int buyerId) {
        BuyerId = buyerId;
    }

    @Override
    public String toString() {
        return getBuyerId() + " " + getFIO();
    }
}
