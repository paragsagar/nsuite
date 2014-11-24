package nsuite;
/**
 * 
Given a non-negative real number a, its square root is a number x, such that x * x = a.
One way to compute a square root is via successive approximation, where one estimate
yields a better estimate.

 *
 */
public class SquareRoot {

	/**
	 * Method to find approximate Square root
	 * @param a - Number to find the Square root of
	 * @param epsilon - A starting guess value of square root.
	 */
	public static void squareRoot(double a, double epsilon)
	{
		while(0.001 < Math.abs(epsilon * epsilon - a)){
			epsilon = (epsilon + a/epsilon ) / 2;
		}
		System.out.println(Double.toString(epsilon));
	}

	
	/**
	 * main method to check the square roots.
	 * @param args
	 */
	public static void main(String[] args) {
	
		squareRoot(4.5,2);
//		2.1213235294117645
		
		squareRoot(2,1e-6);
//		1.4142334869735127
		
		squareRoot(2.5,1.5);
//		1.581140350877193
		
		squareRoot(3.5,1);
//		1.8708287126121879

		squareRoot(0,1);
//		0.03125
		
	}

}
