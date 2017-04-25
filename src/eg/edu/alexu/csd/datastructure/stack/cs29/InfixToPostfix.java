/**
 */
package eg.edu.alexu.csd.datastructure.stack.cs29;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 */
public class InfixToPostfix implements IExpressionEvaluator {
	
	/**
	 */
	@Override
	public String infixToPostfix(final String expresion) {
		String expression = expresion.replaceAll("\\ ", "");
		String str = "";
		Stack operator = new Stack();
		int i = 0;
		while (i < expression.length()) {
			while (i < expression.length() && expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*' && expression.charAt(i) != '/' && expression.charAt(i) !='(' && expression.charAt(i) !=')') {
				str += expression.charAt(i);
				i++;
			}
			if (i < expression.length() && expression.charAt(i) == '+' || expression.charAt(i) == '-') {
				operator.push(expression.charAt(i));
				i++;
				while (i < expression.length() && expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*' && expression.charAt(i) != '/' && expression.charAt(i) !='(' && expression.charAt(i) !=')') {
					str += expression.charAt(i);
					i++;
				}
			}
			if (i < expression.length() && expression.charAt(i) == '*' || expression.charAt(i) == '/') {
				operator.push(expression.charAt(i));
				i++;
				while (i < expression.length() && expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*' && expression.charAt(i) != '/' && expression.charAt(i) !='(' && expression.charAt(i) !=')') {
					str += expression.charAt(i);
					i++;
				}
			}
			if (i < expression.length() && expression.charAt(i) == '(') {
					operator.push(expression.charAt(i));
					i++;
					while (i < expression.length() && expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*' && expression.charAt(i) != '/' && expression.charAt(i) !='(' && expression.charAt(i) !=')') {
						str += expression.charAt(i);
						i++;
					}
			}
			if (i < expression.length() && expression.charAt(i) == ')') {
				i++;
				while (operator.peek() != (Object)'(') {
					str += operator.pop();
				}
				operator.pop();
			}
			while (!operator.isEmpty() && operator.peek() != (Object)'(') {
				str += operator.pop();
			}
		}
		return str;
	}
	/**
	 */
	@Override
	public int evaluate(final String expression) {
		
		// TODO Auto-generated method stub
		return 0;
	}

}
