import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import database.*;
public class testConnection {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            System.out.println("Connection test passed! ");
            DatabaseConnection.closeConnection(connection);
        } else {
            System.out.println("Connection test failed! ");
        }
    }
}