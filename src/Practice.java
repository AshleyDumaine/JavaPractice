import java.util.*;

public class Practice {
	public static int recursiveFib(int i) {
		if (i == 0) {
			return 0;
		}
		else if (i == 1) {
			return 1;
		}
		else {
			return recursiveFib(i - 1) + recursiveFib(i - 2);
		}
	}
	
	public static int count_num_twos(int max) {
		int res = 0;
		for (int i = 0; i <= max; i++) {
			int temp = i;
			while (temp > 1) {
				if (temp % 10 == 2) res++;
				temp /= 10;
			}
		}
		return res;
	}
	
	public static int optimized(int max) {
		int num_digits = 0;
		int temp = max;
		int res = 0;
		while (temp > 0) {
			temp /= 10;
			num_digits++;
		}
		// we need to check first digit and see if it's a 2
		int first = first_digit(max);
		if (first == 2) {
			//add number after first digit to res + 1
		}
		return res;
	}
	
	public static int first_digit(int num) {
		return 0;
	}


	//driver program
	public static void main(String args[]) {
		// test recursive fib
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a positive number: ");
		int input = sc.nextInt();
		sc.close();
		int res = recursiveFib(input);
		System.out.println("Result of recursiveFib: " + res);
		// test count # of 2's
		System.out.println(count_num_twos(100));
	}
}
