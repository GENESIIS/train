package com.genesiis.hra.command;
import java.util.HashMap;

import org.jboss.logging.Logger;

import com.genesiis.hra.model.Loan;
import com.genesiis.hra.model.LoanCrudJDBC;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

/*******************************************
 * 
 * 09052016 HRA 13 PC RigisterLoan.java class 
 * */

public class RegisterLoan implements ICommandAJX {
	static Logger log = Logger.getLogger(RegisterLoan.class.getName());
	// command class execution method
	public String execute(String gsonData)  {
		int id = -1;
		MessageList message = MessageList.ERROR;;
		LoanCrudJDBC loanManager = new  LoanCrudJDBC();
		try {
			Loan extractedLndetail = (Loan)extractFromJason(gsonData); 
			if(extractedLndetail!=null){
				if (validateValue(extractedLndetail).equalsIgnoreCase("True")) {
					log.info("--------------------------------------------------");
					id = loanManager.add(extractedLndetail);
					message = MessageList.ADDED;
					log.info(message + " "+ MessageList.ADDED);
				}
			}
		} catch (NullPointerException e) {
			message = MessageList.EMPTYFIELD;
			log.info("Exception-employee: " + e);
		}catch (ClassCastException e) {
			// TODO: handle exception
			message = MessageList.ERROR;
			log.info("Exception-employee: " + e);
		}		
		return message.message();
	}
	
	@Override
	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Extract Json object
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
	public String validateValue(Object entityObject) {
		DataValidator validator = new DataValidator();
		Loan loan =(Loan)entityObject;
		String message = "True";
		if (loan!= null) {					
			if (!validator.isValidString(loan.getLoanGuarantor1())) {
				message =  MessageList.EMPTYFIELD.message() + " ";
			}
			if (!validator.isValidString(loan.getLoanAmount())) {
				message = MessageList.EMPTYFIELD.message() + " or" +MessageList.INVALIDAMOUNT.message();						
			}
			if (!validator.isValidString(loan.getLoanGuarantor2())) {
				message = MessageList.EMPTYFIELD.message() + " ";
			}
			if (!validator.isValidString(loan.getLoanmonthlyPayment())) {
				message =  MessageList.EMPTYFIELD.message() + " or" +MessageList.INVALIDAMOUNT.message();
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
