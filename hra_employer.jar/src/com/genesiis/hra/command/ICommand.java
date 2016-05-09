package com.genesiis.hra.command;

import java.util.HashMap;


public interface ICommand {	
		public String execute(String gsonData) ;
		
		public Object extractFromJason(String data);
		
		public Boolean validateValue(Object entiytObject); 
		
		public Boolean validateValue(HashMap<Integer, Object> entitytMap);
}
