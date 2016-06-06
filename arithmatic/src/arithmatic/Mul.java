package arithmatic;

public class Mul {

	
	int op1;
	int op2;
	
	Mul(int o1, int o2){
		 op1 =o1;
	     op2 = o2;
	}
	
	int evaluate(){
		int value = op1 *op2;
		return value;
	}
}
