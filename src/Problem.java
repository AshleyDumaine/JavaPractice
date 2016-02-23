import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem {
	public static void main(String args[]) {
		if (args.length == 0) {
			System.out.println("No filepath provided as input.");
			System.exit(0);
		}
		try {
			Scanner fs = new Scanner(new File(args[0]));
			StringBuilder sb = new StringBuilder();
			while (fs.hasNextLine()) {
				sb.append(" ").append(fs.nextLine());
			}
			String[] words = sb.toString().replaceAll("[.,]", "").split("\\s+");
			// Remove all punctuation, convert to lowercase, and split on spaces
			String[] modifiedWords = sb.toString().replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			// Print the unmodified version of the word (including hyphens and apostrophes)
			System.out.println(words[findWordWithMostRepeats(modifiedWords)]);
			fs.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println(args[0] + " is not a file or does not exist.");
			System.exit(0);
		}
	}

	public static int findWordWithMostRepeats(String[] words) {
		int wordIndexWithMostRepeats = -1;
		int mostRepeatsForWord = 0;
		for (int j = 0; j < words.length; j++) {
			// Have an array of buckets for each character (non-case sensitive)
			// 26 buckets since we are only concerned with English words (assuming no accents)
			int[] charCounts = new int[26];
			int mostRepeatsForCharacter = 0;
			for (int i = 0; i < words[j].length(); i++) {
				if (++charCounts[((int) words[j].charAt(i)) - 'a'] > mostRepeatsForCharacter) {
					mostRepeatsForCharacter = charCounts[((int) words[j].charAt(i)) - 'a'];
				}
			}
			// Only update wordWithMostRepeats and mostRepeatsForWord if this amount of repeated 
			// Characters is strictly greater than the current max
			if (mostRepeatsForWord < mostRepeatsForCharacter) {
				wordIndexWithMostRepeats = j;
				mostRepeatsForWord = mostRepeatsForCharacter;
			}
		}
		return wordIndexWithMostRepeats;
	}
}
