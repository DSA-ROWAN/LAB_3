
public class PostFixEvaluator {

	public static boolean isPostFix(String expression) {
		String[] exp = expression.split("[ ]*?");
		
		if(isNumeric(exp[0]) && isNumeric(exp[1])){
			return true;
		}
		return false;
	}
	
	public static double evaluatePostfix(String expression){
		
		
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
