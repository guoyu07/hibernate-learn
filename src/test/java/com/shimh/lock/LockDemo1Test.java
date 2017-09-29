package com.shimh.lock;

import org.hibernate.Session;
import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.lock.optimistic.LockDemo1;

public class LockDemo1Test extends BaseTest{
	
	@Test
	public void add() throws Exception{
		LockDemo1 demo = new LockDemo1();
		demo.setNeed("1");
		demo.setCallCount(1);
		session.save(demo);
	}
	
	@Test
	public void versionNoChange() throws Exception{
		LockDemo1 demo = session.get(LockDemo1.class,1);
		demo.incrementCallCount();
		session.flush();
	}
	@Test
	public void versionChange() throws Exception{
		LockDemo1 demo = session.get(LockDemo1.class,1);
		demo.setNeed("2");
		session.flush();
	}
	
	@Test
	public void lockOk() throws Exception{
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		LockDemo1 demoUpdate = session2.get(LockDemo1.class,1);
		demoUpdate.setNeed("3");
		
		LockDemo1 demo = session.get(LockDemo1.class,1);
		demo.incrementCallCount();
		session.flush();
		session2.flush();
	}
	
	@Test
	public void lockNotOk() throws Exception{
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		LockDemo1 demoUpdate = session2.get(LockDemo1.class,1);
		demoUpdate.setNeed("4");
		/*
		 * 抛错
		 */
		LockDemo1 demo = session.get(LockDemo1.class,1);
		demo.setNeed("5");
		session.flush();
		session2.flush();
	}
}
