package com.genesiis.hra.command;

import java.util.HashMap;
import java.util.List;

public abstract class Serch implements ICommandAJX {

	@Override
    public String execute(String gsonData, String epf) {
	     // TODO Auto-generated method stub
	     return null;
    }
	@Override
	public String execute(String keyWord) {
		 
		return null;
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
	public int validateFind(String emplIdenti) {
		// TODO Auto-generated method stub
		return (Integer) null;
	}
	
	// Create geson object
	public String createGson(List<Object> emp) {					
			
		return  null;
	}

	@Override
	public String execute(int epf) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


