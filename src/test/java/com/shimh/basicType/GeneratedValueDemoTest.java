package com.shimh.basicType;

import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.customer.UserGenerator.CurrentUser;
import com.shimh.model.basicType.GeneratedValueDemo;

public class GeneratedValueDemoTest extends BaseTest{
	
	@Test
	public void add() throws Exception{
		
		GeneratedValueDemo demo = new GeneratedValueDemo();
		
		demo.setFirstName("first");
		demo.setSecondName("second");
		
		CurrentUser.INSTANCE.logIn("shimh");
		
		session.save(demo);
	}
	
	/*
	 * updateOn时间变化
	 */
	@Test
	public void update(){
		GeneratedValueDemo demo = session.get(GeneratedValueDemo.class, 1);
		demo.setFirstName("first2");
		session.update(demo);
		session.flush();
	}
}
