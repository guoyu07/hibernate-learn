package com.shimh.model.basicType;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.shimh.customer.CollectionToStringType;

/**
 * *****************************************************************
 * Created on 2017年9月26日 下午4:32:55
 * @author shimh
 * 功能说明： ------ empty log ------
 *
 *	jpa 的属性转换也可以  @EnumDemo
 *
 */
@TypeDef(
        name = "ListToStringType",
        typeClass = CollectionToStringType.class,
        parameters = {
                @Parameter(name = "separator", value = ","),
                @Parameter(name = "collectionType", value = "java.util.ArrayList"),
                @Parameter(name = "elementType", value = "java.lang.String")
        }
)
@Entity
@Table
public class CustomTypeDemo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Type(type = "string")
	private String testType;
	
	@Type(type = "ListToStringType")
	private List<String> testCustomType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public List<String> getTestCustomType() {
		return testCustomType;
	}

	public void setTestCustomType(List<String> testCustomType) {
		this.testCustomType = testCustomType;
	}
	
}
