package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Subject;
import com.ty.dto.Teacher;

public class TestSaveTeacherSubject {

	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Subject s1 = new Subject();
		s1.setName("CS");
		s1.setDays(20);
		
		Subject s2 = new Subject();
		s2.setName("DS");
		s2.setDays(60);
		
		List<Subject> slist = new ArrayList<Subject>();
		slist.add(s2);
		slist.add(s1);
		Teacher t1 = new Teacher();
		t1.setName("Archana");
		t1.setAge(30);
		t1.setSubjects(slist);
		
		Teacher t2 = new Teacher();
		t2.setName("Sangeeta Dey");
		t2.setAge(23);
		t2.setSubjects(slist);
		
		transaction.begin();
		
		manager.persist(t1);
		manager.persist(t2);
		manager.persist(s1);
		manager.persist(s2);
		transaction.commit();
		
	}
}
