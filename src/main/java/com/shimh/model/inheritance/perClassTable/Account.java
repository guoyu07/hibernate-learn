package com.shimh.model.inheritance.perClassTable;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;


/*
 * 每个子类也可以被映射到自己的表,父类有自己的表，属性都在自己表中
 * 
 * 不能使用GenerationType.IDENTITY主键生成策略
 * 
 * 多态查询时，采用union操作，影响性能
 */

@Entity
@Table(name = "perAccount")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
