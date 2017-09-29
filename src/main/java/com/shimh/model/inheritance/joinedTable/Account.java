package com.shimh.model.inheritance.joinedTable;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;


/*
 * 每个子类也可以被映射到自己的表,父类有自己的表，共有属性存在父类表中
 * 
 * 多态查询时，使用表连接，获取大量实体时影响性能。
 */

@Entity
@Table(name = "joinedAccount")
@Inheritance(strategy = InheritanceType.JOINED)
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
