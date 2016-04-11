package org.springframework.chapter1.main;

import org.springframework.chapter1.service.GreetingMessageService;
import org.springframework.chapter1.service.GreetingMessageServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		GreetingMessageService greetingMessageService = (GreetingMessageService)applicationContext.getBean("greetingMessageServiceImpl",GreetingMessageServiceImpl.class);
		System.out.println(greetingMessageService.greetUser());
	}
}
