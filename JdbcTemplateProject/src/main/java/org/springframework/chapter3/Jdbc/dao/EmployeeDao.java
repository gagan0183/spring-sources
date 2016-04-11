package org.springframework.chapter3.Jdbc.dao;

import java.util.List;

import org.springframework.chapter3.Jdbc.model.Employee;

public interface EmployeeDao {
	void createEmployee();
	int getEmployeeCount();
	int insertEmployee(Employee employee);
	int deleteEmployeeById(int id);
	Employee getEmployeeById(int id);
	void insertEmployees(final List<Employee> employees);
	Employee getEmployee(Integer id);
}
