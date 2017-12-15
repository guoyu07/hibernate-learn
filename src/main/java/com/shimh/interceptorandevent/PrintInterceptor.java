package com.shimh.interceptorandevent;

import java.io.Serializable;
import java.util.Arrays;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class PrintInterceptor extends EmptyInterceptor{

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		System.out.println("onFlushDirty...");
		
		System.out.println(Arrays.toString(currentState));
		System.out.println(Arrays.toString(previousState));
		
		System.out.println(Arrays.toString(propertyNames));
		
		return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
	}

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		System.out.println("onLoad...");

		
		
		return super.onLoad(entity, id, state, propertyNames, types);
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		System.out.println("onSave...");

		
		
		
		return super.onSave(entity, id, state, propertyNames, types);
	}
	
}
