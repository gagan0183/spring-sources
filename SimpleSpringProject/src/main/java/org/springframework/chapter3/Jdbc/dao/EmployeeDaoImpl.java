package org.springframework.chapter3.Jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.chapter3.Jdbc.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private DataSource dataSource;
	
	public Employee getEmployeeId(int id) {
		Connection connection= null;
		Employee employee = null;
		try {
			//open a connection
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from employee where id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				employee = new Employee(id, resultSet.getString("name"));
			}
			resultSet.close();
			preparedStatement.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(connection != null) {
				try {
					connection.close();
				}
				catch(SQLException e) {
				}
			}
		}
		return employee;
	}
	
	public void createEmployee() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			System.out.println(connection);
			Statement statement = connection.createStatement();
			statement.executeUpdate("create table mysql.employee (id integer, name char(30))");
			statement.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(connection != null) {
				try {
					connection.close();
				}
				catch(SQLException e) {
					
				}
			}
		}
	}
	
	public void insertEmployee(Employee employee) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into employee values (" + employee.getId() + ",'" + employee.getName() + "')");
			statement.close();
		}
		catch(SQLException e) {
			throw new RuntimeException();
		}
		finally {
			if(connection != null) {
				try {
					connection.close();
				}
				catch(SQLException e) {
				}
			}
		}
	}
}
