package com.shimh.model.inheritance.signalTable;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;


/*
 * 单表继承策略将所有子类和父类映射到只有一个数据库表。
 * 每个子类声明自己的持久性能。版本和id属性假定是从根类继承的。
 */

//@Entity
//@Table(name = "signalTalbeAccount")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
