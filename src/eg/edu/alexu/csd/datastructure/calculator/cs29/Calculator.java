package eg.edu.alexu.csd.datastructure.calculator.cs29;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;
/**
 */
public class Calculator implements ICalculator {
	/**
	 */
	@Override
	public int add(final int x, final int y) {
		int z;
		z = x + y;
		return z;
	}
	/**
	 */
	@Override

	public float divide(final int x, final int y) {
		return (float) x / (float) y;
	}
}
