
public class IsValidParen {
	public static void main(String args[]) {
		String val_input_1 = "((()))";
		String val_input_2 = "(()())";
		String val_input_3 = "()()()";
		String inval_input_1 = ")(";
		String inval_input_2 = "(()";
		System.out.println(checkIfValidExpr(val_input_1));
		System.out.println(checkIfValidExpr(val_input_2));
		System.out.println(checkIfValidExpr(val_input_3));
		System.out.println(checkIfValidExpr(inval_input_1));
		System.out.println(checkIfValidExpr(inval_input_2));
	}
	public static boolean checkIfValidExpr(String input) {
		// use something like a stack
		// 'push' if encounter '('
		// 'pop' if encounter ')'
		// return false if either the stack is
		// nonempty after reading the whole input
		// or if we try to 'pop' from an empty 'stack'
		int counter = 0; // use a simple counter for a stack to save space
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') counter++;
			else if (input.charAt(i) == ')') counter--;
			if (counter < 0) return false;
		}
		if (counter != 0) return false;
		else return true;
	}
}
