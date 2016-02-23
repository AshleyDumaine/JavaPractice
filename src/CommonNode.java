import java.util.HashSet;
import java.util.LinkedList;

public class CommonNode {
	public static Object findCommon(LinkedList<Object> first, LinkedList<Object> second) {
		HashSet<Object> nodes = new HashSet<Object>();
		// put first list into the set node by node and if a node is already there 
		// when iterating over second list, it's a common node
		// runtime: O(n)
		// assume not circular
		for (Object item : first) {
			nodes.add(item);
		}
		// assume not circular
		for (Object item : second) {
			if (nodes.contains(item)) {
				return item;
			}
		}
		return null;
	}
	
	// driver program
	public static void main(String args[]) {
		LinkedList<Object> first = new LinkedList<Object>();
		first.add(1);
		first.add(2);
		first.add(3);
		LinkedList<Object> second = new LinkedList<Object>();
		second.add(2);
		second.add(5);
		second.add(7);
		Object common = findCommon(first, second);
		System.out.println("Common node: " + common);
	}
}
