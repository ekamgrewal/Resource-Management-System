package employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dbConnect.dbConnect;

public class EmployeeDAO {

	private dbConnect connect = new dbConnect();

	private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO EMPLOYEE VALUES (?,?,?,?,?)";
	private static final String SELECT_EMPLOYEE_BY_ID_SQL = "SELECT ID, NAME, HOURS_WORKED, SALARY, PROJECTED_INCOME FROM EMPLOYEE WHERE ID = ?";
	private static final String SELECT_ALL_EMPLOYEES_SQL = "SELECT * FROM EMPLOYEE";
	private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM EMPLOYEE WHERE ID = ?";
	private static final String UPDATE_EMPLOYEE_SQL = "UPDATE EMPLOYEE SET NAME = ?, HOURS_WORKED = ?, SALARY = ?, PROJECTED_INCOME = ? WHERE ID = ?";

	public EmployeeDAO() {
		Connection connection = connect.getConnection();
		try {
			String query = "CREATE TABLE EMPLOYEE (ID NUMBER(3) PRIMARY KEY, NAME VARCHAR2(50) NOT NULL, HOURS_WORKED NUMBER(3), SALARY NUMBER(6) NOT NULL, PROJECTED_INCOME NUMBER(10))";
			Statement s = connection.createStatement();
			s.execute(query);
			System.out.println("TABLE CREATED!!!");
		} catch (SQLException e) {
			System.out.println("TABLE IS READY...");
		}
	}

	public void insertEmployee(Employee employee) throws SQLException {
		System.out.println(INSERT_EMPLOYEE_SQL);

		try (Connection connection = connect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);) {

			preparedStatement.setInt(1, employee.id);
			preparedStatement.setString(2, employee.name);
			preparedStatement.setDouble(3, employee.hoursWorked);
			preparedStatement.setDouble(4, employee.salary);
			preparedStatement.setDouble(5, employee.projectedIncome);

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Employee selectEmployee(int id) {
		Employee employee = null;

		try (Connection connection = connect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID_SQL);) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				double salary = resultSet.getDouble("salary");
				double hoursWorked = resultSet.getDouble("hours_worked");
				employee = new Employee(id, name, hoursWorked, salary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	public List<Employee> selectAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		try (Connection connection = connect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES_SQL);) {

			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				double salary = resultSet.getDouble("salary");
				double hoursWorked = resultSet.getDouble("hours_worked");
				employees.add(new Employee(id, name, hoursWorked, salary));
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
		try (Connection connection = connect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		}

		return rowDeleted;
	}

	public boolean updateEmployee(Employee employee) throws SQLException {
		boolean userUpdated;
		try (Connection connection = connect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setDouble(2, employee.getHourWorked());
			preparedStatement.setDouble(3, employee.getSalary());
			preparedStatement.setDouble(4, employee.getProjectedIncome());
			preparedStatement.setInt(5, employee.getId());
			userUpdated = preparedStatement.executeUpdate() > 0;
		}

		return userUpdated;
	}
}
