import java.util.Scanner;

public class TrailingZeroFactorial {
	public static int trailingZeros(long n) {
		int numZeros = 0;
		for (int i = 5; n / i > 0; i *= 5) {
			numZeros += n / i;
		}
		return numZeros;
	}

	public static long factorial(long n) {
		return n == 0 ? 1 : (n * factorial(n - 1));
	}

	//driver program
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a positive number: ");
		long n = sc.nextLong();
		sc.close();
		System.out.println(trailingZeros(n));
	}
}
