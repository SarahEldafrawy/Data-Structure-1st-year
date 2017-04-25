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
	public String infixToPostfix(final String expresion) {
		String expression = expresion.replaceAll("\\ ", "");
		if (expression == "") {
			throw new RuntimeException();
		}
		int i = 0, t = 0;
		// check for brackets
		while (i < expresion.length()) {
			if (expression.charAt(i) == '(') {
				t++;
			} else if (expression.charAt(i) == ')') {
				t--;
			}
			i++;
		}
		if (t != 0) {
			throw new RuntimeException();
		}
		i = 0;
		while (i < expresion.length()) {
			if (i < expression.length() && (expression.charAt(i) == '+' || expression.charAt(i) == '-'
					|| expression.charAt(i) == '*' || expression.charAt(i) == '/')) {
					i++;
					if (i < expression.length() && (expression.charAt(i) == '+' || expression.charAt(i) == '-' 
						|| expression.charAt(i) == '*' || expression.charAt(i) == '/')) {
						throw new RuntimeException();
					}
			}
		i++;
		}
		i = expression.length() - 1;
		if (expression.charAt(i) == '+' || expression.charAt(i) == '-' 
				|| expression.charAt(i) == '*' || expression.charAt(i) == '/') {
			throw new RuntimeException();
		}
		String str = "";
		Stack operator = new Stack();
		i = 0;
		while (i < expression.length()) {
			while (i < expression.length() && expression.charAt(i) != '+'
				&& expression.charAt(i) != '-' && expression.charAt(i) != '*'
				&& expression.charAt(i) != '/' && expression.charAt(i) != '('
				&& expression.charAt(i) != ')') {
				str += expression.charAt(i) + " ";
				i++;
			}
			if (i < expression.length() && (expression.charAt(i) == '+' || expression.charAt(i) == '-')) {
				operator.push(expression.charAt(i));
				i++;
				while (i < expression.length() && expression.charAt(i) != '+'
					&& expression.charAt(i) != '-' && expression.charAt(i) != '*'
					&& expression.charAt(i) != '/' && expression.charAt(i) != '('
					&& expression.charAt(i) != ')') {
					str += expression.charAt(i) + " ";
					i++;
				}
			}
			if (i < expression.length() && (expression.charAt(i) == '*' || expression.charAt(i) == '/')) {
				operator.push(expression.charAt(i));
				i++;
				while (i < expression.length() && expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*' && expression.charAt(i) != '/' && expression.charAt(i) !='(' && expression.charAt(i) !=')') {
					str += expression.charAt(i) + " ";
					i++;
				}
			}
			if (i < expression.length() && expression.charAt(i) == '(') {
					operator.push(expression.charAt(i));
					i++;
					while (i < expression.length() && expression.charAt(i) != '+'
						&& expression.charAt(i) != '-' && expression.charAt(i) != '*' 
						&& expression.charAt(i) != '/' && expression.charAt(i) != '(' 
						&& expression.charAt(i) != ')') {
						str += expression.charAt(i) + " ";
						i++;
					}
			}
			if (i < expression.length() && expression.charAt(i) == ')') {
				i++;
				while (operator.peek() != (Object) '(' && !operator.isEmpty()) {
					str += operator.pop() + " ";
				}
				operator.pop();
			}
			while (!operator.isEmpty() && operator.peek() != (Object)'(') {
				str += operator.pop() + " ";
			}
		}
		if (str.length() > 0) {
			str = str.trim();
		}
		return str;
	}
	/**
	* Evaluate a postfix numeric expression, with a single space separator
	* @param expression postfix expression
	* @return the expression evaluated value
	*/
	@Override
	public int evaluate(final String expresion) {
//		String expression = expresion.replaceAll("\\ ", "");
		if (expresion == "") {
			throw new RuntimeException();
		}
//		int i = 0;
//		while (i < expression.length()) {
//			if (expression.charAt(i) == '+' || expression.charAt(i) == '-' 
//				|| expression.charAt(i) == '*' || expression.charAt(i) == '/') {
//				i++;
//				if (i < expression.length() && (expression.charAt(i) == '+' || expression.charAt(i) == '-' 
//					|| expression.charAt(i) == '*' || expression.charAt(i) == '/')) {
//					throw null;
//				}
//			}
//			if (i < expression.length() && (expression.charAt(i) <= '0' || expression.charAt(i) >= '9')) {
//				throw null;
//			}
//			i++;
//		}
//		int operator1, operator2;
//		int res = 0;
//		Stack operator = new Stack();
//		i = 0;
//		while (i < expression.length()) {
//			if (expression.charAt(i) == '+') {
//				operator1 = (float) operator.pop();
//				operator2 = (float) operator.pop();
//				//res = operator1 + operator2;
//				operator.push(res);
//				i++;
//			} else if (expression.charAt(i) == '-') {
//				operator1 = (float) operator.pop();
//				operator2 = (float) operator.pop();
//				//res = operator2 - operator1;
//				operator.push(res);
//				i++;
//			} else if (expression.charAt(i) == '*') {
//				operator1 = (float) operator.pop();
//				operator2 = (float) operator.pop();
//				//res = operator1 * operator2;
//				operator.push(res);
//				i++;
//			}
//		if (expression.charAt(i) == '/') {
//				operator1 = (Integer) operator.peek();
//				operator.pop();
//				operator2 = (Integer) operator.pop();
//				res = operator2 + operator1;
//				operator.push(res);
//				i++;
//			} else {
//				while (i < expression.length() && expression.charAt(i) != '+'
//					&& expression.charAt(i) != '-' && expression.charAt(i) != '*'
//					&& expression.charAt(i) != '/') {
//					if (expression.charAt(i) != ' ') {
//						operator.push(expression.charAt(i));
//					}
//					i++;
//				}
//			}
//		}
		return 0;
	}
}
