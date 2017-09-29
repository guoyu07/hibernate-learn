package com.shimh.model.inheritance.signalTable;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table
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
