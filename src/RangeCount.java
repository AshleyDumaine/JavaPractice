public class RangeCount {
	public static void main(String args[]) {
		Node root = new Node(4);
		root.setLeft(new Node(2));
		root.setRight(new Node(6));
		root.left().setLeft(new Node(1));
		root.left().setRight(new Node(3));
		root.right().setLeft(new Node(5));
		root.right().setRight(new Node(7));
		System.out.println(numNodesInRange(root, 3, 6));
	}

	public static int numNodesInRange(Node root, int start, int end) {
		if (root == null) {
			return 0;
		}
		int middle = ((Integer) root.data() >= start && (Integer) root.data() <= end) ? 1 : 0;
		return numNodesInRange(root.left(),start, end) + middle + numNodesInRange(root.right(),start, end);
	}
}
