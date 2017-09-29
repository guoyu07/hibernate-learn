package com.shimh.model.basicType;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class AnnotationDemo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//@Basic是默认的 fetch：属性懒加载，Hibernate不管；optional:是否为空
	@Basic(fetch = FetchType.LAZY,optional = false) 
	private String testBasic;
	
	@Column(name = "testColumn",length = 10, updatable = false, nullable = true)
	private String testColumn;
	
	@Column(name = "testColumn1",columnDefinition="text NOT NULL")
	private String testColumn1;
	
	
	@Column(name="testColumn2", updatable=true, precision=6, scale=2)
	private BigDecimal testColumn2;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTestBasic() {
		return testBasic;
	}


	public void setTestBasic(String testBasic) {
		this.testBasic = testBasic;
	}


	public String getTestColumn() {
		return testColumn;
	}


	public void setTestColumn(String testColumn) {
		this.testColumn = testColumn;
	}


	public String getTestColumn1() {
		return testColumn1;
	}


	public void setTestColumn1(String testColumn1) {
		this.testColumn1 = testColumn1;
	}


	public BigDecimal getTestColumn2() {
		return testColumn2;
	}


	public void setTestColumn2(BigDecimal testColumn2) {
		this.testColumn2 = testColumn2;
	}
	
	
	
	
}
