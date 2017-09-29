package com.shimh.model.inheritance.perClassTable;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="perCreditAccount")
//@PrimaryKeyJoinColumn(name = "account_id") 默认是父类的id，用这个可以自定义
public class CreditAccount extends Account {

    private BigDecimal creditLimit;

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

	@Override
	public String toString() {
		return "CreditAccount [creditLimit=" + creditLimit + ", getId()=" + getId() + ", getOwner()=" + getOwner()
				+ ", getBalance()=" + getBalance() + ", getInterestRate()=" + getInterestRate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    
}
