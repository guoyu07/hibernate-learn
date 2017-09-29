package com.shimh.naturalId;

import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.model.Student;
import com.shimh.model.naturalId.NaturalIdDemo;

public class NaturalIdDemoTest extends BaseTest{
	
	@Test
	public void add() throws Exception{
		
		NaturalIdDemo demo = new NaturalIdDemo();
		demo.setNumber("1");
		demo.setNumber2(1);
		demo.setNumberChange("1");
		session.save(demo);
	}
	
	@Test
	public void apiTest() throws Exception{
		/*
		 * 定义几个NaturalId 需要写几个using 否则报错
		 */
		NaturalIdDemo demo = session.byNaturalId(NaturalIdDemo.class)
									.using("number", "1")
									.using("number2", 1)
									.using("numberChange", "1")
									.load();
		System.out.println(demo);
		
	}
	@Test
	public void simpleNaturalIdTest() throws Exception{
		/*
		 * 如果定义了一个简单类型的NaturalId，可以用此方法获取，如不是报错
		 */
		NaturalIdDemo demo = session.bySimpleNaturalId(NaturalIdDemo.class)
									.load("1");
		
		System.out.println(demo);
		
	}
	@Test
	public void noNaturalIdTest() throws Exception{
		/*
		 * Student 没有NaturalId  会抛错
		 */
		Student demo = session.byNaturalId(Student.class)
									.load();
		
		System.out.println(demo);
	}
	
	@Test
	public void changeNaturalIdTest() throws Exception{
		NaturalIdDemo demo = session.byNaturalId(NaturalIdDemo.class)
				.using("number", "1")
				.using("number2", 1)
				.using("numberChange", "1")
				.load();
		demo.setNumberChange("2");
		
		System.out.println(demo);
		System.out.println("-----------------");
		/*
		 * 为null
		 */
		NaturalIdDemo demo2 = session.byNaturalId(NaturalIdDemo.class)
				.using("number", "1")
				.using("number2", 1)
				.using("numberChange", "2")
				.load();
		System.out.println(demo2);
		System.out.println("-----------------");
		
		/*
		 * NaturalIdDemo [id=1, number=1, number2=1, numberChange=2] 但此时未存入数据库
		 */
		NaturalIdDemo demo3 = session.byNaturalId(NaturalIdDemo.class)
				.using("number", "1")
				.using("number2", 1)
				.using("numberChange", "2")
				.setSynchronizationEnabled(true)
				.load();
		System.out.println(demo3);
		System.out.println("-----------------");
		
		//不可变
		//demo.setNumber("2");
		
		session.flush();
		
	}
}
