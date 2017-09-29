package com.shimh.customer;

public enum SexEnum {
	Man("0"),Women("1");
	
	private String code;
	
	
	SexEnum(String code){
		this.code = code;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public static SexEnum fromCode(String code) {
		
		if(null == code)
			return null;
		
		if ("0".equalsIgnoreCase(code) ) {
            return Man;
        }
        if ("1".equalsIgnoreCase(code)) {
            return Women;
        }
        
        throw new UnsupportedOperationException(
            "SexEnum: The code " + code + " is not supported!"
        );
	}
	
}
