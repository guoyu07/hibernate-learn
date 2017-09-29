package com.shimh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@Transactional
public class BaseTest{
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	protected Session session;
	
	@Before
	public void session(){
		session = sessionFactory.getCurrentSession();
	}
}
