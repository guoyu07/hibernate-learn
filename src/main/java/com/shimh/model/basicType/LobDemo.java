package com.shimh.model.basicType;

import java.sql.Blob;
import java.sql.Clob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class LobDemo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Lob
	private Clob clob1; //longtext mysql
	@Lob
	private String string; //longtext mysql
	@Lob
    private char[] arrayChar; //blob mysql
	
	@Lob
	private Blob blob1; //longblob mysql
	@Lob
	private String[] arrayString; //longtext mysql
	
	@Lob
    private byte[] arrayByte; //blob mysql

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Clob getClob() {
		return clob1;
	}

	public void setClob(Clob clob) {
		this.clob1 = clob;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public char[] getArrayChar() {
		return arrayChar;
	}

	public void setArrayChar(char[] arrayChar) {
		this.arrayChar = arrayChar;
	}

	public Blob getBlob() {
		return blob1;
	}

	public void setBlob(Blob blob) {
		this.blob1 = blob;
	}

	public String[] getArrayString() {
		return arrayString;
	}

	public void setArrayString(String[] arrayString) {
		this.arrayString = arrayString;
	}

	public byte[] getArrayByte() {
		return arrayByte;
	}

	public void setArrayByte(byte[] arrayByte) {
		this.arrayByte = arrayByte;
	}
	
	
}
