public class UnitTests {
	
	public static void main(String[] args) throws Exception {
		
		String[] inFixExpressions = {"123 + 123",
									 "123 / 123 - 12 + 0 / 15",
									 "1.45 + 1.45  ",
									 "((123 + 123) / 123) - 987",
									 "((123 + 123) / 123) ^ (1000 - 987)",
									 "(1000 - 987) ^ (492 / (123 + 123))",
									 "(((9.2 + 2.8) / 4.8) * 4.4) / (1.9 / 3.8) - 3.4"};

		String[] postFixExpressions = {"123 123 +",
									   "123 123 / 12 - 0 15 / +",
									   "1.45 1.45 +  ",
									   "123 123 + 123 / 987 -",
									   "123 123 + 123 / 1000 987 - ^",
									   "1000 987 - 492 123 123 + / ^",
									   "9.2 2.8 + 4.8 / 4.4 * 1.9 3.8 / / 3.4 -"};
		
		System.out.print("Testing isInfix: ");
		for(String str : inFixExpressions){
			assert true == RecursiveInFixEvaluator.isInfix(str);
		}
		System.out.println("PASS");
		
		
		System.out.print("Testing isPostFix: ");
		for(String str : postFixExpressions){
			assert true == RecursivePostFixEvaluator.isPostfix(str);
		}
		
		System.out.println("PASS");
		
		
		System.out.print("Testing evaluateInFix: ");
		for(String expression : inFixExpressions){
			System.out.print(RecursiveInFixEvaluator.evaluateInfix(expression) + ", ");
		}
		System.out.println("PASS");
		
		System.out.print("Testing evaluatePostFix: ");
		for(String expression : postFixExpressions){
			System.out.print(RecursivePostFixEvaluator.evaluatePostfix(expression) + ", ");
		}
		System.out.println("PASS");
	}

}
