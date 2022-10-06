package StoreHouse.src;

import java.util.ArrayList;

public class Sklad {
    public ArrayList<Product> products = new ArrayList<>();;
    private ArrayList<Buyer> buyers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    private ArrayList<Provider> providers = new ArrayList<>();

    public void AddToProduct(ProductType ProductType, String ProviderName, String productName, int productArticle, int price) {
        this.products.add(new Product(ProductType, ProviderName, productName, productArticle, price));
        providers.add(new Provider(ProviderName));
    }
    public void AddToProviders(String ProviderName) {
        this.providers.add(new Provider(ProviderName));
    }
    public ArrayList<Buyer> AddingBuyerToTheList(String fio, int buyerid) {
        buyers.add(new Buyer(fio, buyerid));
        return buyers;
    }

    public void getProducts() {
       products.forEach(System.out::println);
    }

    public void getBuyers() {
       buyers.forEach(System.out::println);
    }

    public void  getProviders() {
        providers.forEach(System.out::println);
    }

    public void GiveBuyerProduct(int OrderID, int BuyerID, int ProductID) {
        orders.add(new Order(OrderID, BuyerID, ProductID));
        products.remove(ProductID);
    }
    public void getBuyersProduct() {
        int i = 1;
        for (Buyer buyer : buyers) {
            System.out.println( (i++) + ". " + buyer.getFIO() + "\n");
            for (Product product : buyer.products) {
                System.out.println("Отправленный товар:\n" + product.toString() + "\n");
            }
        }
    }
    public void getOrders() {
        orders.forEach(System.out::println);
    }
    public Product getProductByID(int id) {
        Product current = null;
        for (Product product : products) {
            if (id == product.getProductArticle()) {
                current = product;
                break;
            }
        }
        System.out.println(current);
        return current;
    }

}