
public class UnitTests {
	
	public static void main(String[] args) {
		
		String[] inFixExpressions = {"123 + 123", "123 / 123 - 12 + 0 / 15", "1.45 + 1.45  ", "((123 + 123) / 123) - 987"};

		String[] postFixExpressions = {"123 123 +", "123 123 / 12 - 0 15 / +", "1.45 1.45 + ", "123 123 + 123 / 987 -"};
		
		System.out.print("Testing isInfix: ");
		for(String str : inFixExpressions){
			assert true == InFixEvaluator.isInfix(str);
		}
		System.out.println("PASS");
		
		
		System.out.print("Testing isPostFix: ");
		for(String str : inFixExpressions){
			assert true == PostFixEvaluator.isPostFix(str);
		}
		
		System.out.println("PASS");
		
	}

}
