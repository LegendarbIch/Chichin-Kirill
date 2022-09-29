import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Buyers extends Buyer{
    private ArrayList<String> buyers = new ArrayList<>();
    public void AddingBuyerToTheList() {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите покупателя: ");
        String fio = console.nextLine();
        setFIO(fio);
        buyers.add(getFIO());
    }
    public String getBuyers() {
        for (String buyers1: buyers) {
            int k = 0;
            System.out.print( k+1 + "." + " " + buyers1 + "\n");
        }
        return null;
    }
}
