package com.shimh.basicType;

import java.math.BigDecimal;

import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.model.basicType.AnnotationDemo;


public class AnnotationDemoTest extends BaseTest{
	
	
	@Test
	public void add(){
		AnnotationDemo demo = new AnnotationDemo();
		demo.setTestBasic("basic");
		demo.setTestColumn("insert");
		demo.setTestColumn1("text");
		BigDecimal d = new BigDecimal("40.22");
		demo.setTestColumn2(d);
		
		session.save(demo);
	}
	
	@Test
	public void update(){
		AnnotationDemo demo = session.get(AnnotationDemo.class, 1);
		//testColumn nullable = false 不执行update操作
		demo.setTestColumn("insert1");
		demo.setTestColumn1("text1");
		session.update(demo);
		session.flush();
	}
}
