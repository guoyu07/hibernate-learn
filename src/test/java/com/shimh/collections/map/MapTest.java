package com.shimh.collections.map;

import java.util.Date;

import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.model.collections.map.Mobile;
import com.shimh.model.collections.map.Person;

public class MapTest extends BaseTest{
	

	@Test
	public void add() throws Exception{
		Person p = new Person();
		p.setName("小明");
		p.getHobbies().put(2, "打篮球");
		p.getHobbies().put(3, "打游戏");
		
		p.getHobbies2().put(new Date(), "睡觉");
		
		Mobile m = new Mobile();
		m.setName("魅族");
		p.getMobiles().put("魅族1", m);
		
		Mobile m2 = new Mobile();
		m2.setName("魅族2");
		
		p.getMobiles2().put(m2, "魅族22");
		
		
		session.save(p);
		session.flush();
	}
	@Test
	public void get() throws Exception{
		Person p = session.get(Person.class, 4);
		System.out.println(p);
	}
	
	@Test
	public void deletePhone() throws Exception{


	}
	
	@Test
	public void deletePhones() throws Exception{


	}
	
	
	
	
	
}
