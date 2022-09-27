import java.util.ArrayList;

public class Main {
    public static void AddNewProduct(String ProviderName, String ProductName, int ProductArticle ) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(ProviderName, ProductName, ProductArticle));

        for (Product product: products) {
            System.out.println("Поставщик: " + product.getProviderName() + "\n" +
                               "Товар: " + product.getProductName() + "\n" +
                               "Артикль товара: "+ product.getProductArticle() + "\n");
        }

    }
    public static void main(String[] args) {
        AddNewProduct("ООО Стройбат","Моноблок", 10);
        AddNewProduct("Игрушкаленд","Мишка плюшевый", 11);
    }
}
