package com.genesiis.hra.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jboss.logging.Logger;


///***********************************************
//* 20160415 PN HRA-2 created DataValidator.java class
//* 20160430 PN created isValidnic() method.
//***********************************************/

public class DataValidator {
	static Logger log = Logger.getLogger(DataValidator.class.getName());

	Date date = new Date();
	boolean status = false;

	public boolean isFutureDate(String day) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date date1 = dateFormat.parse(dateFormat.format(date));
		Date date2 = dateFormat.parse(day);
		if (date1.before(date2)) {
			status = true;
		}
		return status;
	}

	public boolean isPastDate(String day) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date date1 = dateFormat.parse(dateFormat.format(date));
		Date date2 = dateFormat.parse(day);

		if (date1.after(date2)) {
			status = true;
		}
		return status;
	}

	public boolean isEqualDate(String day) throws ParseException {
		log.info("day" + day);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date date1 = dateFormat.parse(dateFormat.format(date));
		Date date2 = dateFormat.parse(day);

		if (date1.equals(date2)) {
			status = true;
		}
		return status;
	}

	public boolean isValidNic(String nic) {
		boolean status = false;
		boolean numaric = true;
		boolean letter = true;

		if (nic.length() == 10) {
			for (int i = 0; i < nic.length() - 1; i++) {
				if (!Character.isDigit(nic.charAt(i))) {
					numaric = false;
				}
			}
			if (!Character.isLetter(nic.charAt(nic.length() - 1))) {
				letter = false;
			}
			if ((numaric == true) && (letter == true)) {
				status = true;
			}
		}
		return status;
	}

	public boolean isValidString(String text) {
		boolean status = false;
		if (!text.isEmpty() && text != null) {
			status = true;
		}
		return status;
	}
}
