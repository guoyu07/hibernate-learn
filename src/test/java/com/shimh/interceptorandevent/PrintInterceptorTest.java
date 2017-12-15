package com.shimh.interceptorandevent;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.lock.optimistic.LockDemo1;

public class PrintInterceptorTest extends BaseTest{

	
	@Test
	public void add() throws Exception{

		Session s = sessionFactory.withOptions().interceptor(new PrintInterceptor()).openSession();
		
		City c = new City();
		
		c.setName("cn");
		c.setPersons(1500);
		c.setLocation("east");
		
		s.save(c);
	}

	@Test
	public void update() throws Exception{

		Session s = sessionFactory.withOptions().interceptor(new PrintInterceptor()).openSession();
		
		Transaction t = s.beginTransaction();
		City c = s.get(City.class, 1);
		
		c.setName("cn22");
		c.setPersons(150011);
		c.setLocation("east22");
		
		s.update(c);
		
		t.commit();
	}
}
