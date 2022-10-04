// класс Товар
public class Product extends Provider {
    private String ProductName;
    private int ProductArticle;
    private int Price;
    private String ProductType;
    private int Count;

    public Product(String ProductType, String ProviderName, String ProductName, int ProductArticle, int Count ,int Price) {
        super(ProviderName);
        this.ProductName = ProductName;
        this.ProductArticle = ProductArticle;
        this.Price = Price;
        this.Count = Count;
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

    public void setProductType(String type1) {
        ProductType = type1;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductName='" + ProductName + '\'' +
                ", ProductArticle=" + ProductArticle +
                ", Price=" + Price +
                ", ProductType='" + ProductType + '\'' +
                ", Count=" + Count +
                '}';
    }
}
