package arithmetic;
public class Factorial {

	public int factorialIterative(int value) {

		for (int i = value; i > 1; i--) {
			value = value * (i - 1);
		}
		return value;
	}

	public int factorialRecursive(int value) {
		if (value == 1) {
			return value;
		}

		return value * factorialRecursive(value - 1);
	}

	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		System.out.println(factorial.factorialIterative(4));
		System.out.println(factorial.factorialRecursive(4));
	}
}
