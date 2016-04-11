package org.springframework.chapter2.ApplicationContext;

public class EmployeeServiceImpl1 implements EmployeeService1 {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
