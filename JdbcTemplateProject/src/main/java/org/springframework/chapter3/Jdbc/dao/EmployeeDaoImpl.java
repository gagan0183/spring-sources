package org.springframework.chapter3.Jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.chapter3.Jdbc.model.Employee;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SimpleJdbcCall jdbcCall;

	public void createEmployee() {
		String createQuery = "create table employee (EmpId INTEGER, Name VARCHAR(80), Age INTEGER)";
		jdbcTemplate.execute(createQuery);
	}

	public int getEmployeeCount() {
		String sql = "select count(*) from employee";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int insertEmployee(Employee employee) {
		String insertQuery = "insert into employee (EmpId, Name, Age) values (?, ?, ?)";
		Object[] params = {employee.getEmpId(), employee.getName(), employee.getAge()};
		int[] types = {Types.INTEGER, Types.VARCHAR, Types.INTEGER};
		return jdbcTemplate.update(insertQuery, params, types);
	}

	public int deleteEmployeeById(int id) {
		String deleteQuery = "delete from employee where empId = ?";
		return jdbcTemplate.update(deleteQuery, new Object[] {id}, new int[]{Types.INTEGER});
	}

	public Employee getEmployeeById(int id) {
		String query = "select * from employee where empId = ?";
		Employee employee = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println("in maprow");
				Employee employee = new Employee(rs.getInt("EmpId"), rs.getString("Name"), rs.getInt("Age"));
				return employee;
			}
			
		});
		return employee;
	}

	public void insertEmployees(final List<Employee> employees) {
		jdbcTemplate.batchUpdate("insert into employee (empId, name, age) values (?, ?, ?)", new BatchPreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Employee employee = employees.get(i);
				ps.setInt(1, employee.getEmpId());
				ps.setString(2, employee.getName());
				ps.setInt(3, employee.getAge());
			}
			
			public int getBatchSize() {
				return employees.size();
			}
		});
	}
	
	public Employee getEmployee(Integer id) {
		System.out.println(jdbcCall);
		this.jdbcCall = this.jdbcCall.withProcedureName("getEmployee");
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("id", id);
		Map<String, Object> map = this.jdbcCall.execute(sqlParameterSource);
		System.out.println((String)map.get("Name"));
		Employee employee = new Employee(id, (String)map.get("name"), (Integer)map.get("age"));
		return employee;
	}
}
