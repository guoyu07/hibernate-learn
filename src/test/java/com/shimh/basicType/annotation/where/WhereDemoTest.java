package com.shimh.basicType.annotation.where;

import java.util.List;

import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.model.basicType.annotation.where.Account;
import com.shimh.model.basicType.annotation.where.AccountType;
import com.shimh.model.basicType.annotation.where.Client;

public class WhereDemoTest extends BaseTest{
	
	@Test
	public void add(){
		
		Client client = new Client();
	    client.setId( 1 );
	    client.setName( "John Doe" );
	    session.save( client );

	    Account account1 = new Account( );
	    account1.setId( 1 );
	    account1.setAmount( 5000d );
	    account1.setType( AccountType.CREDIT );
	    account1.setRate( 1.25 / 100 );
	    account1.setActive( true );
	    account1.setClient( client );
	    //client.getCreditAccounts().add( account1 );
	    session.save( account1 );

	    Account account2 = new Account( );
	    account2.setId( 2 );
	    account2.setAmount( 0d );
	    account2.setType( AccountType.DEBIT );
	    account2.setRate( 1.05 / 100 );
	    account2.setActive( false );
	    account2.setClient( client );
	    //client.getDebitAccounts().add( account2 );
	    session.save( account2 );

	    Account account3 = new Account( );
	    account3.setId( 3 );
	    account3.setAmount( 250d );
	    account3.setType( AccountType.DEBIT );
	    account3.setRate( 1.05 / 100 );
	    account3.setActive( true );
	    account3.setClient( client );
	    //client.getDebitAccounts().add( account3 );
	    session.save( account3 );
	}
	
	
	
	@Test
	public void getAccount(){
		/*
		 * 只能获取 2条
		 */
		List<Account> cs = session.createQuery(" from Account ").list();
		System.out.println(cs.size());
		System.out.println(cs);
		System.out.println("-------------");
		
		//有where条件获取不到
		Account c = session.get(Account.class, 2);
		System.out.println(c);
		
	}
	
	
	@Test
	public void getClient(){
		Client c = session.get(Client.class, 1);
		System.out.println(c.getCreditAccounts());
		System.out.println(c.getDebitAccounts());
	}
	
	
}
