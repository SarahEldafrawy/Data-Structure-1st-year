/**
 *
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs01_29;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

/**
 * @author Personal
 *
 */
public class Polynomial implements IPolynomialSolver {
/**
 *
 */
	private DoubleLinkedList varA = new DoubleLinkedList();
	/**
	 */
	private DoubleLinkedList varB = new DoubleLinkedList();
	/**
	 */
	private DoubleLinkedList varC = new DoubleLinkedList();
	/**
	 */
	private DoubleLinkedList varR = new DoubleLinkedList();
	/**
	 */
	private DoubleLinkedList varX = new DoubleLinkedList();
	/**
	 */
	private DoubleLinkedList varY = new DoubleLinkedList();
	/**
	 *
	 * @param terms array of terms
	 * @param list is a double linked list
	 */
	public void setPoly(final DoubleLinkedList list, final int[][]terms) {
		if (!list.isEmpty()) {
			list.clear();
		}
		int max = 0;
		for (int i = 0; i < terms.length; i++) {
			if (max < terms[i][1]) {
				max = terms[i][1];
			}
			if ((terms[i][1]) < 0 || max != terms[0][1]) {
					throw null;
			}
		}
		int i = 0;
		while (i <= max) {
			list.add(0);
			i++;
		}
		for (i = 0; i < terms.length; i++) {
			int index = max - terms[i][1];
			list.set(index, (int) list.get(index) + terms[i][0]);
		}
	}
	/**.
	* Set polynomial terms (coefficients & exponents)
	* @param poly name of the polynomial
	* @param terms array of [coefficients][exponents]
	*/
	@Override
	public void setPolynomial(final char poly, final int[][] terms) {
		if (poly == 'A') {
			setPoly(varA, terms);
		} else if (poly == 'B') {
			setPoly(varB, terms);
		} else if (poly == 'C') {
			setPoly(varC, terms);
		} else {
			throw new RuntimeException();
		}
	}
	/**.
	* Print the polynomial in human readable representation
	* @param poly name of the polynomial
	* @return polynomial in the form like 27x^2+x-1
	*/
	@Override
	public String print(final char poly) {
		if (poly == 'A') {
			varX = varA;
		} else if (poly == 'B') {
			varX = varB;
		} else if (poly == 'C') {
			varX = varC;
		} else if (poly == 'R') {
			varX = varR;
		} else {
			throw null;
		}
		int size = varX.size();
		if (varX.size() == 0) {
			return null;
		}
		int i = 0;
		String result = "";
		while (size != 0) {
			size--;
			if ((int) varX.get(i) != 0) {
				if (((int) varX.get(i) != 1 || size == 0)
				&& ((int) varX.get(i) < 0 && size != 0)) {
		result += (int) varX.get(i) + "X^" + (varX.size() - 1 - i);
				} else if ((int) varX.get(i) > 1 && size != 0) {
	result += "+" + (int) varX.get(i) + "X^" + (varX.size() - 1 - i);
			} else if ((int) varX.get(i) == 1 && size != 0) {
					result += "+" + "X";
				} else if (size == 0) {
					if ((int) varX.get(i) > 0) {
					result += "+" + (int) varX.get(i);
					} else {
						result += (int) varX.get(i);
					}
				}
			}
			i++;
		}
		return result;
	}
	/**.
	* Clear the polynomial
	* @param poly name of the polynomial
	*/
	@Override
	public void clearPolynomial(final char poly) {
		if (poly == 'A') {
			varX = varA;
		} else if (poly == 'B') {
			varX = varB;
		} else if (poly == 'C') {
			varX = varC;
		} else {
			throw null;
		}

		varX.clear();
	}
	/**.
	* Evaluate the polynomial
	* @param poly name of the polynomial
	* @param value the polynomial constant
	* @return the value of the polynomial
	*/
	@Override
	public float evaluatePolynomial(final char poly, final float value) {
		if (poly == 'A') {
			varX = varA;
		} else if (poly == 'B') {
			varX = varB;
		} else if (poly == 'C') {
			varX = varC;
		} else if (poly == 'R') {
			varX = varR;
		} else {
			throw null;
		}
		float result = 0;
		int size = varX.size();
		if (size != 0) {
			for (int i = 1; i <= size; i++) {
result += (Integer) (varX.get(i - 1)) * (float) (Math.pow(value, (size - i)));
			}
		}
		return result;
	}
	/**.
	* Add two polynomials
	* @param poly1 first polynomial
	* @param poly2 second polynomial
	* @return the result polynomial
	*/
	@Override
	public int[][] add(final char poly1, final char poly2) {
		if (poly1 == 'A') {
			varX = varA;
		} else if (poly1 == 'B') {
			varX = varB;
		} else if (poly1 == 'C') {
			varX = varC;
		} else {
			throw null;
		}
		if (poly2 == 'A') {
			varY = varA;
		} else if (poly2 == 'B') {
			varY = varB;
		} else if (poly2 == 'C') {
			varY = varC;
		} else {
			throw null;
		}
		varR.clear();
		int size1 = varX.size(), size2 = varY.size(), size;
		int result;
		if (size1 < size2) {
			size = size2 - size1;
			int i = 0;
			while (i < size) {
				varR.add(varY.get(i));
				i++;
			}
			for (i = 0; i < size1; i++) {
			result = (int) varX.get(i) + (int) varY.get(i + size);
					varR.add(result);
			}
		} else {
			size = size1 - size2;
			int i = 0;
			while (i < size) {
				varR.add(varX.get(i));
				i++;
			}
			for (i = 0; i < size2; i++) {
			result = (int) varX.get(i + size) + (int) varY.get(i);
				varR.add(result);
			}
		}
		int arrSize = varR.size(), s = 0;
		int[][]results = new int[arrSize][2];
		for (int i = 0; i < arrSize; i++) {
			if ((int) varR.get(i) != 0) {
				results[s][0] = (int) varR.get(i);
				results[s][1] = arrSize - i - 1;
				s++;
			}
		}
		return results;
	}
	/**.
	* Subtract two polynomials
	* @param poly1 first polynomial
	* @param poly2 second polynomial
	* @return the result polynomial
	*/
	@Override
	public int[][] subtract(final char poly1, final char poly2) {
		if (poly1 == 'A') {
			varX = varA;
		} else if (poly1 == 'B') {
			varX = varB;
		} else if (poly1 == 'C') {
			varX = varC;
		} else {
			throw null;
		}
		if (poly2 == 'A') {
			varY = varA;
		} else if (poly2 == 'B') {
			varY = varB;
		} else if (poly2 == 'C') {
			varY = varC;
		} else {
			throw null;
		}
		varR.clear();
		int size1 = varX.size(), size2 = varY.size(), size;
		int result;

		if (size1 < size2) {
			size = size2 - size1;
			int i = 0, t;
			while (i < size) {
				t = (int) varY.get(i);
				varR.add(-t);  //add a minus
				i++;
			}
			for (i = 0; i < size1; i++) {
			result = (int) varX.get(i) - (int) varY.get(i + size);
					varR.add(result);
			}
		} else {
			size = size1 - size2;
			int i = 0;
			while (i < size) {
				varR.add(varX.get(i));
				i++;
			}
			for (i = 0; i < size2; i++) {
			result = (int) varX.get(i + size) - (int) varY.get(i);
				varR.add(result);
			}
		}
		int arrSize = varR.size(), s = 0;
		int[][]results = new int[arrSize][2];
		for (int i = 0; i < arrSize; i++) {
			if ((int) varR.get(i) != 0) {
				results[s][0] = (int) varR.get(i);
				results[s][1] = arrSize - i - 1;
				s++;
			}
		}
		return results;
	}
	/**.
	* Multiply two polynomials
	* @param poly1 first polynomial
	* @param poly2 second polynomial
	* @return the result polynomial
	*/
	@Override
	public int[][] multiply(final char poly1, final char poly2) {
		if (poly1 == 'A') {
			varX = varA;
		} else if (poly1 == 'B') {
			varX = varB;
		} else if (poly1 == 'C') {
			varX = varC;
		} else {
			throw null;
		}
		if (poly2 == 'A') {
			varY = varA;
		} else if (poly2 == 'B') {
			varY = varB;
		} else if (poly2 == 'C') {
			varY = varC;
		} else {
			throw null;
		}
		varR.clear();
		if (varY.size() == 0 && varX.size() == 0) {
			return null;
		}
		int rsize = varY.size() + varX.size() - 1;
		int i = 0;
		varR.clear();
		while (i <= rsize - 1) {
			varR.add(0);
			i++;
		}
		boolean xIsbigger = false;
		int maxSize = varY.size();
		int minSize = varX.size();
		if (varX.size() > varY.size()) {
			maxSize = varX.size();
			minSize = varY.size();
			xIsbigger = true;
		}
		int arrayLen = 0;
		int result = 0;
		for (i = 1; i <= maxSize; i++) {
			for (int j = 1; j <= minSize; j++) {
				if (xIsbigger) {
			result = (int) varX.get(i - 1) * (int) varY.get(j - 1);
			int index = (i + j + varR.size() - 2) - varR.size();
				if (result != 0 && (int) varR.get(index) == 0) {
						arrayLen++;
					}
				varR.set(index, (int) varR.get(index) + result);
				} else {
			result = (int) varY.get(i - 1) * (int) varX.get(j - 1);
			int index = (i + j + varR.size() - 2) - varR.size();
				if (result != 0 && (int) varR.get(index) == 0) {
						arrayLen++;
					}
				varR.set(index, (int) varR.get(index) + result);
				}
			}
		}
		int[][] results = new int[arrayLen][2];
		int j = 0;
		int exp = varR.size() - 1;
		i = 0;
		while (i < arrayLen) {
			if ((int) varR.get(j) != 0) {
				results[i][0] = (int) varR.get(j);
				results[i][1] = exp;
				i++;
			}
			exp--;
			j++;
		}

		return results;
	}
}
