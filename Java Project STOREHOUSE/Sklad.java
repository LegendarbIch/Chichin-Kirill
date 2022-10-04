import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
public class Sklad {
    private ArrayList<Product> products = new ArrayList<>();;
    private ArrayList<Buyer> buyers = new ArrayList<>();
    public void AddToProduct(String ProductType, String Name, String productName, int productArticle, int count, int price) {
        this.products.add(new Product(ProductType, Name, productName, productArticle, count, price));

    }
    public ArrayList<Buyer> AddingBuyerToTheList(String fio) {
        buyers.add(new Buyer(fio));
        return buyers;
    }

    public Product toStringProducts() {
        for (Product product : products) {
            System.out.print(product.toString());
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
    public void GiveBuyerProduct(int productId, int buyerId, int count) {
        Product product = products.get(productId);
        int c = product.getCount();
        product.setCount(count);
        buyers.get(buyerId).products.add(product);
        product.setCount(c - count);
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
    public Product getProductByID(int id) {
        Product current = null;
        for(Product product: products) {
            if (id == product.getProductArticle()) {
                current = product;
                break;
            }
        }
        return current;
    }

}