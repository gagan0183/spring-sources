package org.springframework.chapter2.ApplicationContext;

public class Employee1 {
	private int employeeId;
	private String employeeName;
	private String country;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Employee1 [employeeId=" + employeeId + ", employeeName=" + employeeName + ", country=" + country + "]";
	}
}
