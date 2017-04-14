/**
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs01_29;

/**
 * @author welcome
 */
public class Main {

	public static void main(final String[] args) {

		Polynomial poly = new Polynomial();
		int [][]terms1 = {{2,2},{3,1},{-6,0}};
		int [][]terms2 = {{4,1},{-5,0}};
		poly.setPolynomial('A', terms2);
		poly.setPolynomial('B', terms1);
		int [][] Results = poly.subtract('A', 'B');
		System.out.println(poly.print('B'));
	}
}
