package com.genesiis.hra.command;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
/*
 *20160622 PC HRA-30 create Abstract class Search 
*/
public abstract class Search implements ICommand  {
	
			@Override
			public String execute(String keyWord) throws ParseException {
				
				return null;
			}

			@Override
			public Object extractFromJason(String data) {
				
				return null;
			}

			@Override
			public String validateValue(Object entiytObject) throws ParseException {
				
				return null;
			}

			@Override
			public Boolean validateValue(HashMap<Integer, Object> entitytMap) {
				
				return null;
			}
			public int validateFind(String emplIdenti) {
				
				return 0;
			}
			
			
			public String createGson(List<Object> emp) {					
					
					return null;
			}
			
		}
