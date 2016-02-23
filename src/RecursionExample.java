public class RecursionExample {
	public static int recursiveFactorial(int i) {
		return (i == 0 || i == 1) ? 1 : i * recursiveFactorial(i - 1);
	}
	public static int iterativeFactorial(int i) {
		if (i == 0 || i == 1) return 1;
		else {
			int res = 1;
			for (int j = i; j > 1; j--) {
				res *= j;
			}
			return res;
		}
	}
	public static void main(String args[]) {
		int input = 10;
		double start_1 = System.nanoTime();
		System.out.println(recursiveFactorial(input));
		double end_1 = System.nanoTime();
		System.out.println("Recursion time: " + (end_1 - start_1));
		double start_2 = System.nanoTime();
		System.out.println(iterativeFactorial(input));
		double end_2 = System.nanoTime();
		System.out.println("Iteration time: " + (end_2 - start_2));
	}
}
