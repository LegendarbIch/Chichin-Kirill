import java.util.ArrayList;
import java.util.Scanner;
public class Sklad {
    private ArrayList<Technic> technic = new ArrayList<>();
    private ArrayList<BuildingMaterials> buildingMaterials = new ArrayList<>();
    private ArrayList<Buyer> buyers = new ArrayList<>();

    Scanner console = new Scanner(System.in);

    public ArrayList<Technic> AddToTech(String Type1, String Name,String productName,int productArticle,int count, int price) {
        technic.add(new Technic(Type1, Name, productName, productArticle, count, price));
        return technic;
    }
    public ArrayList<BuildingMaterials> AddToBM(String Type1,String Name,String productName,int productArticle, int count ,int price) {
        buildingMaterials.add(new BuildingMaterials(Type1 , Name, productName, productArticle, count, price));
        return buildingMaterials;
    }
    public ArrayList<Buyer> AddingBuyerToTheList(String fio) {
        buyers.add(new Buyer(fio));
        return buyers;
    }

    public Technic toStringTechnic() {
        for (Technic technic : technic) {
            System.out.print(technic.toString());
        }
        return null;
    }
    public BuildingMaterials toStringBM() {
        for (BuildingMaterials buildingMaterials1 : buildingMaterials) {
            System.out.print(buildingMaterials1.toString());
        }
        return null;
    }
    public Buyer toStringBuyers() {
        int k = 1;
        for (Buyer buyer : buyers) {
            System.out.print(buyer.toString(k++));
        }
        return null;
    }

    public void GiveBuyerProductOnTechnic(int productId, int buyerId, int count) {


        buyers.get(buyerId).products.add(technic.get(productId));
    }
    public void GiveBuyerProductOnBuildMaterial(int productId, int buyerId, int count) {
        buyers.get(buyerId).products.add(buildingMaterials.get(productId));
    }

    public void getBuyersProduct(int buyerId) {

        for (Buyer buyer : buyers) {
            System.out.println( buyer.getFIO() + "\n");
            for (Product product : buyer.products) {
                System.out.println(product.toString());
            }
        }
    }


}