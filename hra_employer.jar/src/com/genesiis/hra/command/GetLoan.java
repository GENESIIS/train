package com.genesiis.hra.command;


import com.genesiis.hra.model.Loan;
import com.genesiis.hra.model.LoanCrudJDBC;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class GetLoan {

	public String execute(String id) {
		String message = "";
		String loanGson = " ";
		LoanCrudJDBC loanManager = new  LoanCrudJDBC();
		
		try {
			Loan loan = (Loan)loanManager.retrive("1");	
			loanGson = createGson(loan);
			
		} catch (Exception e) {
			message = MessageList.EMPTYFIELD.message();
			//log.info("Exception-employee: " + e);
		}	
		return loanGson;
	}
	
	public String createGson(Loan ln) {					
		Gson gson = new Gson();	
		String loan = " ";
		try {
			loan = gson.toJson(ln);			
		} catch (Exception e) {
			
		}
		return loan;
	}
}
