package database_and_memory;

import entities.Order;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                " VALUES(?)";
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
    public void addProductToDB(String ProductName, int Price, String Type, String Provider, int Amount) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO " + Const.PRODUCT_TABLE + "(" + Const.PRODUCT_NAME + "," + Const.PRODUCT_PRICE + ","
                + Const.PRODUCT_TYPE + "," + Const.PRODUCT_PROVIDER + "," + Const.PRODUCT_AMOUNT + ")" + "VALUES(?,?,?,?,?)";
        String query1 = "INSERT INTO " + Const.PROVIDER_TABLE + "(" + Const.PROVIDER_NAME + ")" + " VALUES(?)";
        PreparedStatement prSt = dataBaseHandler.CreateStatement(query);
        PreparedStatement prSt1 = dataBaseHandler.CreateStatement(query1);
        try {
            prSt.setString(1, ProductName);
            prSt.setInt(2, Price);
            prSt.setString(3,Type);
            prSt.setString(4, Provider);
            prSt.setInt(5, Amount);
            prSt.executeUpdate();
            prSt1.setString(1,Provider);
            prSt1.executeUpdate();
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
                String name = rs.getString(2);
                return name;
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
