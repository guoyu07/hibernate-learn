package com.shimh.model.embeddedableType.simple;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Publisher {

    @Column(name = "publisher_name")
    private String name;

    @Column(name = "publisher_country")
    private String country;

    public Publisher(String name, String country) {
        this.name = name;
        this.country = country;
    }

    private Publisher() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Publisher [name=" + name + ", country=" + country + "]";
	}
    
}