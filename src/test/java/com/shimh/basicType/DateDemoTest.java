package com.shimh.basicType;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Hibernate;
import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.customer.SexEnum;
import com.shimh.model.basicType.DateDemo;
import com.shimh.model.basicType.EnumDemo;
import com.shimh.model.basicType.LobDemo;


public class DateDemoTest extends BaseTest{
	
	@Test
	public void add() throws Exception{
		Date date = new Date();
		Calendar d = Calendar.getInstance();
		LocalDateTime l = LocalDateTime.now();
		
		DateDemo demo = new DateDemo();
		demo.setDate(date);
		demo.setTime(date);
		demo.setTimeStamp(date);
		demo.setCalendar(d);
		demo.setLocalDateTime(l);
		
		session.save(demo);
	}
	
	@Test
	public void get() throws Exception{
		
	}
}

