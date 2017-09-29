package com.shimh.model.inheritance.mappedSuperclass;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/*
 * 共享属性，没有别的  每个子类一张表   Account没有表
 */
//@MappedSuperclass
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String owner;

    private BigDecimal balance;

    private BigDecimal interestRate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
