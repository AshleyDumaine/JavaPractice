import java.util.Stack;

public class TestStack {
	public static void main(String args[]) {
		Stack<String> stack = new Stack<String>();
		stack.push("Hello");
		stack.push("world");
		stack.push("oh");
		stack.push("no");
		stack.pop();
		stack.pop();
		System.out.print(stack);
	}
}
