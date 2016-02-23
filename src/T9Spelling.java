import java.util.Scanner;
import java.util.HashMap;

public class T9Spelling {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Character, String> keyMapping = new HashMap<Character, String>();
		setupMapping(keyMapping);
		int numCases = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < numCases; i++) {
			String message = sc.nextLine();
			String res = "";
			char last = 0;
			for (int j = 0; j < message.length(); j++) {
				String current = keyMapping.get(message.charAt(j));
				if (current.charAt(0) == last) {
					res += " ";
				}
				res += current;
				last = current.charAt(0);
			}
			System.out.println("Case #" + (i+1) + ": " + res);
		}
		sc.close();
	}
	public static void setupMapping(HashMap<Character, String> hashmap) {
		hashmap.put('a', "2");
		hashmap.put('b', "22");
		hashmap.put('c', "222");
		hashmap.put('d', "3");
		hashmap.put('e', "33");
		hashmap.put('f', "333");
		hashmap.put('g', "4");
		hashmap.put('h', "44");
		hashmap.put('i', "444");
		hashmap.put('j', "5");
		hashmap.put('k', "55");
		hashmap.put('l', "555");
		hashmap.put('m', "6");
		hashmap.put('n', "66");
		hashmap.put('o', "666");
		hashmap.put('p', "7");
		hashmap.put('q', "77");
		hashmap.put('r', "777");
		hashmap.put('s', "7777");
		hashmap.put('t', "8");
		hashmap.put('u', "88");
		hashmap.put('v', "888");
		hashmap.put('w', "9");
		hashmap.put('x', "99");
		hashmap.put('y', "999");
		hashmap.put('z', "9999");
		hashmap.put(' ', "0");
	}
}