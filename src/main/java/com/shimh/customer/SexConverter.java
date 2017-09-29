package com.shimh.customer;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SexConverter implements AttributeConverter<SexEnum, String>{

	public String convertToDatabaseColumn(SexEnum attribute) {
		if ( attribute == null ) {
            return null;
        }

        return attribute.getCode();
	}

	public SexEnum convertToEntityAttribute(String dbData) {
		 if ( dbData == null ) {
	            return null;
	        }

	     return SexEnum.fromCode( dbData );
	}
        
}
