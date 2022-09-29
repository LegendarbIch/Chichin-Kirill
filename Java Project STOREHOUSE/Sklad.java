import java.util.ArrayList;
import java.util.Scanner;
public class Sklad {
    private ArrayList<Technic> technic = new ArrayList<>();
    private ArrayList<Buyers> ProductAtTheBuyers = new ArrayList<>();
    private Buyers buyer = new Buyers();
    Scanner console = new Scanner(System.in);

    public void AddNewProduct() {

        System.out.print("Какой тип товара вы хотите добавить?  1.Техника   2.Строительные материалы");
        int num = console.nextInt();
        console.nextLine();
        if (num == 1) {
            System.out.print("Введите поставщика: ");
            String Name = console.nextLine();
            Provider.setProviderName(Name);
            System.out.print("Введите товар: ");
            String productName = console.nextLine();
            System.out.print("Введите артикль товара: ");
            int productArticle = console.nextInt();
            System.out.print("Введите цену товара: ");
            int price = console.nextInt();
            technic.add(new Technic(Name, productName, productArticle, price));
        }

    }

    public String toString() {
        for (Product product : technic) {
            System.out.println("Поставщик: " + Provider.getProviderName() + "\n" +
                    "Товар: " + product.getProductName() + "\n" +
                    "Артикль товара: " + product.getProductArticle() + "\n" +
                    "Цена товара: " + product.getPrice() + "\n");
        }
        return null;
    }

    public void GiveBuyerProduct() {

        System.out.print("Кому отправить товар? \n");
        System.out.print(buyer.getBuyers());

    }

    public void AddNewBuyer() {
            System.out.print("Добавить нового покупателя? 1.Да "+"\n"+
                    "                            2.Нет "+"\n");
        int num = console.nextInt();
            if(num ==1)

        {
            buyer.AddingBuyerToTheList();
        } else {

            }
    }
}