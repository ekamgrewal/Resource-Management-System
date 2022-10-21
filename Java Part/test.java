import java.sql.*;

public class test {
    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading driver: " + cnfe);
        }

        String host = "localhost";
        int port = 1521;
        String dbName = "xe";
        String dbURL = "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbName;

        System.out.println(dbURL);
        String username = "system";
        String password = "password";

        Connection connection = DriverManager.getConnection(dbURL, username, password);
        //Statement statement = connection.createStatement();

        DatabaseMetaData dbMetaData = connection.getMetaData();
        String productName =dbMetaData.getDatabaseProductName();
        System.out.println("Database: " + productName);
        String productVersion =dbMetaData.getDatabaseProductVersion();
        System.out.println("Version: " + productVersion);

       //String query = 
    }
}
