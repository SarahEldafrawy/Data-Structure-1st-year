package eg.edu.alexu.csd.datastructure.calculator.cs29;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

public class calculator implements ICalculator{

	@Override
	public int add(int x, int y) {
		int z;
		z=x+y;
		return z;
	}

	@Override
	public float divide(int x, int y) {
		 
		return x/y;
	}

}
