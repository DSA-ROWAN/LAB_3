
public class InFixEvaluator {

	public static boolean isInfix(String expression) {
		expression = expression.replace("(", " ( ");
		expression = expression.replace(")", " ) ");
		
		String[] exp = expression.split("[ ]+");
		
		for(int i = 0; i < exp.length - 1; i++){
			if(isNumeric(exp[i]) && isNumeric(exp[i + 1])){
				return false;
			}
		}
		return true;
	}

	public static double evaluateInfix(String expression) throws Exception{
		expression = expression.replace("(", " ( ");
		expression = expression.replace(")", " ) ");
		
		String[] exp = expression.split("[ ]+");
		
		if(isInfix(expression)){

			
			
		}else{
			throw new Exception();
		}
		return 0;
	}
	
	private static double evalExpression(String[] expression, int index){
		if(isOperator(expression[index])){
			index++;
			//return doOpertor(expression[index - 1], toNumber(expression[index - 2]), evalExpression(expression, index));
		}else if(isNumber(expression[index])){
			index++;
			//return toNumber(evalExpression(String[] expression, index));
		}else{
			index++;
			return 0;
		} 
	}
	
	private static double doOpertor(String op, val1, val2){
		switch(op){
		case "+":
			return val1 + val2;
			break;
		case "-":
			return val1 - val2;
			break;
		case "*":
			return val1 * val2;
			break;
		case "/":
			return val1 / val2;
			break;
		case "^":
			return val1 ^ val2;
			break;
		default:
			throw new Exception();
		}
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
