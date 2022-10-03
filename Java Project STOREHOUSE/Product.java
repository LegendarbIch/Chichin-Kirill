// класс Товар
public class Product extends Provider {


    private String ProductName;


    private int ProductArticle;
    private int Price;

    private String Type1;

    private int Count;

    public Product(String Type1, String ProviderName, String ProductName, int ProductArticle, int Count ,int Price) {
        super(ProviderName);
        this.ProductName = ProductName;
        this.ProductArticle = ProductArticle;
        this.Price = Price;
        this.Count = Count;
        this.Type1 = Type1;
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

    public String getType1() {
        return Type1;
    }

    public void setType1(String type1) {
        Type1 = type1;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }


}
