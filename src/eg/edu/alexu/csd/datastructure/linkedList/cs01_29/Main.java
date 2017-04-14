/**
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs01_29;

/**
 * @author welcome
 */
public class Main {
/**
 *
 * @param args for blah blah
 */
	public static void main(final String[] args) {

		Polynomial poly = new Polynomial();
		int[][]terms1 = {{2, 2}, {2, 1}, {-1, 0}};
		int[][]terms2 = {{1, 1}, {-1, 0}};
		poly.setPolynomial('A', terms1);
		poly.setPolynomial('B', terms2);
		int[][]results = poly.multiply('A', 'A');
		results = poly.add('A', 'A');
		System.out.println(poly.print('B'));
	}
}
