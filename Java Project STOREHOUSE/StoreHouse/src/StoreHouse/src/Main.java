package StoreHouse.src;

import javax.lang.model.element.Name;
import java.util.Scanner;

public class Main {
    static Sklad sklad = new Sklad();
    static Scanner console = new Scanner(System.in);

    static ProductType productType;
//    static int productArticle = sklad.AutoID();
//
//    static int buyerid = 1;

//    public static void Repeat() {
//        System.out.print("Какому покупателю вы хотите отправить товар?\n");
//        sklad.getBuyers();
//        int bu_id = console.nextInt();
//        System.out.print("Какой товар отправить покупателю? \n" + "Выбор происходит по артиклю \n");
//        sklad.getProducts();
//        int prod_id = console.nextInt();
//        System.out.print("Отправить еще?  1.Да \n" +
//                         "                2.Нет");
//        int num = console.nextInt();
//        if(num==1) {
//            Repeat();
//        } else {
//            MenuAddBuyer();
//        }
//    }
//    public static void MenuAddBuyer() {
//        System.out.print("1.Добавить покупателя  \n" +
//                         "2.Отпустить товар      \n" +
//                         "3.Обратно              \n");
//        int num = console.nextInt();
//        console.nextLine();
//        if (num == 1) {
//            int k = 1;
//            System.out.print("Введите покупателя или покупателей: \n");
//            while (num != 2) {
//                System.out.print(k + ".");
//                k++;
//                String FIO = console.nextLine();
//
//                sklad.AddingBuyerToTheList(FIO, buyerid);
//                buyerid++;
//                System.out.print("Дальше? 1.Да \n" +
//                                 "        2.Нет  ");
//                num = console.nextInt();
//                if (num == 2) {
//                    MenuAddBuyer();
//                }
//            }
//        } else if (num==2) {
//            Repeat();
//        } else {
//            Menu();
//        }
//    }
    public static void Menu() {
        System.out.println("Выберите, что хотите сделать:  1. (вручную) Добавить товар на склад" + "\n" +
                           "                               2. (вручную) Отпустить товар покупателю" + "\n" +
                           "                               3. Получение информации о доступных позициях товара" + "\n" +
                           "                               4. Получение информации о наличии товара на складе" +  "\n" +
                           "                               5. Группировка товаров по видам" + "\n" +
                           "                               6. Получение информации по поставщикам" + "\n" +
                           "                               7. Получение информации по покупателям" + "\n" +
                           "                               8. Выйти из программы" + "\n");
        int number = console.nextInt();
        // если добавлять товар
//        if (number == 1) {
//            AddingProducts();
//            int number2 = 0;
//            while (number2 != 2) {
//                System.out.println("Добавить еще товар?   1." + "\n" +
//                                   "Выйти в главное меню? 2." + "\n");
//                number2 = console.nextInt();
//                if (number2 == 1) {
//                    AddingProducts();
//                } else if (number2 == 2) {
//                    System.out.print("\n\n\n\n\n");
//                    Menu();
//                }
//            }
//            // если отпускать покупателю
//        } else if (number == 2) {
//            MenuAddBuyer();
         if (number==3) {
            sklad.getAvailableProductPositions();
            Menu();
        } else if (number==4) {
            sklad.getProducts();
            Menu();
        } else if (number==5) {
            sklad.GroupingOfProductsByType();
            Menu();
        } else if (number == 6) {
            sklad.getInfoOnProviders();
            Menu();
        } else if (number == 7) {
            sklad.getBuyersProduct();
            Menu();
        } else if (number == 8) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        sklad.AddToProduct(productType.Technic,"Avo", "Компьютер", 2, 30000);
        sklad.AddToProduct(productType.BuildingMaterials,"INC", "Доски", 0,120);
        sklad.AddToProduct(productType.BuildingMaterials,"Build", "Кирпичи",  1, 300);
        sklad.AddToProduct(productType.Technic,"Avo", "Джостик", 3, 1200);
        sklad.AddToProduct(productType.Technic,"NanoTECH", "Микрочипы", 4,  7000);
        sklad.AddToProduct(productType.BuildingMaterials,"INC", "Изменрители",  5, 6700);
        sklad.AddToProduct(productType.Technic,"NanoTECH", "Дисплей", 6,  50000);
        sklad.AddingBuyerToTheList("Кирилл", 0);
        sklad.AddingBuyerToTheList("Б.О. Валин", 1);

        sklad.GiveBuyerProduct(1, 0, new int[] {1, 2});
        sklad.GiveBuyerProduct(2, 0, new int[] {4, 5, 6});
        Menu();

    }
//    public static void AddingProducts(){
//        System.out.print("Какой тип товара вы хотите добавить?  1.Техника   2.Строительные материалы");
//        int number = console.nextInt();
//        console.nextLine();
//        System.out.print("Введите поставщика: ");
//        String ProviderName = console.nextLine();
//        System.out.print("Введите товар: ");
//        String productName = console.nextLine();
//        System.out.print("Введите цену товара: ");
//        int price = console.nextInt();
//
//        if (number == 1) {
//            sklad.AddToProduct(productType.Technic, ProviderName,productName,productArticle, price);
//        } else if (number == 2) {
//            sklad.AddToProduct(productType.BuildingMaterials, ProviderName,productName,productArticle, price);
//        }
//        productArticle++;
//    }

}