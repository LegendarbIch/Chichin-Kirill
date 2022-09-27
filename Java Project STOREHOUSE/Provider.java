import java.util.ArrayList;

// Класс поставщик
public class Provider {
    public Provider(String providerName) {
        ProviderName = providerName;
    }

    private String ProviderName;

    public String getProviderName() {
        return ProviderName;
    }

    public void setProviderName(String providerName) {
        ProviderName = providerName;
    }

  /*  ArrayList<Provider> providers = new ArrayList<>();
    public void AddNewProvider(String providerName) {

        providers.add(new Product(providerName));

        for (Provider provider: providers) {
            System.out.println("Поставщик: "
        }
        AddNewProduct("ООО Стройбат","Моноблок", 10);
        AddNewProduct("Игрушкаленд","Мишка плюшевый", 11);
    }*/
}
