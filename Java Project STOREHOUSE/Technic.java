public class Technic extends Product{
    public Technic( String Type1, String ProviderName,String ProductName, int ProductArticle, int Count, int Price) {
        super(Type1, ProviderName,ProductName, ProductArticle, Count, Price);
    }
    public String toString() {
        return  "\nНазвание: " + getProductName() + '\n' +
                "Поставщик: " + getProviderName() + "\n" +
                "Артикль продукта: " + getProductArticle() + "\n" +
                "Цена: " + getPrice() + "\n" +
                "Тип: " + getType1() + '\n' +
                "Количество: " + getCount() + "\n";
    }
}
