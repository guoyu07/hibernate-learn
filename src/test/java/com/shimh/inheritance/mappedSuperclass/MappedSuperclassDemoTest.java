package com.shimh.inheritance.mappedSuperclass;

import java.math.BigDecimal;

import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.model.inheritance.mappedSuperclass.CreditAccount;
import com.shimh.model.inheritance.mappedSuperclass.DebitAccount;

public class MappedSuperclassDemoTest extends BaseTest{
	
	@Test
	public void add(){
		BigDecimal bd = new BigDecimal("2.5");
		CreditAccount c = new CreditAccount();
		c.setOwner("c");
		c.setCreditLimit(bd);
		
		DebitAccount d = new DebitAccount();
		d.setOwner("d");
		d.setOverdraftFee(bd);
		
		session.save(c);
		session.save(d);
	}
	
	@Test
	public void get(){
		CreditAccount c = session.get(CreditAccount.class, 1);
		System.out.println(c);
		
		DebitAccount d = session.get(DebitAccount.class, 1);
		System.out.println(d);
		
	}
}
