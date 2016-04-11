package org.springframework.chapter2.ApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PayrollSystem {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeService employeeService = (EmployeeService)applicationContext.getBean("empServiceBean");
		System.out.println("Employee id is : " + employeeService.generateEmployeeId());
		
		Employee employee = (Employee)applicationContext.getBean("employee");
		System.out.println("Employee : " + employee);
		
		ATM atm = (ATM)applicationContext.getBean("atmBean");
		atm.printBalance("88");
		
		/*Employee1 employee1 = (Employee1)applicationContext.getBean("parentEmployee");
		System.out.println("Parent bean : \n" + employee1);*/
		
		Employee1 childEmployee = (Employee1)applicationContext.getBean("employeeBean1");
		System.out.println("Child bean : \n" + childEmployee);
		
		EmployeeService1 employeeServiceBean1 = (EmployeeServiceImpl1)applicationContext.getBean("employeeServiceBean1");
		employeeServiceBean1.setMessage("bean 1");
		System.out.println("employeeServiceBean1 : " + employeeServiceBean1.getMessage());
		
		EmployeeService1 employeeServiceBean2 = (EmployeeServiceImpl1)applicationContext.getBean("employeeServiceBean1");
		System.out.println("employeeServiceBean2 : " + employeeServiceBean2.getMessage());
		
		EmployeeService2 employeeService2 = (EmployeeServiceImpl2)applicationContext.getBean("employeeServiceBean2");
		System.out.println("employeeServiceBeanInitializingBean : " + employeeService2.generateEmployeeId());
		applicationContext.close();
		
	}
}
