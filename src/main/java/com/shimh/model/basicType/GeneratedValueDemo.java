package com.shimh.model.basicType;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.UpdateTimestamp;

import com.shimh.customer.UserGenerator;

@Entity
@Table
public class GeneratedValueDemo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String firstName;
	
	private String secondName;
	
	/*
	 * insert 或 update 时 根据first 和 second 生成 firstAndSecond 不管用
	 */
	/*@Generated( value = GenerationTime.ALWAYS )
    @Column(columnDefinition =
        "AS CONCAT(" +
        "    COALESCE(firstName, ''), " +
        "    COALESCE(' ' + secondName, '')  " +
        ")")
	private String firstAndSecondName;*/
	
	/*
	 * 自定义生成策略
	 */
	@GeneratorType( type = UserGenerator.class, when = GenerationTime.INSERT)
	private String customGeneratedValue;
	
	/*
	 * insert 自动生成时间
	 */
    @CreationTimestamp
    private Date insertOn;
	
    /*
     * update 自动更新时间
     */
    @UpdateTimestamp
    private Date updatedOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

/*	public String getFirstAndSecondName() {
		return firstAndSecondName;
	}

	public void setFirstAndSecondName(String firstAndSecondName) {
		this.firstAndSecondName = firstAndSecondName;
	}*/

	public String getCustomGeneratedValue() {
		return customGeneratedValue;
	}

	public void setCustomGeneratedValue(String customGeneratedValue) {
		this.customGeneratedValue = customGeneratedValue;
	}

	public Date getInsertOn() {
		return insertOn;
	}

	public void setInsertOn(Date insertOn) {
		this.insertOn = insertOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
    
    
    
}

