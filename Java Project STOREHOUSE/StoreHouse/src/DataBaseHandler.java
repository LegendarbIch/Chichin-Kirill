import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseHandler extends Configs{

    private static DataBaseHandler INSTANCE;

    private DataBaseHandler(){}
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

}
