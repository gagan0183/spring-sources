package org.springframework.chapter2.ApplicationContext;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class EmployeeServiceImpl2 implements EmployeeService2,InitializingBean,DisposableBean {
	
	public Long generateEmployeeId() {
		return System.currentTimeMillis();
	}
	
	public void afterPropertiesSet() throws Exception {
		System.out.println("after properties set");
	}
	
	public void myInit() {
		System.out.println("my init method");
	}
	
	public void destroy() {
		System.out.println("destroy method");
	}
	
	public void dest() {
		System.out.println("in dest method");
	}
}
