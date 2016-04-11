package com.spring.student;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AccessInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar calendar = Calendar.getInstance();
		int e = calendar.get(Calendar.DAY_OF_WEEK);
		if(e == Calendar.SUNDAY) {
			response.getWriter().write("The website is closed on Sunday. Please excess the website on weekdays");
			return false;
		}
		return true;		
	}
}
