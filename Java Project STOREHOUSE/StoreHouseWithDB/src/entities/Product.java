package entities;

// класс Товар
public class Product {
    private String ProductName;
    private int ProductArticle;
    private int Price;
    private String ProductType;

    public String getProviderName() {
        return ProviderName;
    }

    public void setProviderName(String providerName) {
        ProviderName = providerName;
    }

    private String ProviderName;
    private int Amount;

    public Product(int ProductArticle,String ProductName, int Price, String ProductType, String ProviderName, int Amount) {
        this.ProviderName = ProviderName;
        this.ProductName = ProductName;
        this.ProductArticle = ProductArticle;
        this.Price = Price;
        this.ProductType = ProductType;
        this.Amount = Amount;
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

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    @Override
    public String toString() {
        return "|id " + getProductArticle() +" " +  getProductName() + "| Поставщик: |" + getProviderName() + "| Тип: |" +
                getProductType() + "| Цена: |" + getPrice() + " | Количество | " + getAmount() + "|";

    }
}
