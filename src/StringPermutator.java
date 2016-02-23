import java.util.HashSet;

public class StringPermutator {
	public static HashSet<String> permutate(String str) {
		return permutate("", str);
	}
	
	public static HashSet<String> permutate(String prefix, String str) {
		HashSet<String> res = new HashSet<String>();
		if (str.length() == 0) {
			res.add(prefix);
		}
		else {
			for (int i =0; i < str.length(); i++) {
				res.addAll(permutate(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1)));
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		HashSet<String> res = permutate("ABC");
		for (String str : res) {
			System.out.println(str);
		}
	}
}
