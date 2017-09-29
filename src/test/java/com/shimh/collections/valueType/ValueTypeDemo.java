package com.shimh.collections.valueType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.model.collections.valueType.Phone;
import com.shimh.model.collections.valueType.PhoneNumber;

public class ValueTypeDemo  extends BaseTest{
	
	
	@Test
	public void add() throws Exception{
		Phone p = new Phone();
		List<String> phones = new ArrayList<String>();
		p.getPhones().add("111");
		p.getPhones().add("222");
		p.getPhones().add("333");
		PhoneNumber n = new PhoneNumber();
		n.setName("移动");
		n.setPhoneNumber("135");
		p.getNumbers().add(n);
		session.save(p);
		session.flush();
	}
	@Test
	public void get() throws Exception{
		Phone p = session.get(Phone.class,1);
		System.out.println(p.getPhones());
	}
	
	@Test
	public void deletePhone() throws Exception{
		Phone p = session.get(Phone.class,1);
		p.getPhones().remove(0);
		session.flush();
	}
	
	@Test
	public void deletePhones() throws Exception{
		Phone p = session.get(Phone.class,1);
		session.delete(p);
		session.flush();
	}
	
}
