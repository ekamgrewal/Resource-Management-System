package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbConnect.dbConnect;

public class ProductDAO {
	private dbConnect connect = new dbConnect();
	
	private static final String INSERT_PRODUCT_SQL = "INSERT INTO PRODUCT VALUES (?,?,?)";
	private static final String SELECT_PRODUCT_BY_ID_SQL = "SELECT ID, NAME, PRICE FROM PRODUCT WHERE ID = ?";
	private static final String SELECT_PRODUCT_BY_NAME_SQL = "SELECT ID, NAME, PRICE FROM PRODUCT WHERE NAME = ?";
	private static final String SELECT_ALL_PRODUCTS_SQL = "SELECT * FROM PRODUCT";
	private static final String DELETE_PRODUCT_SQL = "DELETE FROM PRODUCT WHERE ID = ?";
	private static final String UPDATE_PRODUCT_SQL = "UPDATE PRODUCT SET NAME = ?, PRICE = ? WHERE ID = ?";
	
	public ProductDAO() {
		Connection connection = connect.getConnection();
		try {
			String query = "CREATE TABLE PRODUCT (ID NUMBER(3) PRIMARY KEY, NAME VARCHAR2(50) NOT NULL, PRICE NUMBER(6) NOT NULL)";
			Statement s = connection.createStatement();
			s.execute(query);
			System.out.println("TABLE CREATED!!!");
		} catch (SQLException e) {
			System.out.println("TABLE IS READY...");
		}
	}
	
	public void insertProduct(Product product) throws SQLException {
		try (Connection connection = connect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);) {

			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setDouble(3, product.getPrice());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Product selectProduct(int id) {
		Product product = null;

		try (Connection connection = connect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID_SQL);) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				double price = resultSet.getDouble("price");
				product = new Product(id, name, price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	public Product selectProduct(String name) {
		Product product = null;

		try (Connection connection = connect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME_SQL);) {
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				double price = resultSet.getDouble("price");
				product = new Product(id, name, price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}

	public List<Product> selectAllProducts() {
		List<Product> products = new ArrayList<Product>();
		try (Connection connection = connect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS_SQL);) {

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				products.add(new Product(id, name, price));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public boolean deleteProduct(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = connect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		}

		return rowDeleted;
	}

	public boolean updateProduct(Product product) throws SQLException {
		boolean userUpdated;
		try (Connection connection = connect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setInt(3, product.getId());
			userUpdated = preparedStatement.executeUpdate() > 0;
		}

		return userUpdated;
	}
}
