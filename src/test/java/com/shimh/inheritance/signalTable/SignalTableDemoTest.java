package com.shimh.inheritance.signalTable;


import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.model.inheritance.signalTable.Account;
import com.shimh.model.inheritance.signalTable.CreditAccount;
import com.shimh.model.inheritance.signalTable.DebitAccount;

public class SignalTableDemoTest extends BaseTest{
	
	@Test
	public void add(){
		
		DebitAccount debitAccount = new DebitAccount();
		debitAccount.setOwner( "John Doe" );
		debitAccount.setBalance( BigDecimal.valueOf( 100 ) );
		debitAccount.setInterestRate( BigDecimal.valueOf( 1.5d ) );
		debitAccount.setOverdraftFee( BigDecimal.valueOf( 25 ) );

		CreditAccount creditAccount = new CreditAccount();
		creditAccount.setOwner( "John Doe" );
		creditAccount.setBalance( BigDecimal.valueOf( 1000 ) );
		creditAccount.setInterestRate( BigDecimal.valueOf( 1.9d ) );
		creditAccount.setCreditLimit( BigDecimal.valueOf( 5000 ) );
		
		Account account = new Account();
		account.setOwner( "John Doe" );
		account.setBalance( BigDecimal.valueOf( 1000 ) );
		account.setInterestRate( BigDecimal.valueOf( 1.9d ) );
		
		session.save(account);
		session.save(debitAccount);
		
		session.save(creditAccount);
	}
	
	@Test
	public void get(){
		
		DebitAccount d = session.get(DebitAccount.class, 1);
		System.out.println(d);
		
		List<DebitAccount> as = session.createQuery("from DebitAccount").list();
		System.out.println(as);
		
		List<Account> ass = session.createQuery("from Account").list();
		System.out.println(ass.size());
		
		
		
	}
}