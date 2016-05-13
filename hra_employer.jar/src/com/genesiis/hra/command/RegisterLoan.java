package com.genesiis.hra.command;

import java.text.ParseException;
import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Loan;
import com.genesiis.hra.model.LoanCrudJDBC;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class RegisterLoan implements ICommand {
	static Logger log = Logger.getLogger(RegisterLoan.class.getName());
	
	public String execute(String gsonData) throws ParseException {
		String message = "";
		LoanCrudJDBC loanManager = new  LoanCrudJDBC();
		try {
			Loan extractedLndetail = (Loan)extractFromJason(gsonData); 			
			if(extractedLndetail!=null){								
				if (validateValue(extractedLndetail).equalsIgnoreCase("True")) {					
					message = loanManager.update(extractedLndetail);
				}
			}
		} catch (NullPointerException e) {
			message = MessageList.EMPTYFIELD.message();
			//log.info("Exception-employee: " + e);
		}catch (ClassCastException e) {
			// TODO: handle exception
			message = MessageList.ERROR.message();
		}		
		return message;
	}
	
	//Extract Gson Object
	public Object extractFromJason(String data){
		Gson gson = new Gson();
		Loan LoanDeatail = null;
		try {
			LoanDeatail = gson.fromJson(data, Loan.class);
		} catch (Exception e) {
			// TODO: handle exception
		}
	  return LoanDeatail;
	}
	
	//Validating data fields
	public String validateValue(Object entityObject) throws ParseException {
		DataValidator validator = new DataValidator();
		Loan loan =(Loan)entityObject;
		String message = "True";
		if (loan!= null) {					
			if (!validator.isValidString(loan.getLoanGuarantor1())) {
				message = message + " Department Name "
						+ MessageList.EMPTYFIELD.message() + " ";
			}
			if (!validator.isValidString(loan.getLoanAmount())) {
				message = message + " Department Name "
						+  MessageList.EMPTYFIELD.message() + " or" +MessageList.INVALIDAMOUNT.message();
				Integer number = Integer.parseInt(loan.getLoanAmount()) ;	
			}
			if (!validator.isValidString(loan.getLoanGuarantor2())) {
				message = message + " Department Name "
						+ MessageList.EMPTYFIELD.message() + " ";
			}
			if (!validator.isValidString(loan.getLoanmonthlyPayment())) {
				message = message + " Department Name "
						+ MessageList.EMPTYFIELD.message() + " or" +MessageList.INVALIDAMOUNT.message();
			}
			/*if (!validator.isFutureDate(loan.getLoanEndDate())) {
				message = message + " Department Name "
						+ MessageList.INVALIDENDDATE.message() + " ";
			}*/
		} 
		return message;
	}
	
    public Boolean validateValue(HashMap<Integer, Object> entityMap){
		
		return null;
	}
}
