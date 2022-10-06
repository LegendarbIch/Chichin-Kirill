package StoreHouse.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Sklad {
    public ArrayList<Product> products = new ArrayList<>();;
    private ArrayList<Buyer> buyers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    private HashMap<Integer, H ArrayList<ArrayList<Product>>> ProductOnBuyer = new HashMap<>();

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

    public void GiveBuyerProduct(int OrderID, int BuyerID, int[] ProductsID) {
        orders.add(new Order(OrderID, BuyerID, ProductsID));

        ProductOnBuyer.put(getBuyersByID(BuyerID), getProductByID(ProductsID));
        for (int i : ProductsID) {
            products.remove(i);
        }
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

    public Buyer getBuyersByID(int id) {
        for (Buyer buyer : buyers) {
            if (id == buyer.getBuyerId()) {
                System.out.println(buyers);
                return buyer;
            }
        }
        throw new NoSuchElementException();
    }

    public Product getProductByID(int id) {
        for (Product product : products) {
            if (id == product.getProductArticle()) {
                System.out.println(product);
                return product;
            }
        }
         throw new NoSuchElementException();
//        Product current =  products.stream().filter(product -> product.getPrice()==id).collect(Collectors.toList()).get(0);
//        return current;
    }

}