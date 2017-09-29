package com.shimh.model.basicType.annotation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table
public class FormulaDemo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double credit;

    private Double rate;
    /*
     * @Formula 只读，类似虚拟列，读取时自动计算；SQL编写，所以移植性不好
     */
    @Formula(value = "credit * rate")
    private Double interest;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Double getInterest() {
		return interest;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
    
    
}
