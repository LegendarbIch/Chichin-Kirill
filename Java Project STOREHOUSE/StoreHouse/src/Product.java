

// класс Товар
public class Product extends Provider {
    private String ProductName;
    private int ProductArticle;
    private int Price;
    private String ProductType;

    public Product(String ProductType, String ProviderName, String ProductName, int ProductArticle, int Price) {
        super(ProviderName);
        this.ProductName = ProductName;
        this.ProductArticle = ProductArticle;
        this.Price = Price;
        this.ProductType = ProductType;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getProductArticle() {
        return ProductArticle;
    }

    public void setProductArticle(int productArticle) {
        ProductArticle = productArticle;
    }

    public int getPrice() {return Price;}

    public void setPrice(int price) {Price = price;}

    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String productType) {
        ProductType = productType;
    }


    @Override
    public String toString() {
        return "|" + getProductArticle() + "| Название: |" + getProductName() + "| Поставщик: |" + getProviderName() + "| Тип: |" +
                getProductType() + "| Цена: |" + getPrice() + "|";

    }
}
