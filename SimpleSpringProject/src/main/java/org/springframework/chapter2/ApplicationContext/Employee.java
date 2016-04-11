package org.springframework.chapter2.ApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Employee {
	private List<Object> list;
	private Set<Object> set;
	private Map<Object, Object> map;
	
	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public Set<Object> getSet() {
		return set;
	}

	public void setSet(Set<Object> set) {
		this.set = set;
	}

	public Map<Object, Object> getMap() {
		return map;
	}

	public void setMap(Map<Object, Object> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		String message = "";
		message += "List : ";
		for(Object listelement : list) {
			message += listelement + " \n";
		}
		System.out.println("Set : ");
		for(Object setelement : set) {
			message += setelement + " \n";
		}
		for(Map.Entry<Object, Object> entry : map.entrySet()) {
			message += entry.getKey() + " " + entry.getValue() + " \n";
		}
		return message;
	} 
}
