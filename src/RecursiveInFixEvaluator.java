import java.util.*;

public class RecursiveInFixEvaluator {

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
		if(isInfix(expression)){
			expression = expression.replace("(", " ( ");
			expression = expression.replace(")", " ) ");
			
			ArrayList<String> exp = new ArrayList<String>(Arrays.asList(expression.split("[ ]+")));
			while(exp.contains("")){
				exp.remove("");
			}
			
			return toNumber(eval(exp));	
		}
		return -1;
	}
		
	private static String eval(ArrayList<String> exp) throws Exception{
		
		String[] operators = {"^", "*", "/", "+", "-"};
		int loc  = 1;
		for(String op: operators){
			while(exp.contains(op)){
				loc = exp.indexOf(op);
				String lft = exp.get(loc - 1);
				String rht = exp.get(loc + 1);
				
				
				if(")".equals(lft)){
					ArrayList<String> lftSide = new ArrayList<String>();
					int numOpenBraces = 0;
					
					do{
						lftSide.add(0, exp.get(loc - 1));
						
						if(")".equals(exp.get(loc - 1))){
							numOpenBraces++;
							exp.remove(loc - 1);
							loc--;
						}else if("(".equals(exp.get(loc - 1))){
							numOpenBraces--;
							if(numOpenBraces > 1){exp.remove(loc - 1);loc--;}
						}else{
							exp.remove(loc - 1);
							loc--;
						}
					}while(numOpenBraces > 0);
				
					lft = eval(lftSide);
					exp.set(loc - 1, lft);
				}
				
				if("(".equals(rht)){
					ArrayList<String> rhtSide = new ArrayList<String>();
					int numOpenBraces = 0;
					
					do{
						rhtSide.add(exp.get(loc + 1));
						
						if("(".equals(exp.get(loc + 1))){
							numOpenBraces++;
							exp.remove(loc + 1);
						}else if(")".equals(exp.get(loc + 1))){
							numOpenBraces--;
							if(numOpenBraces > 1){exp.remove(loc + 1);}
						}else{
							exp.remove(loc + 1);
						}
					}while(numOpenBraces > 0);
					
					rht = eval(rhtSide);
					exp.set(loc + 1, rht);
				}
				
				exp.set(loc, Double.toString(doOperator(exp.get(loc), toNumber(lft), toNumber(rht))));
				exp.remove(loc + 1);
				exp.remove(loc - 1);
				loc--;
			}
		}
		return exp.get(loc);
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
