package com.shimh.model.basicType.annotation.filter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Where;

@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    
    /*
     * filter collection use @filter   @WhereJoinTable用于manytomany 看官方文档
     */
    @Filter(name="activeAccount", condition="active = :active")
    @OneToMany(mappedBy = "client")
    private List<Account> debitAccounts = new ArrayList<Account>( );

    
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


}
