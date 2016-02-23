import java.util.Scanner;


public class MasterMind {
	static int MAX_COLORS = 4;
	public static Result score(String guess, String pattern) {
		Result res = new Result();
		int[] frequencies = new int[MAX_COLORS];
		for (int i = 0; i < guess.length(); i++) {
			if (pattern.charAt(i) == guess.charAt(i)) {
				res.hits++;
			}
			else {
				int code = code(pattern.charAt(i));
				frequencies[code]++;
			}
		}
		for (int j = 0; j < guess.length(); j++) {
			int code = code(guess.charAt(j));
			if (pattern.charAt(j) != guess.charAt(j) && frequencies[code] > 0 && code >= 0) {
				res.psuedoHits++;
				frequencies[code]--;
			}
		}
		return res;
	}

	public static int code(char c) {
		switch (c) {
		case 'B':
			return 0;
		case 'G':
			return 1;
		case 'R':
			return 2;
		case 'Y':
			return 3;
		default:
			return -1;
		}
	}	

	//driver program
	public static void main(String[] args) {
		String pattern = "RGBY";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a 4 letter combination of B G Y or R");
		String guess = sc.nextLine();
		Result res = score(guess, pattern);
		System.out.println(res.toString());
	}
}
