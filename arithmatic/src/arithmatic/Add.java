package arithmatic;

public class Add {

	int op1;
	int op2;
	
	Add(int o1, int o2){
		
		op1 =o1;
	    op2 = o2;
	}	
	
	int evaluate(){
		int value = op1 +op2;
		return value;
	}
}
