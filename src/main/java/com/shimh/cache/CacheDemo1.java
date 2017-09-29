package com.shimh.cache;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import org.hibernate.annotations.Cache;

@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table
@Entity
public class CacheDemo1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	@OneToMany(mappedBy = "demo1",fetch = FetchType.LAZY)
	private List<CacheDemo2> demo2s = new ArrayList<CacheDemo2>();
	

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

	public List<CacheDemo2> getDemo2s() {
		return demo2s;
	}

	public void setDemo2s(List<CacheDemo2> demo2s) {
		this.demo2s = demo2s;
	}

	@Override
	public String toString() {
		return "CacheDemo1 [id=" + id + ", name=" + name + ", time=" + time + "]";
	}
	
}
