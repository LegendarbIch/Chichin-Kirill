import java.util.ArrayList;
import java.util.Scanner;
public class Sklad {
    ArrayList<Product> products = new ArrayList<>();
    public void AddNewProduct(String ProviderName, String ProductName, int ProductArticle ) {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите название поставщика: ");
        String providerName = console.nextLine();
        System.out.print("Введите товар: ");
        String productName = console.nextLine();
        System.out.print("Введите артикль товара: ");
        int productArticle = console.nextInt();
        products.add(new Product(providerName, productName, productArticle));
    }

    public String toString() {
        for (Product product : products) {
            System.out.println("Поставщик: " + product.getProviderName() + "\n" +
                    "Товар: " + product.getProductName() + "\n" +
                    "Артикль товара: " + product.getProductArticle() + "\n");
            }
        return null;
    }
}