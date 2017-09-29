package com.shimh.model.naturalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Table
@Entity
public class NaturalIdDemo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NaturalId
	private String number;
	
	@NaturalId
	private Integer number2;
	
	/*
	 * 可变的
	 */
    @NaturalId(mutable = true)
    private String numberChange;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getNumber2() {
		return number2;
	}

	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}

	public String getNumberChange() {
		return numberChange;
	}

	public void setNumberChange(String numberChange) {
		this.numberChange = numberChange;
	}

	@Override
	public String toString() {
		return "NaturalIdDemo [id=" + id + ", number=" + number + ", number2=" + number2 + ", numberChange="
				+ numberChange + "]";
	}
	
}
