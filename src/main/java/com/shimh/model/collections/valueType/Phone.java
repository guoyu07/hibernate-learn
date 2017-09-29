package com.shimh.model.collections.valueType;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Table
@Entity
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @ElementCollection
    @OrderColumn(name = "order_id")
    private List<String> phones = new ArrayList<String>();
    
    
    @ElementCollection
    private List<PhoneNumber> numbers = new ArrayList<PhoneNumber>();
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public List<PhoneNumber> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<PhoneNumber> numbers) {
		this.numbers = numbers;
	}

    
}
