import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void  AddingProduct() {
        Sklad sklad = new Sklad();
        sklad.AddNewProduct();
        sklad.toString();
    }
    public static void Menu() {
        System.out.println("Выберите, что хотите сделать:  1. Добавить товар на склад" + "\n" +
                           "                               2. Отпустить товар покупателю" + "\n" +
                           "                               3. Выйти из программы" + "\n");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        if (number == 1) {
            AddingProduct();
            int number2 = 0;
            while (number2 != 2) {
                System.out.println("Добавить еще товар?   1." + "\n" +
                        "Выйти в главное меню? 2." + "\n");
                number2 = console.nextInt();
                if (number2 == 1) {
                    AddingProduct();
                } else if (number2 == 2) {
                    System.out.print("\n\n\n\n\n");
                    Menu();
                }
            }
        } else if (number == 2) {

        } else if (number == 3) {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        Menu();
    }
}
