package com.genesiis.hra.validation;

public enum Operation {

	// For the time being 
		ADD_EMPLOYEE_HISTORY("AEH"), //add employee history data to database
		BAD_OPERATION("BO");

		private final String value;

		Operation(String newValue) {
			this.value = newValue;
		}

		public String getValue() {
			return value;
		}
		
		public static Operation getOperation(String o){		
			for(Operation op : values()){
				if(op.getValue().equalsIgnoreCase(o))
					return op;			
			}		
			return BAD_OPERATION;
		}
		
}
