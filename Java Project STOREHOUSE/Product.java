// класс Товар
public class Product extends Provider{
    private String ProductName;
    private int ProductArticle;

    public Product(String providerName, String ProductName, int ProductArticle) {
        super(providerName);
        this.ProductName = ProductName;
        this.ProductArticle = ProductArticle;
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

}
