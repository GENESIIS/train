package com.genesiis.hra.command;

import java.text.ParseException;
import java.util.HashMap;


public interface ICommandAJX {			
		
        public String execute(String gsonData) ;
		
		public Object extractFromJason(String data);
		
		public String validateValue(Object entiytObject) throws ParseException; 
		
		public Boolean validateValue(HashMap<Integer, Object> entitytMap);

		public String execute(int epf);
}
