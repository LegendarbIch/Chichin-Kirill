
import database_and_memory.DataBaseRepository;
import database_and_memory.InMemoryRepository;

import java.awt.*;
import java.sql.SQLException;

public class Main {

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
//    public static void Menu() {
//        System.out.println("Выберите, что хотите сделать:  -. (вручную) Добавить товар на склад" + "\n" +
//                "                               -. (вручную) Отпустить товар покупателю" + "\n" +
//                "                               3. Получение информации о доступных позициях товара" + "\n" +
//                "                               4. Получение информации о наличии товара на складе" + "\n" +
//                "                               5. Группировка товаров по видам" + "\n" +
//                "                               6. Получение информации по поставщикам" + "\n" +
//                "                               7. Получение информации по покупателям из БД" + "\n" +
//                "                               8. Выйти из программы" + "\n");
//        int number = console.nextInt();
//        if (number == 3) {
//            sklad.getAvailableProductPositions();
//            Menu();
//        } else if (number == 4) {
//            sklad.getProducts();
//            Menu();
//        } else if (number == 5) {
//            sklad.GroupingOfProductsByType();
//            Menu();
//        } else if (number == 6) {
//            sklad.getInfoOnProviders();
//            Menu();
//        } else if (number == 7) {
//            try {
//                sklad.getBuyersFromDB();
//            } catch (SQLException | ClassNotFoundException sqlEx) {
//                sqlEx.printStackTrace();
//            } finally {
//                try {
//                    sklad.CloseConnection();
//                } catch (SQLException | ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//            Menu();
//        } else if (number == 8) {
//            System.exit(0);
//        }
//    }
    public static DataBaseRepository dataBaseRepository = new DataBaseRepository();
    public static void main(String[] args) throws SQLException {
        GUIFrame guiFrame = new GUIFrame();
        guiFrame.setPreferredSize(new Dimension(1000, 560));
        guiFrame.pack();
        guiFrame.setVisible(true);

        }
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

