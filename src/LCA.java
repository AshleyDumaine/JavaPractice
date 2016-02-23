
public class LCA {
	public static void main(String args[]) {
		TreeNode<Integer> root = new TreeNode<Integer>(4);
		root.setLeft(new TreeNode<Integer>(2));
		root.setRight(new TreeNode<Integer>(6));
		root.left().setLeft(new TreeNode<Integer>(1));
		root.left().setRight(new TreeNode<Integer>(3));
		root.right().setLeft(new TreeNode<Integer>(5));
		root.right().setRight(new TreeNode<Integer>(7));
		System.out.println(lowestCommonAncestor(root, 1, 6));
	}
	public static Integer lowestCommonAncestor(TreeNode<Integer> root, int n1, int n2) {
		if (root == null || root.left() == null || root.right() == null) {
			return null;
		}
		if (n1 > root.data() && n2 > root.data()) {
			return lowestCommonAncestor(root.right(), n1, n2);
		}
		else if (n1 < root.data() && n2 < root.data()) {
			return lowestCommonAncestor(root.left(), n1, n2);
		}
		return root.data();
	}
}
