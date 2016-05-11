package com.genesiis.hra.command;

import java.util.HashMap;

import com.genesiis.hra.model.Loan;
import com.genesiis.hra.model.LoanCrudJDBC;
import com.genesiis.hra.validation.DataValidator;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class RegisterLoan implements ICommand {

	public String execute(String gsonData) {
		String message = "";
		LoanCrudJDBC loanManager = new  LoanCrudJDBC();
		try {
			Loan extractedLndetail = (Loan)extractFromJason(gsonData); 
			if(extractedLndetail!=null){
				if (validateValue(extractedLndetail)) {
					message = loanManager.add(extractedLndetail);
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
	
	public Boolean validateValue(Object entityObject){
		DataValidator validator = new DataValidator();
		Loan loan =(Loan)entityObject;
		String message = "";
		if (loan!= null) {
			if (!validator.isValidString(loan.getemployeeEpf())) {
				message = message + " Department Number "
						+ MessageList.EMPTYFIELD.message() + " ";
			}
			if (!validator.isValidString(loan.getLoanAmount())) {
				message = message + " Department Name "
						+ MessageList.EMPTYFIELD.message() + " ";
			}
			if (!validator.isValidString(loan.getLoanBorrowers())) {
				message = message + " Department Name "
						+ MessageList.EMPTYFIELD.message() + " ";
			}
			if (!validator.isValidString(loan.getLoanmonthlyPayment())) {
				message = message + " Department Name "
						+ MessageList.EMPTYFIELD.message() + " ";
			}
			if (!validator.isValidString(loan.getLoanDueDate())) {
				message = message + " Department Name "
						+ MessageList.EMPTYFIELD.message() + " ";
			}
		} else {
			return false;
		}
		return true;
	}
	
    public Boolean validateValue(HashMap<Integer, Object> entityMap){
		
		return null;
	}
}
