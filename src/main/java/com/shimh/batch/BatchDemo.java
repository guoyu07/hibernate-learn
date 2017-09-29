package com.shimh.batch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * 批量提交  全局参数：hibernate.jdbc.batch_size = 20 
 * Hibernate5 也可以用session配置
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) Hibernate会禁用批处理
 */
@Table
@Entity
public class BatchDemo {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
