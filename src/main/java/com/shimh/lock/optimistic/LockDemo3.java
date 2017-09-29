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
 *  
 * 将基于脏字段的乐观锁执行为update/deleteSQL语句的WHERE子句约束的一部分。 
 *  
 */
@Entity
@Table
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@DynamicUpdate
@SelectBeforeUpdate
public class LockDemo3 {

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


