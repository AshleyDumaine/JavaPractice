public class CheckIfBST {
	public static boolean isBST(Node root, int min, int max) {
		if (root == null) return true;
		if ((Integer) root.data() > min && (Integer) root.data() < max &&
				isBST(root.left(), min, Math.min((Integer) root.data(), max)) &&
				isBST(root.right(), Math.max((Integer) root.data(), min), max)) return true;
		else return false;
	}

	public static boolean isValid(Node root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		Node root = new Node(4);
		root.setLeft(new Node(2));
		root.setRight(new Node(5));
		root.left().setLeft(new Node(1));
		root.left().setRight(new Node(6));
		boolean ans = isValid(root);
		System.out.println("Answer: " + ans);
	}
}
