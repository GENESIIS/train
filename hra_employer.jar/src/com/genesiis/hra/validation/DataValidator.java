package com.genesiis.hra.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jboss.logging.Logger;
import com.genesiis.hra.command.AddDepartment;

import sun.util.logging.resources.logging;

///***********************************************
//* This class is to validate user inputs.
//* 20160422 PN HRA-3 created DataValidator.java class
//* 20160425 PN HRA-3 Modified DataValidator.java class
public class DataValidator {
	static Logger log = Logger.getLogger(DataValidator.class.getName());

	Date date = new Date();
	boolean status = false;

	public boolean isPastDate(String day) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date date1 = dateFormat.parse(dateFormat.format(date));
		Date date2 = dateFormat.parse(day);

		if (date1.after(date2)) {
			status = true;
		}
		return status;
	}

	public boolean isFutureDate(String day) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date date1 = dateFormat.parse(dateFormat.format(date));
		Date date2 = dateFormat.parse(day);
		if (date1.before(date2)) {
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
		
		if(nic.matches("[0-9]{9}V")){
			status = true;
		}
		return status;
	}

	public boolean isValidString(String text) {
		boolean status = false;
		if ((text.isEmpty() == false) && text != null) {
			status = true;
		}
		return status;
	}

	public boolean isValidemail(String email) {
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Boolean b = email.matches(EMAIL_REGEX);
		return b;
	}

	public boolean isValidTelephone(String number) {
		boolean status = false;
		if (number.matches("[0-9]+") && number.length() == 10) {
			status = true;
		}
		return status;
	}

}