package com.shimh.basicType;



import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.customer.SexEnum;
import com.shimh.model.basicType.EnumDemo;


public class EnumDemoTest extends BaseTest{
	
	@Test
	public void add(){
		
		EnumDemo demo = new EnumDemo();
		demo.setSexCode(SexEnum.Man);
		demo.setSexOrdinal(SexEnum.Women);
		demo.setSexString(SexEnum.Man);
		session.save(demo);
		
		EnumDemo demo2 = new EnumDemo();
		demo2.setSexCode(null);
		demo2.setSexOrdinal(null);
		demo2.setSexString(null);
		session.save(demo2);
	}
	
	@Test
	public void get(){
		EnumDemo demo =  session.get(EnumDemo.class, 1);
		
		System.out.println(demo);
	}
}

