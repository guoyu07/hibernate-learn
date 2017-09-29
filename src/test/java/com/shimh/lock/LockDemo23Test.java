package com.shimh.lock;

import org.hibernate.Session;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.lock.optimistic.LockDemo1;
import com.shimh.lock.optimistic.LockDemo2;
import com.shimh.lock.optimistic.LockDemo3;

public class LockDemo23Test extends BaseTest{
	
	@Test
	public void add() throws Exception{
		LockDemo2 demo2 = new LockDemo2();
		demo2.setNeed("1");
		demo2.setNoNeed("1");
		
		LockDemo3 demo3 = new LockDemo3();
		demo3.setNeed("1");
		demo3.setNoNeed("1");
		
		session.save(demo2);
		session.save(demo3);
	}
	
	/*
	 * 测试@DynamicUpdate  只更新修改的字段
	 *   @OptimisticLocking(type = OptimisticLockType.ALL) 将所有字段用于where
	 *   
	 * Hibernate: 
	    update
	        LockDemo2 
	    set
	        need=?   只有need字段
	    where
	        id=? 
	        and need=? 
	        and noNeed=?
	 */
	@Test
	public void dynamicUpdateTest() throws Exception{
		LockDemo2 demo2 = session.get(LockDemo2.class,1);
		
		demo2.setNeed("2");
		
		session.flush();
	}
	/*
	 * @OptimisticLocking(type = OptimisticLockType.DIRTY) 修改谁将谁用于where
	 * 
	 * Hibernate: 
	    update
	        LockDemo3 
	    set
	        need=? 
	    where
	        id=? 
	        and need=?
	 */
	@Test
	public void dynamicUpdateTest2() throws Exception{
		LockDemo3 demo3 = session.get(LockDemo3.class,1);
		demo3.setNeed("2");
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
