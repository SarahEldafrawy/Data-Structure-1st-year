/**
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs01_29;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author welcome
 */
public class Main {
/**
 *
 * @param args for main
 */
	public static void main(final String[] args) {
		Polynomial poly = new Polynomial();
		boolean varAisSet = false, varBisSet = false;
		boolean varCisSet = false;
		char ch;
		int x;
		final int option3 = 3, option4 = 4, option5 = 5;
		final int option6 = 6, option7 = 7, option2 = 2;
		final int option1 = 1;
		Scanner scan = new Scanner(System.in);
		while (true) {
			x = 0;
			printOptions();
			String input = null;
			input = scan.nextLine();
			x = validateInput(x, input);
			if (x == option1) {
				do {
				System.out.println("Insert the variable name:"
					+ " A, B or C \n press E to exit");
					ch = scan.next().charAt(0);
					scan.nextLine();
					ch = Character.toUpperCase(ch);
					if (ch == 'E') {
						return;
					}
				} while (ch != 'A' && ch != 'B' && ch != 'C');

				System.out.println("Insert the polynomial terms"
					+ " in the form :(coeff1, exponent1),"
						+ " (coeff2, exponent2), ..");
				boolean set = true;
				String tempScan = scan.nextLine();
				tempScan += ", ";
				set = setVar(poly, ch, tempScan);
				if (set) {
					if (ch == 'A') {
						varAisSet = true;
					} else if (ch == 'B') {
						varBisSet = true;
					} else {
						varCisSet = true;
					}
				}
			} else if (x == option2) {
				do {
				System.out.println("Insert the variable name:"
					+ " A, B, C or R \n press E to exit ");
					input = scan.nextLine();
					ch = input.charAt(0);
					ch = Character.toUpperCase(ch);
					if (ch == 'E') {
						return;
					}
					ch = checkSetVar(varAisSet,
			varBisSet, varCisSet, ch);
				} while (ch != 'A' && ch != 'B'
						&& ch != 'C' && ch != 'R');
				System.out.print("Result set in R: ");
				System.out.println(poly.print(ch));
				System.out.println();

		} else if (x == option3
				|| x == option4 || x == option5) {
				do {
				System.out.println("Insert the first operand"
				+ " name: A, B or C \npress E to exit");
				input = scan.nextLine();
				ch = input.charAt(0);
				ch = Character.toUpperCase(ch);
				if (ch == 'E') {
					return;
				}
				ch = checkSetVar(varAisSet,
						varBisSet, varCisSet, ch);
				} while (ch != 'A' && ch != 'B' && ch != 'C');
				char ch1 = ch;
				do {
				System.out.println("Insert the second operand"
				+ " name: A, B or c \n press E to exit");
				input = scan.nextLine();
				ch = input.charAt(0);
				ch = Character.toUpperCase(ch);
					if (ch == 'E') {
						return;
					}
					ch = checkSetVar(varAisSet,
			varBisSet, varCisSet, ch);
				} while (ch != 'A' && ch != 'B' && ch != 'C');
				char ch2 = ch;
				int[][] results = null;
				if (x == option3) {
					results = poly.add(ch1, ch2);
				} else if (x == option4) {
					results = poly.subtract(ch1, ch2);
				} else {
					results = poly.multiply(ch1, ch2);
				}
				operationPrint(results);
			} else if (x == option6) {
				do {
		System.out.println("Insert the variable name:"
				+ "A, B, C or R"
				+ "\npress E to Exit");
				input = scan.nextLine();
				ch = input.charAt(0);
				ch = Character.toUpperCase(ch);
				if (ch == 'E') {
					return;
				}
				ch = checkSetVar(varAisSet,
						varBisSet, varCisSet, ch);
				} while (ch != 'A' && ch != 'B' && ch != 'C'
					&& ch != 'R');
				System.out.println("Please enter the point to"
					+ " evaluate the polynomial: ");
				float value = scan.nextFloat();
				scan.nextLine();
			float result = poly.evaluatePolynomial(ch, value);
				System.out.print("Result set in R: ");
				System.out.println(result);
			} else if (x == option7) {
				do {
					System.out.println("Insert the"
							+ " variable name:"
					+ " A, B, C or R\npress E to exit");
					input = scan.nextLine();
					ch = input.charAt(0);
					ch = Character.toUpperCase(ch);
					if (ch == 'E') {
						return;
				}
				ch = checkSetVar(varAisSet,
						varBisSet, varCisSet, ch);
				} while (ch != 'A' && ch != 'B' && ch != 'C'
					&& ch != 'R');
				poly.clearPolynomial(ch);
				if (ch == 'A') {
					varAisSet = false;
				} else if (ch == 'B') {
					varBisSet = false;
				} else if (ch == 'C') {
					varCisSet = false;
				}
			} else {
  System.out.println("please enter a valid number");
			}
		}
	}

/**
 * @param varAisSet of A.
 * @param varBisSet of B.
 * @param varCisSet of C.
 * @param ch input.
 * @return var input.
 */
private static char checkSetVar(final boolean varAisSet,
		final boolean varBisSet,
		final boolean varCisSet, final char ch) {
	char var = ch;
	if ((ch == 'A' && !varAisSet)
		|| (ch == 'B' && !varBisSet)
		|| (ch == 'C' && !varCisSet)) {
	System.out.println("Variable not set");
		var = 'D';
	}
	return var;
}

/**
 * @param results of poly.
 */
private static void operationPrint(final int[][] results) {
	System.out.print("Result set in R: ");
	for (int i = 0; i < results.length; i++) {
		for (int j = 0; j < 2; j++) {
			if (j == 0) {
System.out.print("(" + results[i][j] + ",");
			}
			if (j == 1) {
System.out.print(" " + results[i][j] + ")");
			}
		}
		if (i != results.length - 1) {
System.out.print("," + " ");
		}
	}
System.out.println();
}

/**
 * @param poly polynomial.
 * @param ch variable.
 * @param tempScan str.
 * @return set of var.
 */
private static boolean setVar(final Polynomial poly,
		final char ch,
		final String tempScan) {
	int[][] terms = null;
	boolean set;
	String temp = tempScan;
	String regex = "(\\(-?\\d+, -?\\d+\\), )";
	String scanPattern = "";
	Matcher pattern =
Pattern.compile(regex).matcher(tempScan);
	while (pattern.find()) {
		scanPattern += pattern.group();
	}
	if (temp.equals(scanPattern)) {
temp = temp.replaceAll("\\(", "");
temp = temp.replaceAll("\\)", "");
String[] tempTerms = temp.split(", ");
int lenght = tempTerms.length / 2;
terms = new int[lenght][2];
int strElem = 0;
for (int i = 0; i < lenght; i++) {
	for (int j = 0; j < 2; j++) {
terms[i][j] = Integer.parseInt(tempTerms[strElem]);
			strElem++;
			}
		}
	}
	try {
		poly.setPolynomial(ch, terms);
		set = true;
	} catch (Exception e) {
		set = false;
	System.out.println("Variable is not set");
	}
	return set;
}

/**
 * @param x of in.
 * @param input string.
 * @return value of in.
 */
private static int validateInput(final int x,
		final String input) {
	boolean wrongInp = true;
	int value = 0;
	if (input.length() == 1) {
		wrongInp = false;
	}
	if (Character.isDigit(input.charAt(0))
		&& !wrongInp) {
		value = Integer.parseInt(input);
	}
	return value;
}

/**
 *
 */
private static void printOptions() {
	System.out.println("Please choose an action:");
	System.out.println("1-Set a polynomial variable");
	System.out.println("2-Print the value of a "
				+ "polynomial variable");
	System.out.println("3-Add two polynomials");
	System.out.println("4-Subtract two polynomials");
	System.out.println("5-Multiply two polynomials");
	System.out.println("6-Evaluate a polynomial at"
					+ " some point");
	System.out.println("7-Clear a polynomial variable");
}
}
