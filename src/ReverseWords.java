import java.util.Scanner;

public class ReverseWords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numCases = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < numCases; i++) {
			String input = sc.nextLine();
			String[] words = input.split("\\s+");
			System.out.print("Case #" + (i+1) + ": ");
			for (int j = words.length - 1; j >= 0; j--) {
				System.out.print(words[j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
