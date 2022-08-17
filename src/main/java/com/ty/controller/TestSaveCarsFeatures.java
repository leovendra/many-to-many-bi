package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Car;
import com.ty.dto.Feature;

public class TestSaveCarsFeatures {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Car c = new Car();
		c.setName("BMW");
		c.setCost(70000000);
		
		List<Car> li = new ArrayList<Car>();
		li.add(c);
		
//		Car car = new Car();
//		car.setName("Honda City");
//		car.setCost(1200000);
		
		Feature f1 = new Feature();
		f1.setName("AC");
		f1.setComfortLevel(9);
		f1.setCars(li);
		
		Feature f2 = new Feature();
		f2.setName("RoofTop");
		f2.setComfortLevel(5);
		f2.setCars(li);
		
		Feature f3 = new Feature();
		f3.setName("BulletProof");
		f3.setComfortLevel(10);
		f3.setCars(li);
		
		
		transaction.begin();
		
		manager.persist(f2);
		manager.persist(f1);
		manager.persist(c);
		manager.persist(f3);
		transaction.commit();
	}

}
