import java.lang.reflect.Type;

public class BuildingMaterials extends Product{

    public BuildingMaterials(String Type1, String ProviderName, String ProductName, int ProductArticle, int Price) {
        super(Type1, ProviderName, ProductName, ProductArticle, Price);
    }
    public String toString() {
        return "Product{" +
                "Название:'" + getProductName() + '\'' +
                ", Артикль продукта:" + getProductArticle() +
                ", Цена:" + getPrice() +
                ", Тип:'" + getType1() + '\'' +
                '}';
    }
}
