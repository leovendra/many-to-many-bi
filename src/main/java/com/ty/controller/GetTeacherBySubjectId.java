package com.ty.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.dto.Subject;
import com.ty.dto.Teacher;

public class GetTeacherBySubjectId {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Subject Id :");
		int id = sc.nextInt();

		Subject sub = manager.find(Subject.class, id);
		if (sub != null) {
			System.out.println(sub.getId());
			System.out.println(sub.getName());
			System.out.println(sub.getDays());

			List<Teacher> tlist = sub.getTeachers();
			if (tlist != null) {
				for (Teacher t : tlist) {
					System.out.println(t.getId());
					System.out.println(t.getName());
					System.out.println(t.getAge());
					System.out.println("-------------------------");
				}
			}
		}
		sc.close();
	}

}
