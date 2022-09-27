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
}
