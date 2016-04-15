package com.javabrains.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javabrains.hibernate.dto.Address;
import com.javabrains.hibernate.dto.FourWheeler;
import com.javabrains.hibernate.dto.TwoWheeler;
import com.javabrains.hibernate.dto.UserDetails;
import com.javabrains.hibernate.dto.Vehicle;

public class HibernateTest {
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler motorcycle = new TwoWheeler();
		motorcycle.setVehicleName("motorcycle");
		motorcycle.setSteeringHandle("motorcycle steering handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("bmw");
		car.setSteeringWheel("bmw steering wheel");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(vehicle);
		session.save(motorcycle);
		session.save(car);
		session.getTransaction().commit();
		session.close();
	}
}
