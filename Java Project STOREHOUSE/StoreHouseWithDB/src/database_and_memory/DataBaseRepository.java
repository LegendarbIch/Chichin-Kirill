package database_and_memory;

import entities.Order;
import entities.ProductType;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class DataBaseRepository {
    private InMemoryRepository InMR = new InMemoryRepository();
    private DataBaseHandler dataBaseHandler = DataBaseHandler.getInstance();

    public InMemoryRepository getInMR() {
        return InMR;
    }
    public void addOrderToDB(int BuyerID, int ProductID, int Amount) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.ORDER_TABLE + "(" + Const.ORDER_BUYER_ID + "," + Const.ORDER_PRODUCT_ID + "," + Const.ORDER_PRODUCT_AMOUNT + ")" +
                "VALUES(?,?,?)";
        String amount = String.valueOf(Amount);
        String prodid = String.valueOf(ProductID);
        String update = "UPDATE " + Const.PRODUCT_TABLE + " SET " + Const.PRODUCT_AMOUNT + "=" +
                Const.PRODUCT_AMOUNT + "-" + amount + " WHERE " + Const.PRODUCT_ID + "=" + prodid;
        String query = "SELECT * FROM " + Const.PRODUCT_TABLE + " WHERE " + Const.PRODUCT_ID + "=" + prodid;
        PreparedStatement prSt = dataBaseHandler.CreateStatement(insert);
        Statement statement = dataBaseHandler.CreateStatement(update);
        ResultSet rs = dataBaseHandler.CreateResultSet(query);
        int A = 0;
        if (rs.next()) {
            A = rs.getInt(6);
        }
        if (A-Amount < 0) {
            System.out.println(A);
            JOptionPane.showMessageDialog(new JFrame(), "Не хватает товара на складе", "Ошибка",
                    JOptionPane.ERROR_MESSAGE);

        } else {
            prSt.setInt(1, BuyerID);
            prSt.setInt(2, ProductID);
            prSt.setInt(3, Amount);
            prSt.executeUpdate();
            statement.executeUpdate(update);
        }
        prSt.close();
        statement.close();
    }
    public void addBuyerToDB(String FIO) throws SQLException, ClassNotFoundException {

        String insert = "INSERT INTO " + Const.BUYERS_TABLE + "(" + Const.BUYERS_FIO + ")" +
                "VALUES(?)";
        PreparedStatement prSt = dataBaseHandler.CreateStatement(insert);
        try {

            prSt.setString(1, FIO);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { prSt.close();  }
            catch (SQLException e) { e.printStackTrace(); }
        }
    }
    public void deleteBuyerFromDB(int id) throws SQLException {
        String delete = "DELETE FROM " + Const.BUYERS_TABLE + " WHERE " +
                Const.BUYERS_ID + "=" + id;
        PreparedStatement prSt = dataBaseHandler.CreateStatement(delete);
        prSt.executeUpdate();
        prSt.close();
    }
    public void deleteProductFromDB(int id) throws SQLException {
        String delete = "DELETE FROM " + Const.PRODUCT_TABLE + " WHERE " +
                Const.PRODUCT_ID + "=" + id;
        PreparedStatement prSt = dataBaseHandler.CreateStatement(delete);
        prSt.executeUpdate();
        prSt.close();
    }
    public void deleteOrderFromDB(int id, String OrderId) throws SQLException {
        String delete = "DELETE FROM " + Const.ORDER_TABLE + " WHERE " +
                OrderId + "=" + id;
        PreparedStatement prSt = dataBaseHandler.CreateStatement(delete);
        prSt.executeUpdate();
        prSt.close();
    }
    public void FillBuyersFromDB() throws SQLException, ClassNotFoundException {
        String query = "SELECT * " +
                "FROM " + Const.BUYERS_TABLE;
        ResultSet rs = dataBaseHandler.CreateResultSet(query);
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String FIO = rs.getString(2);
                InMR.AddingBuyerToTheList(FIO, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { rs.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    public void FillProvidersFromDB() {
        String query = "SELECT * " +
                "FROM " + Const.PROVIDER_TABLE;
        ResultSet rs = dataBaseHandler.CreateResultSet(query);
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String provider = rs.getString(2);
                InMR.AddToProviders(id, provider);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void FillProductsFromDB() throws SQLException, ClassNotFoundException {
        String query = "SELECT * " +
                "FROM " + Const.PRODUCT_TABLE;
        ResultSet rs = dataBaseHandler.CreateResultSet(query);
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String prodName = rs.getString(2);
                int price = rs.getInt(3);
                String type = rs.getString(4);
                String provider = rs.getString(5);
                int amount = rs.getInt(6);
                InMR.AddToProduct(id, prodName, price, type, provider, amount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { rs.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    public void FillProductTypeFromDB() throws SQLException {
        String query = "SELECT * " +
                "FROM " + Const.PRODUCT_TYPE_TABLE;
        ResultSet rs = dataBaseHandler.CreateResultSet(query);
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String prodtypename = rs.getString(2);
                InMR.AddToProductType(id, prodtypename);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            rs.close();
        }
    }
    public void FillOrdersFromDB() throws SQLException {
        String query = "SELECT * " +
                "FROM " + Const.ORDER_TABLE;
        ResultSet rs = dataBaseHandler.CreateResultSet(query);
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                int buyerid = rs.getInt(2);
                int productid = rs.getInt(3);
                int prodcutamount = rs.getInt(4);
                InMR.TakeOrder(id, buyerid, productid, prodcutamount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            rs.close();
        }
    }
    public ArrayList<String> getGroupingProductOnType(String producttype) throws SQLException {
        String query = "SELECT * FROM " + Const.PRODUCT_TABLE + " WHERE " + Const.PRODUCT_TYPE + "="
                + "'" + producttype + "'";
        ResultSet rs = dataBaseHandler.CreateResultSet(query);
        ArrayList<String> product = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();
        try {
            while (rs.next()) {
                product.add(String.valueOf(rs.getInt(1)));
                product.add(rs.getString(2));
                product.add(String.valueOf(rs.getInt(3)));
                product.add(rs.getString(4));
                product.add(rs.getString(5));
                product.add(String.valueOf(rs.getInt(6)));
                data.add(String.valueOf(product));
                product.clear();
            }
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            rs.close();
        }
    }
    public boolean CheckTheSameType(String Table, String Column ,String type) throws SQLException {
        boolean itsTrue = false;
        String query = "SELECT * FROM " + Table + " WHERE " + Column + "="
                + "?" ;
        try (PreparedStatement prSt = dataBaseHandler.CreateStatement(query)) {
            prSt.setString(1, type);
            try(ResultSet rs = prSt.executeQuery()) {
                if(rs.next()) {
                    itsTrue = true;
                }
            }
        }
        return itsTrue;
    }
        public void addProductToDB(String ProductName, int Price, String Type, String Provider, int Amount) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO " + Const.PRODUCT_TABLE + "(" + Const.PRODUCT_NAME + "," + Const.PRODUCT_PRICE + ","
                + Const.PRODUCT_TYPE + "," + Const.PRODUCT_PROVIDER + "," + Const.PRODUCT_AMOUNT + ")" + "VALUES(?,?,?,?,?)";
        String query1 = "INSERT INTO " + Const.PROVIDER_TABLE + "(" + Const.PROVIDER_NAME + ")" + " VALUES(?)";
        String query2 = "INSERT INTO " + Const.PRODUCT_TYPE_TABLE + "(" + Const.PRODUCT_TYPE_NAME + ")" + " VALUES(?)";
        PreparedStatement prSt = dataBaseHandler.CreateStatement(query);
        PreparedStatement prSt1 = dataBaseHandler.CreateStatement(query1);
        PreparedStatement prSt2 = dataBaseHandler.CreateStatement(query2);
        try {
            prSt.setString(1, ProductName);
            prSt.setInt(2, Price);
            prSt.setString(3,Type);
            prSt.setString(4, Provider);
            prSt.setInt(5, Amount);
            prSt.executeUpdate();
            if (!CheckTheSameType(Const.PROVIDER_TABLE, Const.PROVIDER_NAME, Provider)) {
                prSt1.setString(1, Provider);
                prSt1.executeUpdate();
            }
            if (!CheckTheSameType(Const.PRODUCT_TYPE_TABLE, Const.PRODUCT_TYPE_NAME, Type)) {
                prSt2.setString(1, Type);
                prSt2.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            prSt.close();
        }

    }
    public void addFishedProductToDB(int ProductID, int Amount) throws SQLException {
        String amount = String.valueOf(Amount);
        String prodid = String.valueOf(ProductID);
        String query = "UPDATE " + Const.PRODUCT_TABLE + " SET " + Const.PRODUCT_AMOUNT + "=" +
                Const.PRODUCT_AMOUNT + "+" + amount + " WHERE " + Const.PRODUCT_ID + "=" + prodid;
        Statement st = dataBaseHandler.CreateStatement(query);
        st.executeUpdate(query);
        st.close();
    }
    public String getBuyersFromDBbyID(int ID) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM " + Const.BUYERS_TABLE + " WHERE " + ID + " = " + Const.BUYERS_ID;
        ResultSet rs = dataBaseHandler.CreateResultSet(query);
        try {
            if (rs.next()) {
                String FIO = rs.getString(2);
                return FIO;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }
        return null;
    }
    public String getProductFromDBbyID(int ID) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM " + Const.PRODUCT_TABLE + " WHERE " + ID + " = " + Const.PRODUCT_ID;
        ResultSet rs = dataBaseHandler.CreateResultSet(query);

        try {
            if (rs.next()) {
                return "[id " + rs.getInt(1) + " " +
                rs.getString(2) + " " +
                rs.getInt(3) + " '" +
                rs.getString(4) + "' " +
                rs.getString(5) + "| количество " +
                rs.getInt(6)+ "]";

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }
        return null;
    }
    public void CloseConnection() throws SQLException, ClassNotFoundException {
        dataBaseHandler.getDbConnection().close();
        System.out.println("База данных закрыта.");
    }

    public Vector getTableData(String TABLE){
        String query = "SELECT * " +
                "FROM " + TABLE;
        ResultSet rs = dataBaseHandler.CreateResultSet(query);
        Vector VectorData = new Vector();
        try {
            while (rs.next()) {

                Vector productInfo = new Vector();
                productInfo.add(rs.getInt(1));
                productInfo.add(rs.getString(2));
                productInfo.add(rs.getInt(3));
                productInfo.add(rs.getString(4));
                productInfo.add(rs.getString(5));
                productInfo.add(rs.getInt(6));
                VectorData.add(productInfo);
            }
            return VectorData;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { rs.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }
        return null;
    }

    //    public int AutoID() {
//        ArrayList<Integer> AllID = new ArrayList<>();
//        int maxID = 1;
//        if (products == null) {
//            return maxID;
//        }
//        for (entities.Product product: products) {
//            AllID.add(product.getProductArticle());
//        }
//        maxID = Collections.max(AllID);
//        return maxID;
//    }
}
