
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class Sklad {

    private final ArrayList<Product> products = new ArrayList<>();
    //Список наличия товара на складе ^
    public ArrayList<Product> AvailableProductPositions = new ArrayList<>();
    //Список позиций товаров ^
    private ArrayList<Buyer> buyers = new ArrayList<>();
    //Список покупателей ^
    private ArrayList<Order> orders = new ArrayList<>();
    //Список заказов ^
    private ArrayList<Provider> providers = new ArrayList<>();
    //Список поставщиков ^
    private int AutoIncrease = 10;
    private DataBaseHandler dataBaseHandler = DataBaseHandler.getInstance();

    public ArrayList<Product> getProducts() {
        return products;
    }
    public ArrayList<Buyer> getBuyers() {
        return buyers;
    }

    public PreparedStatement CreateStatement(String query) throws SQLException, ClassNotFoundException {
        PreparedStatement prSt = dataBaseHandler.getDbConnection().prepareStatement(query);
        return prSt;
    }
    public ResultSet CreateResultSet(String query) throws SQLException, ClassNotFoundException {
        ResultSet rs = dataBaseHandler.getDbConnection().createStatement().executeQuery(query);
        return rs;
    }

    public void addBuyerToDB(String FIO) throws SQLException, ClassNotFoundException {

        String insert = "INSERT INTO " + Const.BUYERS_TABLE + "(" + Const.BUYERS_FIO + ")" +
                "VALUES(?)";
        PreparedStatement prSt = CreateStatement(insert);
        try {

            prSt.setString(1, FIO);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { prSt.close(); System.out.println("PrepareStatement закрыт"); }
            catch (SQLException e) { e.printStackTrace(); }
        }
    }
    public void FillBuyersFromDB() throws SQLException, ClassNotFoundException {
        String query = "SELECT * " +
         "FROM " + Const.BUYERS_TABLE;
        ResultSet rs = CreateResultSet(query);
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String FIO = rs.getString(2);
                AddingBuyerToTheList(FIO, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { rs.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    public void FillProductsFromDB() throws SQLException, ClassNotFoundException {
        String query = "SELECT * " +
                "FROM " + Const.PRODUCT_TABLE;
        ResultSet rs = CreateResultSet(query);
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String prodName = rs.getString(2);
                int price = rs.getInt(3);
                String type = rs.getString(4);
                String provider = rs.getString(5);
                AddToProduct(type, provider, prodName, id, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { rs.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    public void addProductToDB( String Provider, String ProductName, int Price, String Type) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO " + Const.PRODUCT_TABLE + "(" + Const.PRODUCT_NAME + "," + Const.PRODUCT_PRICE + ","
                + Const.PRODUCT_TYPE + "," + Const.PRODUCT_PROVIDER + ")" + "VALUES(?,?,?,?)";
        PreparedStatement prSt = CreateStatement(query);
        try {
            prSt.setString(1, ProductName);
            prSt.setInt(2, Price);
            prSt.setString(3,Type);
            prSt.setString(4, Provider);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            prSt.close();
        }

    }
    public String getBuyersFromDBbyID(int ID) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM " + Const.BUYERS_TABLE + " LIMIT " + (ID-1) + "," + 1;
        ResultSet rs = CreateResultSet(query);
        try {
            if (rs.next()) {
                String FIO = rs.getString(2);
                return FIO;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }
        return null;
    }
    public String getProductFromDBbyID(int ID) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM " + Const.PRODUCT_TABLE + " LIMIT " + (ID-1) + "," + 1;
        ResultSet rs = CreateResultSet(query);
        try {
            if (rs.next()) {
                String FIO = rs.getString(2);
                return FIO;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }
        return null;
    }
    public void CloseConnection() throws SQLException, ClassNotFoundException {
        dataBaseHandler.getDbConnection().close();
        System.out.println("База данных закрыта.");
    }

        // Метод добавления товаров в список
    public void AddToProduct(String ProductType, String ProviderName, String productName, int productArticle, int price) {
        this.products.add(new Product(ProductType, ProviderName, productName, productArticle, price));
        this.AvailableProductPositions.add(new Product(ProductType, ProviderName, productName, productArticle, price));
        boolean bool = true;
        for (Provider provider: providers) {
            if (provider.getProviderName() == ProviderName) {
                bool = false;
                break;
            } else {
                bool = true;
            }
        }
        if (bool == true) {
            providers.add(new Provider(ProviderName));
        }
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

    public void getBuyers1() {
       buyers.forEach(System.out::println);
    }

    public void  getProviders1() {
        providers.forEach(System.out::println);
    }


    // Оформить заказ с айди покупателя с выданными ему айди товаров,
    // которые после удаляются из списка достпуных товаров
    public void GiveBuyerProduct(int OrderID, int BuyerID, int[] ProductsID) {
        orders.add(new Order(OrderID, BuyerID, ProductsID));
        for (int j = 0; j < ProductsID.length-1 ; j++) {
            int finalJ = j;
            products.removeIf(product -> product.getProductArticle() == ProductsID[finalJ]);
        }
    }

    public void getOrders1() {
        orders.forEach(System.out::println);
    }

    public Product getProductByID(int id) {
        for (Product product : AvailableProductPositions) {
            if (id == product.getProductArticle()) {
                System.out.println(product);
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
    public void getBuyersProduct() {
        for (Order order: orders) {
            System.out.print("Номер заказа: " + order.getOrderID() + "\n" +
                             "Покупатель: " + getBuyerByID(order.getBuyerID()) + "\n" +
                             "Товары: \n");
                            int[] arr = order.getProductsID();
                            for (int i: arr) {
                                getProductByID(i);
            }
        }

    }
    public void GroupingOfProductsByType() {
        List<Product> Type = AvailableProductPositions.stream().filter(product -> product.getProductType().equals(ProductType.Technic)).collect(Collectors.toList());
        List<Product> Type1 = AvailableProductPositions.stream().filter(product -> product.getProductType().equals(ProductType.BuildingMaterials)).collect(Collectors.toList());
        System.out.println(ProductType.Technic + ":\n" + Type + "\n" + ProductType.BuildingMaterials + ":\n" + Type1);
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
//    public int AutoID() {
//        ArrayList<Integer> AllID = new ArrayList<>();
//        int maxID = 1;
//        if (products == null) {
//            return maxID;
//        }
//        for (Product product: products) {
//            AllID.add(product.getProductArticle());
//        }
//        maxID = Collections.max(AllID);
//        return maxID;
//    }
}

