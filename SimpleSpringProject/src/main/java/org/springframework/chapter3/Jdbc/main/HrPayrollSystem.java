package org.springframework.chapter3.Jdbc.main;

import org.springframework.chapter3.Jdbc.dao.EmployeeDao;
import org.springframework.chapter3.Jdbc.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HrPayrollSystem {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeDao employeeDao = (EmployeeDao)applicationContext.getBean("employeeDaoImpl");
		employeeDao.createEmployee();
		employeeDao.insertEmployee(new Employee(8, "Gagan"));
		Employee employee = employeeDao.getEmployeeId(8);
		System.out.println(employee);
	}
}
