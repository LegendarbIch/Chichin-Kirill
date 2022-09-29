import java.util.ArrayList;
import java.util.Scanner;
public class Sklad {
    private ArrayList<Technic> technic = new ArrayList<>();
    private ArrayList<BuildingMaterials> buildingMaterials = new ArrayList<>();
    private ArrayList<ArrayList<String>> ProductAtTheBuyers = new ArrayList<ArrayList<String>>();

    private Buyers buyer = new Buyers();
    Scanner console = new Scanner(System.in);

    public void AddNewProduct() {

        System.out.print("Какой тип товара вы хотите добавить?  1.Техника   2.Строительные материалы");
        int num = console.nextInt();
        console.nextLine();
        System.out.print("Введите поставщика: ");
        String Name = console.nextLine();
        Provider.setProviderName(Name);
        System.out.print("Введите товар: ");
        String productName = console.nextLine();
        System.out.print("Введите артикль товара: ");
        int productArticle = console.nextInt();
        System.out.print("Введите цену товара: ");
        int price = console.nextInt();
        if (num == 1) {
            technic.add(new Technic(Name, productName, productArticle, price));
        } else if (num == 2) {
            buildingMaterials.add(new BuildingMaterials(Name,productName,productArticle,price));
        }

    }
    private void ExampleOutput(Product product) {
        System.out.println("Поставщик: " + Provider.getProviderName() + "\n" +
                "Товар: " + product.getProductName() + "\n" +
                "Артикль товара: " + product.getProductArticle() + "\n" +
                "Цена товара: " + product.getPrice() + "\n");
    }
    public void toStringTechnic() {
        for (Product product : technic) {
            ExampleOutput(product);
        }
    }
    public void toStringBM() {
        for (Product product : buildingMaterials) {
            ExampleOutput(product);
        }
    }

    public void GiveBuyerProduct(int productId, int buyerId) {
        ArrayList<String> Total = new ArrayList<>();
        Total.add(String.valueOf(buyer.getBuyer(buyerId)));
        int num = console.nextInt();
        if (num == 1) {
            Total.add(String.valueOf(technic.get(productId)));
        } else if (num == 2) {
            Total.add(String.valueOf(buildingMaterials.get(buyerId)));
        }

        ProductAtTheBuyers.add(Total);
    }

    public void AddNewBuyer() {
        String buyerFIO = console.nextLine();
        buyer.AddingBuyerToTheList();
    }
    public void ShowBuyers() {
        buyer.getBuyers();
    }
    public void getBuyersProduct() {
        System.out.print(ProductAtTheBuyers);
    }
}