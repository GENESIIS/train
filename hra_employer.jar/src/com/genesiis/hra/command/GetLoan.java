package com.genesiis.hra.command;


import java.text.ParseException;
import java.util.HashMap;

import org.jboss.logging.Logger;
import com.genesiis.hra.model.Loan;
import com.genesiis.hra.model.LoanCrudJDBC;
import com.genesiis.hra.validation.MessageList;
import com.google.gson.Gson;

public class GetLoan implements ICommandAJX {
	static Logger log = Logger.getLogger(GetLoan.class.getName());
	
	public String execute(String epf) {
		String message = "";
		LoanCrudJDBC loanManager = new  LoanCrudJDBC();
		
		try {
			log.info("GEtloan excecute");
			Loan loan = (Loan)loanManager.find(1);	
			message = createGson(loan);			
			log.info("GEtloan excecute" +message);
		} catch (Exception e) {
			message = MessageList.EMPTYFIELD.message();
			//log.info("Exception-employee: " + e);
		}	
		return message; 
	}
	
	// Create Gson object
	public String createGson(Loan ln) {					
		Gson gson = new Gson();	
		String loan = " ";
		try {
			loan = gson.toJson(ln);			
		} catch (Exception e) {
			
		}
		return loan;
	}

	@Override
	public Object extractFromJason(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String validateValue(Object entiytObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validateValue(HashMap<Integer, Object> entitytMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(String gsonData, String epf) {
		// TODO Auto-generated method stub
		return null;
	}
}
