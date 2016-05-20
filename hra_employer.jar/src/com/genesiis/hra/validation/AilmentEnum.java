package com.genesiis.hra.validation;

/**
 * Load ailment (deseases) to  the Medical history form
 * @author
 * **/
public enum AilmentEnum {

	OTHERSURGERY("Other Surgery"), 
	CARDIACSURGERY("Cardiac Surgery"), 
	ORTHOPAEDICSURGERY("Orthopaedic Surgery"); 

	
	private String key;

	AilmentEnum(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	

}
