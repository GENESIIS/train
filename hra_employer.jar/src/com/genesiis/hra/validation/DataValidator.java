package com.genesiis.hra.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jboss.logging.Logger;

import com.genesiis.hra.utill.MaskValidator;

///***********************************************
//* 20160415 PN HRA-2 created DataValidator.java class
//* 20160430 PN created isValidnic() method.
//* 20160505 PN created isValidemail(), isValidTelephone() methods.
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

	/**
	 * @see - Validation of telephone number
	 * @param - String
	 * @return int
	 * **/
	public boolean isValidTelephone(String number) {
		boolean status = false;
		if (number.matches("[0-9]+") && number.length() == 10) {
			status = true;
		}
		return status;
	}
	
	/**
	 * 
	 * @param - String
	 * @return int
	 * **/
	public int validTaskId(String task) {
		if (task.equalsIgnoreCase(MessageList.ADD.message())) {
			return 1;
		} else if (task.equalsIgnoreCase(MessageList.UPDATE.message())) {
			return 2;
		} else if (task.equalsIgnoreCase(MessageList.DELETE.message())) {
			return 3;
		} else if (task.equalsIgnoreCase(MessageList.GETALL.message())) {
			return 4;
		} else if (task.equalsIgnoreCase(MessageList.FIND.message())) {
			return 5;
		} else {
			return -1;
		}
	}
	
	/**
	 * @author thumeera
	 * @param - String
	 * @return int binary
	 * **/
	public int maskValidator(String text) {
		int returnValue = -1;

		if (text != null) {
			String priMask = text.toString().trim();

			if (priMask.equals(MaskValidator.MSK_FEMALE_DES)) {
				return MaskValidator.MSK_FEMALE;
			} else if (priMask.equals(MaskValidator.MSK_MALE_DES)) {
				return MaskValidator.MSK_MALE;
			} else if (priMask.equals(MaskValidator.MSK_OTHER_DES)) {
				return MaskValidator.MSK_OTHER;
			}

		} else {
			return MaskValidator.MSK_OTHER;
		}
		return returnValue;
	}
	
	/**
	 * @author thumeera
	 * @param - int value
	 * @return String Description
	 * **/
	public String maskReverseValidator(int value) {
		String returnDescription = MaskValidator.MSK_OTHER_DES;

		switch(value){
		
		case MaskValidator.MSK_FEMALE:
			return MaskValidator.MSK_FEMALE_DES;

		case MaskValidator.MSK_MALE:
			return MaskValidator.MSK_MALE_DES;

		case MaskValidator.MSK_HEAD_OFFICE:
			return MaskValidator.MSK_HEAD_OFFICE_DES;

		case MaskValidator.MSK_BRANCH_UNION_PLACE:
			return MaskValidator.MSK_BRANCH_UNION_PLACE_DES;

		case MaskValidator.MSK_BORELLA_OFFICE:
			return MaskValidator.MSK_BORELLA_OFFICE_DES;

		}
		
		return returnDescription;
	}
	
}