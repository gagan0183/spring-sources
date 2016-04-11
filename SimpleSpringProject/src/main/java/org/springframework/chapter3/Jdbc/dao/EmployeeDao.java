package org.springframework.chapter3.Jdbc.dao;

import org.springframework.chapter3.Jdbc.model.Employee;

public interface EmployeeDao {
	Employee getEmployeeId(int id);
	void createEmployee();
	void insertEmployee(Employee employee);
}
