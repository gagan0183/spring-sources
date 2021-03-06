package org.springframework.chapter2.ApplicationContext;

public class ATM {
	private Printer printer;

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void printBalance(String accountNumber) {
		getPrinter().printBalance(accountNumber);
	}
}
