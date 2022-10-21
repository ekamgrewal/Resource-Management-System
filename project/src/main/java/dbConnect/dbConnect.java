package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnect {
	private String host = "localhost";
	private int port = 1521;
	private String dbName = "xe";
	private String dbURL = "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbName;

	private String username = "system";
	private String password = "password";
	
	public dbConnect() {}
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(dbURL, username, password);
		} catch (SQLException e) {
			System.out.println("Connection error: " + e);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error loading driver: " + cnfe);
		}
		return connection;
	}
}
