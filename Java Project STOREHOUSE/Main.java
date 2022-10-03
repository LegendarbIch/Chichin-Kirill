import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Sklad sklad = new Sklad();
    static Scanner console = new Scanner(System.in);
    public static void  AddingProductToTech(String Name,String productName,int productArticle,int price) {

        sklad.AddToTech("Техника", Name,productName,productArticle,price);

    }
    public static void  AddingProductToBuildMaterials(String Name, String productName, int productArticle, int price) {

        sklad.AddToBM("Строительные материалы", Name , productName,productArticle,price);

    }
    public static void GivingBuyerProductOnTech(int ProductId, int BuyerId) {
        sklad.GiveBuyerProductOnTechnic(ProductId, BuyerId);
    }
    public static void GivingBuyerProductOnBM(int ProductId, int BuyerId ) {
        sklad.GiveBuyerProductOnBuildMaterial(ProductId, BuyerId);
    }

    public static void AddingProducts(){
        System.out.print("Какой тип товара вы хотите добавить?  1.Техника   2.Строительные материалы");
        int number = console.nextInt();
        System.out.print("Введите поставщика: ");
        String Name = console.nextLine();
        Provider.setProviderName(Name);
        System.out.print("Введите товар: ");
        String productName = console.nextLine();
        System.out.print("Введите артикль товара: ");
        int productArticle = console.nextInt();
        System.out.print("Введите цену товара: ");
        int price = console.nextInt();
        if (number == 1) {
            AddingProductToTech(Name, productName, productArticle, price);
        } else if (number == 2) {
            AddingProductToBuildMaterials(Name, productName, productArticle, price);
        }
    }
    public static void MenuAddBuyer() {
        System.out.print("1.Добавить покупателя  \n" +
                         "2.Отпустить товар       ");
        int num = console.nextInt();
        if (num == 1) {
            int k = 1;
            System.out.print("Введите покупателя или покупателей: \n");
            while (num != 2) {
                System.out.print(k + ".");
                k++;
                String FIO = console.nextLine();
                sklad.AddingBuyerToTheList(FIO);
                System.out.print("Дальше? 1.Да \n" +
                        "        2.Нет  ");
                num = console.nextInt();
                if (num == 2) {
                    MenuAddBuyer();
                }
            }
        } else if (num==2) {
            System.out.print("Какому покупателю вы хотите отправить товар? \n ");
            sklad.toStringBuyers();
            int bu_id = console.nextInt();
            System.out.print("Из какой категории товаров отправить ?     1.Техника\n" +
                             "                                           2.Строильтельные материалы            ");
            num = console.nextInt();
            if (num == 1) {
                System.out.print("Какой товар отправить покупателю? \n" + "Выбор происходит по артиклю \n");
                sklad.toStringTechnic();
                int prod_id = console.nextInt();
                GivingBuyerProductOnTech(prod_id, bu_id - 1);
                sklad.getBuyersProduct();
            } else if (num == 2) {
                System.out.print("Какой товар отправить покупателю? \n" + "Выбор происходит по артиклю \n");
                sklad.toStringBM();
                int prod_id = console.nextInt();
                GivingBuyerProductOnBM(prod_id, bu_id - 1);
                sklad.getBuyersProduct();
            }
        }
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
        int number = console.nextInt();
        // если добавлять товар
        if (number == 1) {
            AddingProducts();
            int number2 = 0;
            while (number2 != 2) {
                System.out.println("Добавить еще товар?   1." + "\n" +
                                   "Выйти в главное меню? 2." + "\n");
                number2 = console.nextInt();
                if (number2 == 1) {
                    AddingProducts();
                } else if (number2 == 2) {
                    System.out.print("\n\n\n\n\n");
                    Menu();
                }
            }
            // если отпускать покупателю
        } else if (number == 2) {
                MenuAddBuyer();
        } else if (number == 8) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        AddingProductToBuildMaterials("Строй", "Доски", 0, 120);
        AddingProductToTech("Avo", "компьютер", 0, 30000);
        AddingProductToTech("Techno", "Джостик", 1, 1200);
        sklad.AddingBuyerToTheList("Кирилл");
        sklad.AddingBuyerToTheList("Б.О. Валин");
        sklad.GiveBuyerProductOnTechnic(1,1);
        Menu();

    }
}
