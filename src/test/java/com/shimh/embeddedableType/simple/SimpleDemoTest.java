package com.shimh.embeddedableType.simple;

import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.model.embeddedableType.simple.Book;
import com.shimh.model.embeddedableType.simple.Publisher;

public class SimpleDemoTest extends BaseTest{
	
	
	@Test
	public void add() throws Exception{
		Book book = new Book();
		Publisher p = new Publisher("cc","China");
		book.setAuthor("shimh");
		book.setTitle("superman");
		book.setPublisher(p);
		
		session.save(book);
	}
	
	@Test
	public void get() throws Exception{
		Book book = session.get(Book.class,1);
		System.out.println(book.getPublisher());
	}
}
