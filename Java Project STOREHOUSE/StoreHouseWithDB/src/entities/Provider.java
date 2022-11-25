package entities;

import java.util.ArrayList;

// Класс поставщик
public class Provider {

    public int getProviderID() {
        return ProviderID;
    }

    public void setProviderID(int providerID) {
        ProviderID = providerID;
    }

    private int ProviderID;
    private String ProviderName;
    public Provider(int ProviderID ,String ProviderName) {
        this.ProviderID = ProviderID;
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
        return "id " + getProviderID() + "| Поставщик: " + getProviderName();
    }

}
