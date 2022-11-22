package entities;

import database_and_memory.Const;
import database_and_memory.DataBaseHandler;
import entities.Buyer;
import entities.Order;
import entities.Product;
import entities.Provider;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class Sklad {
    @Override
    public String toString() {
        return  "Склад: " + getStoreHouseName() + "/n" +
                "Адресс: " + getStoreHouseAddress();
    }

    private String StoreHouseName;

    private String StoreHouseAddress;

    public Sklad(String shn, String sha) {
        this.StoreHouseName = shn;
        this.StoreHouseAddress = sha;
    }

    public String getStoreHouseName() {
        return StoreHouseName;
    }

    public void setStoreHouseName(String storeHouseName) {
        StoreHouseName = storeHouseName;
    }
    public String getStoreHouseAddress() {
        return StoreHouseAddress;
    }

    public void setStoreHouseAddress(String storeHouseAddress) {
        StoreHouseAddress = storeHouseAddress;
    }
}

