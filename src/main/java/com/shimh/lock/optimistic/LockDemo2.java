package com.shimh.lock.optimistic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLock;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.OptimisticLockType;

/*
 *  基于所有字段执行乐观锁，作为扩展的WHERE子句约束，用于update/deleteSQL语句。
 *  
 *  
 */
@Entity
@Table
@OptimisticLocking(type = OptimisticLockType.ALL)
@DynamicUpdate	//表示update对象的时候,生成动态的update语句,如果这个字段的值是null就不会被加入到update语句中
public class LockDemo2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String need;
	
	private String noNeed;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNeed() {
		return need;
	}


	public void setNeed(String need) {
		this.need = need;
	}


	public String getNoNeed() {
		return noNeed;
	}


	public void setNoNeed(String noNeed) {
		this.noNeed = noNeed;
	}


	
}


