import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Sklad sklad = new Sklad();
    public static void  AddingProduct() {
        sklad.AddNewProduct();
        sklad.toString();
    }
    public static void GivingProduct() {
        sklad.GiveBuyerProduct();
    }
    public static void Menu() {
        System.out.println("Выберите, что хотите сделать:  1. Добавить товар на склад" + "\n" +
                           "                               2. Отпустить товар покупателю" + "\n" +
                           "                               3. Получение информации о доступных позициях товара" + "\n" +
                           "                               4. Получение информации о наличии товара на складе" +  "\n" +
                           "                               5. Группировка товаров по видам" + "\n" +
                           "                               6. Получение информации по поставщикам" + "\n" +
                           "                               7. Получение информации по покупателям" + "\n" +
                           "                               8. Выйти из программы" + "\n");
        Scanner console = new Scanner(System.in);
        int number = console.nextInt();
        // если добавлять товар
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
            // если отпускать покупателю
        } else if (number == 2) {
            GivingProduct();
        } else if (number == 8) {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        Menu();
    }
}
