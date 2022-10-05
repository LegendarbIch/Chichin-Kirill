import java.util.ArrayList;

public class Sklad {
    private ArrayList<Product> products = new ArrayList<>();;
    private ArrayList<Buyer> buyers = new ArrayList<>();

    private ArrayList<Order> orders = new ArrayList<>();

    public void AddToProduct(String ProductType, String ProductName, String productName, int productArticle, int price) {
        this.products.add(new Product(ProductType, ProductName, productName, productArticle, price));
    }
    public ArrayList<Buyer> AddingBuyerToTheList(String fio, int buyerid) {
        buyers.add(new Buyer(fio, buyerid));
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
//    public void GiveBuyerProduct(int productId, int buyerId) {
//        Product product = products.get(productId);
//        int c = product.getCount();
//        product.setCount(count);
//        buyers.get(buyerId).products.add(product);
//        product.setCount(c - count);
//    }

    public void GiveBuyerProduct(int OrderID, int BuyerID, int ProductID, ArrayList<Product> Products) {
        orders.add(new Order(OrderID, BuyerID, ProductID, Products));
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
    public ArrayList<Product> getProductByID(int id) {
        ArrayList<Product> current = new ArrayList<>();
        for(Product product: products) {
            if (id == product.getProductArticle()) {
                current.add(products.get(id));
                break;
            }
        }
        return current;
    }

}