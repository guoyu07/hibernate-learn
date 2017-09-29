package com.shimh.model.basicType;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.shimh.customer.SexConverter;
import com.shimh.customer.SexEnum;

@Entity
@Table
public class EnumDemo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.ORDINAL)
	private SexEnum sexOrdinal;
	
	@Enumerated(EnumType.STRING)
	private SexEnum sexString;
	
	/*
	 * @Convert不要使用 @Enumerated标注  自定义类型
	 */
	@Convert( converter = SexConverter.class )
	private SexEnum sexCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SexEnum getSexOrdinal() {
		return sexOrdinal;
	}

	public void setSexOrdinal(SexEnum sexOrdinal) {
		this.sexOrdinal = sexOrdinal;
	}

	public SexEnum getSexString() {
		return sexString;
	}

	public void setSexString(SexEnum sexString) {
		this.sexString = sexString;
	}

	public SexEnum getSexCode() {
		return sexCode;
	}

	public void setSexCode(SexEnum sexCode) {
		this.sexCode = sexCode;
	}
	
	
}
