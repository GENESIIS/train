package com.genesiis.hra.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum BasisEnum {

	PERMANENT("Permanent"), 
	CONTRACT("Contract"),
	TRAINEE("Trainee");

	private String key;

	BasisEnum(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	//get seleted enum
	public List<String> getBasisenum() {

		List<String> list = new ArrayList<String>();
		try {
			List<BasisEnum> somethingList = Arrays.asList(BasisEnum.values());

			for (BasisEnum dd : somethingList) {
				list.add(dd.getKey());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
