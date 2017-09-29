package com.shimh.basicType;

import java.util.Arrays;
import java.util.List;


import org.hibernate.Session;
import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.model.basicType.CustomTypeDemo;




public class CustomTypeDemoTest extends BaseTest{
	
	@Test
	public void addCustomerType(){
		CustomTypeDemo demo = new CustomTypeDemo();
		
		demo.setTestType("list");
		List<String> ss = Arrays.asList("a","b","c");
		demo.setTestCustomType(ss);
		Session session = sessionFactory.getCurrentSession();
		session.save(demo);
	}
	
	@Test
	public void getCustomerType(){
		Session session = sessionFactory.getCurrentSession();
		
		CustomTypeDemo demo = session.get(CustomTypeDemo.class, 1);
		
		System.out.println(demo.getTestCustomType());
	}
}
