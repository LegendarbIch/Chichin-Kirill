import java.util.ArrayList;

// Класс поставщик
public class Provider {
    private static ArrayList providers = new ArrayList<>();
    private static String ProviderName;
    public Provider(String ProviderName) {
        this.ProviderName = ProviderName;
    }


    public static String getProviderName() {
        return ProviderName;
    }


    public static void setProviderName(String providerName) {
        ProviderName = providerName;
        providers.add(ProviderName);

    }
    public static void ShowListProviderName() {
        System.out.print(providers);
    }

}
