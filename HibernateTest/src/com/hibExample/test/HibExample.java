package com.hibExample.test;

import javax.security.auth.login.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibExample {
	public static void main(String[] args){
		
		//SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(TestHib.class).buildSessionFactory();
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		TestHib e1=new TestHib(1,"Employee1");
		TestHib e2=new TestHib(2,"Employee3");
		session.save(e1);
		session.save(e2);
		session.getTransaction().commit();
		
		session.close();
		
		//SessionFactory sf1=new AnnotationConfiguration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session1=sf.openSession();
		session1.beginTransaction();
		Employee em1=new Employee(1,"Harry","Potter","California");
		Employee em2=new Employee(2,"Kerry","Swan","Pittsburg");
		Employee em3=new Employee(3,"Larry","Dwason","North Dakota");
		Employee em4=new Employee(4,"Mike","Hisenberg","Minnesota");
		
		session1.save(em1);
		session1.save(em2);
		session1.save(em3);
		session1.save(em4);
		session1.getTransaction().commit();
		session1.close();
		
	}

}
