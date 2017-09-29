package com.shimh.model.inheritance.joinedTable;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="joinedDebitAccount")
//@PrimaryKeyJoinColumn(name = "account_id") 默认是父类的id，用这个可以自定义
public class DebitAccount extends Account {

    private BigDecimal overdraftFee;

    public BigDecimal getOverdraftFee() {
        return overdraftFee;
    }

    public void setOverdraftFee(BigDecimal overdraftFee) {
        this.overdraftFee = overdraftFee;
    }

	@Override
	public String toString() {
		return "DebitAccount [overdraftFee=" + overdraftFee + ", getId()=" + getId() + ", getOwner()=" + getOwner()
				+ ", getBalance()=" + getBalance() + ", getInterestRate()=" + getInterestRate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    
}
