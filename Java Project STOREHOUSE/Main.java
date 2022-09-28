import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void Menu() {
        System.out.println("Выберите, что хотите сделать:  1. Добавить товар на склад" + "\n" +
                           "                               2. Отпустить товар покупателю" + "\n");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        if (number == 1) {
            Sklad sklad = new Sklad();
            sklad.AddNewProduct();
            sklad.toString();
        } else if (number == 2) {

        }
    }
    public static void main(String[] args) {
        Menu();
    }
}
