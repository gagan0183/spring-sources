package org.springframework.chapter3.Jdbc.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.chapter3.Jdbc.dao.EmployeeDao;
import org.springframework.chapter3.Jdbc.dao.EmployeeDaoImpl;
import org.springframework.chapter3.Jdbc.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Simulate {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeDao employeeDao = (EmployeeDao)applicationContext.getBean("employeeDaoImpl");
		//create employee table
		//employeeDao.createEmployee();
		
		//insert into employee;
		/*Employee employee = new Employee(8, "Gagan", 8);
		int insert = employeeDao.insertEmployee(employee);
		System.out.println("Insert : " + insert);
		*/
		//get employee
		/*Employee employee = employeeDao.getEmployeeById(8);
		System.out.println(employee);*/
		
		//get employee count
		/*int count = employeeDao.getEmployeeCount();
		System.out.println("Count : " + count);*/
		
		//employee
		/*int deletecount = employeeDao.deleteEmployeeById(8);
		System.out.println(deletecount);*/
		
		/*List<Employee> employees = new ArrayList<Employee>();
		Employee employee1 = new Employee(1, "Gagan", 8);
		Employee employee2 = new Employee(80, "Gagan", 8);
		employees.add(employee1);
		employees.add(employee2);		
		employeeDao.insertEmployees(employees);*/
		
		Employee employee = employeeDao.getEmployee(1);
		System.out.println(employee);
	}
}
