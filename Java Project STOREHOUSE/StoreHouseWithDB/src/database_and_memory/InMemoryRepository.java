package database_and_memory;

import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryRepository {
    private ArrayList<Sklad> sklad = new ArrayList<>();
    private final ArrayList<Product> products = new ArrayList<>();
    //Список наличия товара на складе ^
    private ArrayList<Product> AvailableProductPositions = new ArrayList<>();
    //Список позиций товаров ^
    private ArrayList<Buyer> buyers = new ArrayList<>();

    //Список покупателей ^
    private ArrayList<Order> orders = new ArrayList<>();
    //Список заказов ^
    private ArrayList<Provider> providers = new ArrayList<>();

    public String getSkladData() {
        return new Sklad(Const.StoreHouse_name, Const.StoreHouse_address).toString();
    }
    public void AddToProduct(int productArticle,String productName,int price,String ProductType,String ProviderName, int Amount) {
        this.products.add(new Product(productArticle, productName, price, ProductType, ProviderName, Amount));
//        boolean bool = true;
//        for (Provider provider: providers) {
//            if (provider.getProviderName() == ProviderName) {
//                bool = false;
//                break;
//            } else {
//                bool = true;
//            }
//        }
//        if (bool == true) {
//            providers.add(new Provider(ProviderName));
//        }
    }
    // Метод добавления поставщиков по отдельности в список
    public void AddToProviders(String ProviderName) {
        this.providers.add(new Provider(ProviderName));
    }

    // Метод добавления покупателя в список
    public void AddingBuyerToTheList(String fio, int buyerid) {
        buyers.add(new Buyer(fio, buyerid));
    }

    public void getAvailableProductPositions() {
        AvailableProductPositions.forEach(System.out::println);
    }


    public void TakeOrder(int OrderID, int BuyerID, int ProductsID, int Amount) {
        orders.add(new Order(OrderID, BuyerID, ProductsID, Amount));
    }

    public Product getProductByID(int id) {
        for (Product product : products) {
            if (id == product.getProductArticle()) {
                return product;
            }
        }
        return null;
    }
    public Buyer getBuyerByID(int id) {
        for (Buyer buyer : buyers) {
            if (id == buyer.getBuyerId()) {
                return buyer;
            }
        }
        return null;
    }
    public Order getOrderByID(int id) {
        for (Order order : orders) {
            if (id == order.getOrderID()) {
                return order;
            }
        }
        return null;
    }

    public void getBuyersProduct() {
        for (Order order: orders) {
            System.out.print("Номер заказа: " + order.getOrderID() + "\n" +
                    "Покупатель: " + getBuyerByID(order.getBuyerID()) + "\n" +
                    "Товары: \n" + getProductByID(order.getProductsID()));
        }
    }

    public void GroupingOfProductsByType(String productType) {
        List<Product> Type = AvailableProductPositions.stream().filter(product -> product.getProductType().equals(productType)).collect(Collectors.toList());
        System.out.println(productType + ":\n" + Type);
    }

    public void getInfoOnProviders() {
        for (Provider provider: providers) {
            System.out.println("Поставщик: " + provider.getProviderName());
            List<Product> ProviderGoods = AvailableProductPositions.stream().filter(product -> product.getProviderName()
                    .equals(provider.getProviderName())).collect(Collectors.toList());
            System.out.println("Поставляемый товар:\n " + ProviderGoods);
            ProviderGoods.clear();
        }
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    public ArrayList<Buyer> getBuyers() {
        return buyers;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

}
