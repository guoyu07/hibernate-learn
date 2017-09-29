package com.shimh.cache;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table
@Entity
public class CacheDemo2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	
	@ManyToOne
	private CacheDemo1 demo1;
	

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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public CacheDemo1 getDemo1() {
		return demo1;
	}

	public void setDemo1(CacheDemo1 demo1) {
		this.demo1 = demo1;
	}

	@Override
	public String toString() {
		return "CacheDemo2 [id=" + id + ", name=" + name + ", time=" + time + ", demo1=" + demo1 + "]";
	}
	
	
}
