import java.util.ArrayList;

// класс Покупатель
public class Buyer {

    private String FIO;
    private String BuyerId;
    public ArrayList<Product> products = new ArrayList<>();
    public Buyer (String FIO) {
        this.FIO = FIO;
    }
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getFIO() { return FIO; }

    public String toString(int k) {
        return (k++) + ". " + FIO + "\n";
    }

    public String getBuyerId() {
        return BuyerId;
    }
    public void setBuyerId(String buyerId) {
        BuyerId = buyerId;
    }
}
