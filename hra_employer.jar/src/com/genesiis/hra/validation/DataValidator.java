package com.genesiis.hra.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jboss.logging.Logger;

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

		log.info("isFutureDate" +status);
		return status;
	}

	public boolean isPastDate(String day) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date date1 = dateFormat.parse(dateFormat.format(date));
		Date date2 = dateFormat.parse(day);

		if (date1.after(date2)) {
			status = true;
		}
		log.info("isPastDate" +status);
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
		log.info("isEqualDate" +status);
		return status;
	}

	public boolean isValidNic(String nic) {
		boolean status = false;
		
		if(nic.matches("[0-9]{9}V")){
			status = true;
		}
		log.info("isValidNic" +status);
		return status;
	}

	public boolean isValidString(String text) {
		boolean status = false;
		if ( (text != null) &&  (text.isEmpty() == false)) {
			status = true;
		}
		log.info("isValidString - status " + status);
		return status;
	}
	
	public boolean isNumber(String text) {
		boolean status = false;		
		if ((text.isEmpty() == false) && text != null) {
			   try {
				   Integer number = Integer.parseInt(text) ;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				return false;
			}catch ( Exception s){
				return false;
			}
			status = true;
		}
		log.info("isNumber" +status);
		return status;
	}

	//
	public boolean isValidInt(int text) {
		boolean status = false;
		if  (text != 0) {
			status = true;
		}
		log.error("isValidInt - status " + status);
		return status;
	}
	
	//validate email address
	public boolean isValidemail(String email) {
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Boolean b = email.matches(EMAIL_REGEX);
		log.info("isValidemail" +b);
		return b;
	}

	//validate telephone number
	public boolean isValidTelephone(String number) {
		boolean status = false;
		if (number.matches("[0-9]+") && number.length() == 10) {
			status = true;
		}
		log.info("isValidTelephone" +status);
		return status;
	}
	
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
	
	//convert String Date to Sql Date
	public java.sql.Date convertStringDatetoSqlDate(String stringDate){
		
		java.sql.Date sqlDate = null;
		
		try {
			
			if (!stringDate.equals(null) && stringDate != null) {
				stringDate = stringDate.trim().toString();
				if (stringDate != "" && !stringDate.equals("")) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date parsed = format.parse(stringDate);
					sqlDate = new java.sql.Date(parsed.getTime());
				} else {
					sqlDate = new java.sql.Date(Calendar.getInstance()
							.getTime().getTime());
				}
			}
			
	        
		} catch (Exception e) {
			log.info(e);
			e.printStackTrace();
		}
		return sqlDate;
	}
}