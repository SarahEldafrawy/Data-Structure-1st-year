/**
 */
package eg.edu.alexu.csd.datastructure.stack.cs29;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 */
public class InfixToPostfix implements IExpressionEvaluator {
	
	/**
	* Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms or the
	* length of the term (e.g., two digits symbolic or numeric term)
	* @param expression infix expression
	* @return postfix expression
	*/
	@Override
	public String infixToPostfix(final String expression) {
		//String expression = expresion.replaceAll("\\ ", "");
		if (expression == "") {
			throw new RuntimeException();
		}
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
				while (operator.peek() != (Object) '(') {
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
	* Evaluate a postfix numeric expression, with a single space separator
	* @param expression postfix expression
	* @return the expression evaluated value
	*/
	@Override
	public int evaluate(final String expression) {
		
		if (expression == "") {
			throw new RuntimeException();
		}
		return 0;
	}

}
