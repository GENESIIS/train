package com.genesiis.hra.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.genesiis.hra.model.MedicalHistory;

/**
 * Load ailment (deseases) to the Medical history form
 * 
 * @author @tr - thumeera
 * **/
public enum AilmentEnum {

	OTHERSURGERY("Other Surgery"), CARDIACSURGERY("Cardiac Surgery"),
	ORTHOPAEDICSURGERY( "Orthopaedic Surgery");

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

	static Logger log = Logger.getLogger(AilmentEnum.class.getName());

	public List<String> getAilmentenum() {

		List<String> list = new ArrayList<String>();
		try {
			List<AilmentEnum> somethingList = Arrays.asList(AilmentEnum
					.values());

			for (AilmentEnum dd : somethingList) {
				list.add(dd.getKey());
			}
		} catch (Exception e) {
			log.info("" + e);
		}
		return list;
	}

}
