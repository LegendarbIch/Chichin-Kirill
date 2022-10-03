import java.util.ArrayList;
import java.util.Scanner;
public class Sklad {
    private ArrayList<Technic> technic = new ArrayList<>();
    private ArrayList<BuildingMaterials> buildingMaterials = new ArrayList<>();

    private ArrayList<Buyer> buyers = new ArrayList<>();

    Scanner console = new Scanner(System.in);

//    public void AddNewProduct(String Name,String productName,int productArticle,int price) {
//        System.out.print("Какой тип товара вы хотите добавить?  1.Техника   2.Строительные материалы");
//        int num = console.nextInt();
//        console.nextLine();
//        if (num == 1) {
//            technic.add(new Technic(Name, productName, productArticle, price));
//        } else if (num == 2) {
//            buildingMaterials.add(new BuildingMaterials(Name,productName,productArticle,price));
//        }

//    }
    public ArrayList<Technic> AddToTech(String Type1, String Name,String productName,int productArticle,int price) {
        technic.add(new Technic(Type1, Name, productName, productArticle, price));
        return technic;
    }
    public ArrayList<BuildingMaterials> AddToBM(String Type1,String Name,String productName,int productArticle,int price) {
        buildingMaterials.add(new BuildingMaterials(Type1 , Name, productName, productArticle, price));
        return buildingMaterials;
    }
    public void AddingBuyerToTheList(String fio) {
        buyers.add(new Buyer(fio));
    }
//    private void ExampleProductOutput(Product product) {
//        System.out.println("Тип: " + product.getType1() + "\n" +
//                "Поставщик: " + Provider.getProviderName() + "\n" +
//                "Товар: " + product.getProductName() + "\n" +
//                "Артикль товара: " + product.getProductArticle() + "\n" +
//                "Цена товара: " + product.getPrice() + "\n");
//    }
//    public void ExampleBuyerOutput(Buyer buyer) {
//        System.out.println("Покупатель: " + buyer.getFIO());
//
//    }
    public void toStringTechnic() {
        for (Technic technic : technic) {
            technic.toString();
        }
    }
    public void toStringBM() {
        for (BuildingMaterials buildingMaterials1 : buildingMaterials) {
            buildingMaterials1.toString();
        }
    }
    public void toStringBuyers() {
        for (Buyer buyer : buyers) {
            buyer.toString();
        }
    }
    public void GiveBuyerProductOnTechnic(int productId, int buyerId) {
        for (Buyer buyer : buyers) {
            buyer.products.add(technic.get(0));
        }
        for (Buyer buyer : buyers) {
            System.out.print( buyer.getFIO() + "\n  ");
            for (Product product : buyer.products) {
                System.out.println(product.toString());
            }
        }
    }
    public void GiveBuyerProductOnBuildMaterial(int productId, int buyerId) {

    }

    public void getBuyersProduct() {
       System.out.println(buyers);
    }
    public Buyer getBuyer(int n) {
        return buyers.get(n);
    }

}