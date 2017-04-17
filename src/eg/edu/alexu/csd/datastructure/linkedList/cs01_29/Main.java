/**
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs01_29;

import java.util.Scanner;
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
		boolean varCisSet = false, wrongInput = false;
		boolean set = true;
		char ch;
		int x;
		final int option3 = 3, option4 = 4, option5 = 5;
		final int option6 = 6, option7 = 7, option2 = 2;
		final int option1 = 1;
		Scanner scan = new Scanner(System.in);
		while (true) {
			x = 0;
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
			String input = null;
			input = scan.nextLine();
			try {
				ch = input.charAt(1);
				wrongInput = true;
			} catch (Exception e) {
				wrongInput = false;
			}
			if (Character.isDigit(input.charAt(0))
				&& !wrongInput) {
				x = Integer.parseInt(input);
			}
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
					+ " in the form :(coeff1, exponent1 ),"
						+ " (coeff2, exponent2 ), ..");
				String tempScan1 = scan.nextLine();
				tempScan1 += ", ";
				String tempScan2 = "";
				int k = 0;
				while (tempScan1.length() != k) {
					if (tempScan1.charAt(k) == ','
						|| tempScan1.charAt(k) == '0'
						|| tempScan1.charAt(k) == '1'
						|| tempScan1.charAt(k) == '2'
						|| tempScan1.charAt(k) == '3'
						|| tempScan1.charAt(k) == '4'
						|| tempScan1.charAt(k) == '5'
						|| tempScan1.charAt(k) == '6'
						|| tempScan1.charAt(k) == '7'
						|| tempScan1.charAt(k) == '8'
						|| tempScan1.charAt(k) == '9') {
					tempScan2 += tempScan1.charAt(k);
					}
					k++;
				}
				String str;
				int j = 0, t = 0;
			int[] splitTerms = new int[(tempScan2.length() / 2)];
				for (int i = 0; i < splitTerms.length
			&& j < (tempScan2.length() - 1); i++) {
					str = "";
					if (tempScan2.charAt(j) == ',') {
						j++;
					}
					while (tempScan2.charAt(j) != ',') {
						str += tempScan2.charAt(j);
						j++;
					}
					if (str != "") {
					splitTerms[t] = Integer.parseInt(str);
					t++;
					}
				}
				int[][] terms = new int[t / 2][2];
				j = 0;
				for (int i = 0; i < t / 2; i++) {
					terms[i][0] = splitTerms[j];
					terms[i][1] = splitTerms[j + 1];
					j += 2;
				}
				try {
					poly.setPolynomial(ch, terms);
					set = true;
				} catch (Exception e) {
					set = false;
				System.out.println("Variable is not set");
				}
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
					if ((ch == 'A' && !varAisSet)
						|| (ch == 'B' && !varBisSet)
						|| (ch == 'C' && !varCisSet)) {
					System.out.println("Variable not set");
						ch = 'D';
					}
				} while (ch != 'A' && ch != 'B' && ch != 'C'
						&& ch != 'R');
				System.out.print("Result set in R: ");
				System.out.println(poly.print(ch));
				System.out.println();

		} else if (x == option3 || x == option4 || x == option5) {
				do {
				System.out.println("Insert the first operand"
				+ " name: A, B or C \npress E to exit");
				input = scan.nextLine();
				ch = input.charAt(0);
				ch = Character.toUpperCase(ch);
				if (ch == 'E') {
					return;
				}
				if ((ch == 'A' && !varAisSet)
					|| (ch == 'B' && !varBisSet)
					|| (ch == 'C' && !varCisSet)) {
					System.out.println("Variable not set");
					ch = 'D';
				}
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
					if ((ch == 'A' && !varAisSet)
						|| (ch == 'B' && !varBisSet)
						|| (ch == 'C' && !varCisSet)) {
					System.out.println("Variable not set");
						ch = 'D';
					}
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
			} else if (x == option6) {
				do {
		System.out.println("Insert the variable name: A, B, C or R"
				+ "\npress E to Exit");
				input = scan.nextLine();
				ch = input.charAt(0);
				ch = Character.toUpperCase(ch);
				if (ch == 'E') {
					return;
				}
				if ((ch == 'A' && !varAisSet)
					|| (ch == 'B' && !varBisSet)
					|| (ch == 'C' && !varCisSet)) {
					System.out.println("Variable not set");
					ch = 'D';
					}
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
				System.out.println("Insert the variable name:"
				+ " A, B, C or R\npress E to exit");
				input = scan.nextLine();
				ch = input.charAt(0);
				ch = Character.toUpperCase(ch);
				if (ch == 'E') {
					return;
				}
				if ((ch == 'A' && !varAisSet)
					|| (ch == 'B' && !varBisSet)
					|| (ch == 'C' && !varCisSet)) {
					System.out.println("Variable not set");
					ch = 'D';
				}
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
}
