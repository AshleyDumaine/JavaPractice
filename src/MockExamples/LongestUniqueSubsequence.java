package MockExamples;

import java.util.HashMap;

public class LongestUniqueSubsequence {
	public static void main(String args[]) {
		System.out.println(longestSebsequenceofKUniqueChars("abcdabceeeeefjklooo", 4));
	}

	public static int longestSebsequenceofKUniqueChars(String input, int uniqueChars) {
		// read in the input, storing characters in the map as we read right
		// on going over k, chop off first character and keep chopping off until equal to or less than k
		HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
		int max = 0;
		int start = 0;
		int currentMax = 0;
		for (int i = 0; i < input.length(); i++) {
			int iterMax = 0;
			if (chars.containsKey(input.charAt(i))) {
				chars.replace(input.charAt(i), chars.get(input.charAt(i)) + 1);
				iterMax++;
			}
			else {
				while (chars.size() == uniqueChars) {
					int newCount = chars.get(input.charAt(start)) - 1;
					if (newCount > 0) {
						chars.replace(input.charAt(start), newCount);
					}
					else {
						chars.remove(input.charAt(start));
					}
					iterMax--;
					start++;
				}
				chars.put(input.charAt(i), 1);
				iterMax++;
			}
			currentMax += iterMax;
			max = Math.max(max, currentMax);
		}
		return max;
	}
}
