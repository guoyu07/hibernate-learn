package com.shimh.model.basicType.annotation.where;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

//@Entity
//@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    
    /*
     * filter collection use @where   @WhereJoinTable用于manytomany 看官方文档
     */
    @Where( clause = "account_type = 'DEBIT'")
    @OneToMany(mappedBy = "client")
    private List<Account> debitAccounts = new ArrayList<Account>( );

    @Where( clause = "account_type = 'CREDIT'")
    @OneToMany(mappedBy = "client")
    private List<Account> creditAccounts = new ArrayList<Account>( );

    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getDebitAccounts() {
		return debitAccounts;
	}

	public void setDebitAccounts(List<Account> debitAccounts) {
		this.debitAccounts = debitAccounts;
	}

	public List<Account> getCreditAccounts() {
		return creditAccounts;
	}

	public void setCreditAccounts(List<Account> creditAccounts) {
		this.creditAccounts = creditAccounts;
	}

}
