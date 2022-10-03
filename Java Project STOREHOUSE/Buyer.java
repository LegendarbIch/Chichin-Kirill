import java.util.ArrayList;

// класс Покупатель
public class Buyer {

    private String FIO;
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
}
