package com.shimh.customer;

import org.hibernate.Session;
import org.hibernate.tuple.ValueGenerator;


public class UserGenerator implements ValueGenerator<String> {

	public String generateValue(Session session, Object owner) {
		return CurrentUser.INSTANCE.get();
	}

	
	/*
	 * 模拟当前登陆用户
	 */
  public static class CurrentUser {

	    public static final CurrentUser INSTANCE = new CurrentUser();

	    private static final ThreadLocal<String> storage = new ThreadLocal<String>();

	    public void logIn(String user) {
	        storage.set( user );
	    }

	    public void logOut() {
	        storage.remove();
	    }

	    public String get() {
	        return storage.get();
	    }
	} 
}
