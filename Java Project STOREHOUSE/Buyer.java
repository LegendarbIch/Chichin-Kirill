import java.util.ArrayList;

// класс Покупатель
public class Buyer {

    private String FIO;
    private int BuyerId;
    public ArrayList<Product> products = new ArrayList<>();
    public Buyer (String FIO, int BuyerId) {
        this.FIO = FIO;
        this.BuyerId = BuyerId;
    }
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getFIO() { return FIO; }

    public String toString(int k) {
        return (k++) + ". " + FIO + "\n";
    }

    public int getBuyerId() {
        return BuyerId;
    }
    public void setBuyerId(int buyerId) {
        BuyerId = buyerId;
    }
}
