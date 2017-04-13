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

	private DoubleLinkedList A = new DoubleLinkedList();
	private DoubleLinkedList B = new DoubleLinkedList();
	private DoubleLinkedList C = new DoubleLinkedList();
	private DoubleLinkedList R = new DoubleLinkedList();
	private DoubleLinkedList X = new DoubleLinkedList();
	private DoubleLinkedList Y = new DoubleLinkedList();

	/**
	 *
	 * @param X
	 * @param terms
	 */
	public void setPoly(final DoubleLinkedList X, final int[][]terms) {
		if (!X.isEmpty()) {
			X.clear();
		}
		int max = 0;
		for (int i = 0; i < terms.length; i++) {
			if (max < terms[i][1]) {
				max = terms[i][1];
			}
		}
		int i = 0;
		while (i <= max) {
			X.add(0);
			i++;
		}
		for (i = 0; i < terms.length; i++) {
			int index = max - terms[i][1];
			X.set(index, (int) X.get(index) + terms[i][0]);
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
			setPoly(A, terms);
		} else if (poly == 'B') {
			setPoly(B, terms);
		} else if (poly == 'C') {
			setPoly(C, terms);
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
			X = A;
		} else if (poly == 'B') {
			X = B;
		} else if (poly == 'C') {
			X = C;
		} else {
			throw new RuntimeException();
		}
		int size = X.size();
		if (X.size() == 0) {
			return null;
		}
		int i = 0;
		String result = "";

		while (size != 0) {
			size--;
			if ((int) X.get(i) != 0) {
				if (((int) X.get(i) != 1 || size == 0)
						&& ((int) X.get(i) < 0 && size != 0)) {
					result += (int) X.get(i) + "X^" + (X.size() - 1 - i);
				} else if ((int) X.get(i) > 1 && size != 0) {
					result += "+" + (int) X.get(i) + "X^" + (X.size() - 1 - i);
				} else if ((int) X.get(i) == 1 && size != 0) {
					result += "+" + "X";
				} else if (size == 0) {
					if ((int) X.get(i) > 0) {
						result += "+" + (int) X.get(i);
					} else {
						result += (int) X.get(i);

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
			X = A;
		} else if (poly == 'B') {
			X = B;
		} else if (poly == 'C') {
			X = C;
		} else {
			throw new RuntimeException();
		}

		X.clear();
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
			X = A;
		} else if (poly == 'B') {
			X = B;
		} else if (poly == 'C') {
			X = C;
		} else {
			throw new RuntimeException();
		}
		float result = 0;
		int size = X.size();
		if (size != 0) {
			for (int i = 1; i <= size; i++) {
				result += (Integer) (X.get(i - 1)) * (float) (Math.pow(value, (size - i)));
			}
		}
		//if null return 0 wala null??
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
			X = A;
		} else if (poly1 == 'B') {
			X = B;
		} else if (poly1 == 'C') {
			X = C;
		} else {
			throw new RuntimeException();
		}
		if (poly2 == 'A') {
			Y = A;
		} else if (poly2 == 'B') {
			Y = B;
		} else if (poly2 == 'C') {
			Y = C;
		} else {
			throw new RuntimeException();
		}

		int size1 = X.size(), size2 = Y.size(), size;
		int result;

		if (size1 < size2) {
			size = size2 - size1;
			int i = 0;
			while (i < size) {
				R.add(Y.get(i));
				i++;
			}
			for (i = 0; i < size1; i++) {
				result = (int) X.get(i) + (int) Y.get(i + size);
					R.add(result);
			}
		} else {
			size = size1 - size2;
			int i = 0;
			while (i < size) {
				R.add(X.get(i));
				i++;
			}
			for (i = 0; i < size2; i++) {
				result = (int) X.get(i + size) + (int) Y.get(i);
				R.add(result);
			}
		}
		int arrSize = R.size(), s = 0;
		int[][]results = new int[arrSize][2];
		for (int i = 0; i < arrSize; i++) {
			if ((int) R.get(i) != 0) {
				results[s][0] = (int) R.get(i);
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
			X = A;
		} else if (poly1 == 'B') {
			X = B;
		} else if (poly1 == 'C') {
			X = C;
		} else {
			throw new RuntimeException();
		}
		if (poly2 == 'A') {
			Y = A;
		} else if (poly2 == 'B') {
			Y = B;
		} else if (poly2 == 'C') {
			Y = C;
		} else {
			throw new RuntimeException();
		}

		int size1 = X.size(), size2 = Y.size(), size;
		int result;

		if (size1 < size2) {
			size = size2 - size1;
			int i = 0, t;
			while (i < size) {
				t = (int) Y.get(i);
				R.add(-t);
				i++;
			}
			for (i = 0; i < size1; i++) {
				result = (int) X.get(i) - (int) Y.get(i + size);
					R.add(result);
			}
		} else {
			size = size1 - size2;
			int i = 0;
			while (i < size) {
				R.add(X.get(i)); //add a minus
				i++;
			}
			for (i = 0; i < size2; i++) {
				result = (int) X.get(i + size) - (int) Y.get(i);
				R.add(result);
			}
		}
		int arrSize = R.size(), s = 0;
		int[][]results = new int[arrSize][2];
		for (int i = 0; i < arrSize; i++) {
			if ((int) R.get(i) != 0) {
				results[s][0] = (int) R.get(i);
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
			X = A;
		} else if (poly1 == 'B') {
			X = B;
		} else if (poly1 == 'C') {
			X = C;
		} else {
			throw new RuntimeException();
		}
		if (poly2 == 'A') {
			Y = A;
		} else if (poly2 == 'B') {
			Y = B;
		} else if (poly2 == 'C') {
			Y = C;
		} else {
			throw new RuntimeException();
		}

		if (Y.size() == 0 && X.size() == 0) {
			return null;
		}
		int rsize = Y.size() + X.size() - 1;
		int i = 0;
		while (i <= rsize - 1) {
			R.add(0);
			i++;
		}

		boolean xIsbigger = false;
		int maxSize = Y.size();
		int minSize = X.size();
		if (X.size() > Y.size()) {
			maxSize = X.size();
			minSize = Y.size();
			xIsbigger = true;
		}
		int arrayLen = 0;
		int result = 0;
		for (i = 1; i <= maxSize; i++) {
			for (int j = 1; j <= minSize; j++) {
				if (xIsbigger) {
					result = (int) X.get(i - 1) * (int) Y.get(j - 1);
					int index = (i + j + R.size() - 2) - R.size();
					if (result != 0 && (int) R.get(index) == 0) {
						arrayLen++;
					}
					R.set(index, (int) R.get(index) + result);
				} else {
					result = (int) Y.get(i - 1) * (int) X.get(j - 1);
					int index = (i + j + R.size() - 2) - R.size();
					if (result != 0 && (int) R.get(index) == 0) {
						arrayLen++;
					}
					R.set(index, (int) R.get(index) + result);
				}
			}
		}


		int[][] results = new int[arrayLen][2];
		int j = 0;
		int exp = R.size() - 1;
		i = 0;
		while (i < arrayLen) {
			if ((int) R.get(j) != 0) {
				results[i][0] = (int) R.get(j);
				results[i][1] = exp;
				i++;
			}
			exp--;
			j++;
		}

		return results;
	}
}
