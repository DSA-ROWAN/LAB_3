import java.util.ArrayList;
import java.util.Arrays;

public class PostFixEvaluator {

	public static boolean isPostfix(String expression) {
		String[] exp = expression.split("[ ]*?");
		
		if(isNumeric(exp[0]) && isNumeric(exp[1])){
			return true;
		}
		return false;
	}
	
	public static double evaluatePostfix(String expression) throws Exception{
		if(isPostfix(expression)){
			
			ArrayList<String> exp = new ArrayList<String>(Arrays.asList(expression.split("[ ]+")));
			while(exp.contains("")){
				exp.remove("");
			}
			
			return eval(exp);	
		}
		return -1;
	}
		
	private static double eval(ArrayList<String> exp) throws Exception{
		
		String[] tmp = {"^", "*", "/", "+", "-"};
		ArrayList<String> operators = new ArrayList<String>(Arrays.asList(tmp));
		
		int index = 0;
		while(!operators.contains(exp.get(index))){
			index++;
		}
		
		double num1 = toNumber(exp.get(index - 2));
		double num2 = toNumber(exp.get(index - 1));
		String op = exp.get(index);
		double result = 0;
		
		result = doOperator(op, num1, num2);
		
		if(exp.size() > 3){
			exp.set(index, Double.toString(result));
			exp.remove(index - 1);
			exp.remove(index - 2);
			result = eval(exp);
		}
		return result;
	}

	
	private static double doOperator(String op, double val1, double val2){
		double ret = 0;
		switch(op){
		case "+":
			ret = val1 + val2;
			break;
		case "-":
			ret = val1 - val2;
			break;
		case "*":
			ret = val1 * val2;
			break;
		case "/":
			ret = val1 / val2;
			break;
		case "^":
			ret = Math.pow(val1, val2);
			break;
		default:
			return -1;
		
		}
		return ret;
	}
	
	private static boolean isNumeric(String operand){
		return operand.matches("[0-9\\.]+");
	}
	
	private static double toNumber(String num){
		return Double.parseDouble(num);
	}
	
	
}
