package database_and_memory;

import java.sql.*;

public class DataBaseHandler extends Configs {

    private static DataBaseHandler INSTANCE;

    DataBaseHandler(){}
    Connection dbConnection;

    public static DataBaseHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataBaseHandler();
        }
        return INSTANCE;
    }

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {

        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);

        return dbConnection;
    }
    public PreparedStatement CreateStatement(String query) {
        try {
            return getDbConnection().prepareStatement(query);
        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet CreateResultSet(String query) {
        try {
            return getDbConnection().createStatement().executeQuery(query);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
