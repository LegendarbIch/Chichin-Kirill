// класс Товар
public class Product extends Provider {
    private String ProductName;
    private int ProductArticle;
    private int Price;
    private ProductType ProductType;

    public Product(ProductType ProductType, String ProviderName, String ProductName, int ProductArticle, int Price) {
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

    public ProductType getProductType() {
        return ProductType;
    }

    public void setProductType(ProductType productType) {
        ProductType = productType;
    }


    @Override
    public String toString() {
        return "Product{" +
                "ProductName='" + ProductName + '\'' +
                ", ProductArticle=" + ProductArticle +
                ", Price=" + Price +
                ", ProductType='" + ProductType + '\'' +
                '}' + "\n";
    }
}
