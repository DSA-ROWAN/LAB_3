
public class InFixEvaluator {

	public static boolean isInfix(String expression) {
		expression = expression.replace("(", " ");
		expression = expression.replace(")", " ");
		
		String[] exp = expression.split("[ ]*?");
		
		for(int i = 0; i < exp.length - 1; i++){
			if(isNumeric(exp[i]) && isNumeric(exp[i + 1])){
				return false;
			}
		}
		return true;
	}

	public static double evaluateInfix(){
		
		return 0;
	}
	
	private static boolean isOperator(String operand){
		return operand.matches("[+-*/\\^]");
	}
	
	private static boolean isNumeric(String operand){
		return operand.matches("[0-9]");
	}
	
	private static double toNumber(String num){
		return Double.parseDouble(num);
	}
}
