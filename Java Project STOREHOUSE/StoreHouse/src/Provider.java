package StoreHouse.src;

import java.util.ArrayList;

// Класс поставщик
public class Provider {

    private String ProviderName;
    public Provider(String ProviderName) {
        this.ProviderName = ProviderName;
    }


    public String getProviderName() {
        return ProviderName;
    }

    public void setProviderName(String providerName) {
        ProviderName = providerName;
    }

    @Override
    public String toString() {
        return "Поставщик: " + ProviderName;
    }

}
