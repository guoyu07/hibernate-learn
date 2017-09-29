package com.shimh.basicType.annotation;


import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.model.basicType.annotation.FormulaDemo;


public class FormulaDemoTest extends BaseTest{
	
	@Test
	public void add() throws Exception{
		FormulaDemo demo = new FormulaDemo();
		demo.setCredit(2.5);
		demo.setRate(0.4);
        session.save(demo);
	}
	
	@Test
	public void get() throws Exception{
		FormulaDemo demo = session.get(FormulaDemo.class, 1);
		System.out.println(demo.getInterest());
	}
}

