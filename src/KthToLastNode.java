import java.util.LinkedList;

public class KthToLastNode {
	public static Object findKthToLastNode(LinkedList<Object> list, int k) {
		return list.get(list.size() - k);
	}
	
	public static void main(String args[]) {
		LinkedList<Object> intList = new LinkedList<Object>();
		for (int i = 0; i < 100; i++) {
			intList.add(i);
		}
		System.out.println(findKthToLastNode(intList, 30));
	}
}
