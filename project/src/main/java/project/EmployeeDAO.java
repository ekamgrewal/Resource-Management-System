package project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	private String host = "localhost";
	private int port = 1521;
	private String dbName = "xe";
	private String dbURL = "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbName;

	private String username = "system";
	private String password = "password";

	private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO EMPLOYEE VALUES (?,?,?)";
	private static final String SELECT_EMPLOYEE_BY_ID_SQL = "SELECT ID, NAME, SALARY FROM EMPLOYEE WHERE ID = ?";
	private static final String SELECT_ALL_EMPLOYEES_SQL = "SELECT * FROM EMPLOYEE";
	private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM EMPLOYEE WHERE ID = ?";
	private static final String UPDATE_EMPLOYEE_SQL = "UPDATE EMPLOYEE SET NAME = ?, SALARY = ? WHERE ID = ?";

	public EmployeeDAO() {
		Connection connection = getConnection();
		try {
			String query = "CREATE TABLE EMPLOYEE (ID NUMBER(3) PRIMARY KEY, NAME VARCHAR2(50) NOT NULL, SALARY NUMBER(6) NOT NULL)";
			Statement s = connection.createStatement();
			s.execute(query);
			System.out.println("TABLE CREATED!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("TABLE IS READY...");
		}
	}

	protected Connection getConnection() {
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

	public void insertEmployee(Employee employee) throws SQLException {
		System.out.println(INSERT_EMPLOYEE_SQL);

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);) {

			preparedStatement.setInt(1, employee.id);
			preparedStatement.setString(2, employee.name);
			preparedStatement.setDouble(3, employee.salary);

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Employee selectEmployee(int id) {
		Employee employee = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID_SQL);) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				double salary = resultSet.getDouble("salary");
				employee = new Employee(id, name, salary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	public List<Employee> selectAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES_SQL);) {

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				employees.add(new Employee(id, name, salary));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (Employee e : employees)
			System.out.println(e);
		return employees;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		}

		return rowDeleted;
	}

	public boolean updateEmployee(Employee employee) throws SQLException {
		boolean userUpdated;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setDouble(2, employee.getSalary());
			preparedStatement.setInt(3, employee.getId());
			userUpdated = preparedStatement.executeUpdate() > 0;
		}

		return userUpdated;
	}
}
