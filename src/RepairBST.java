import java.util.LinkedList;

public class RepairBST {
	public static void main(String args[]) {
		TreeNode<Integer> root = new TreeNode<Integer>(4);
		root.setLeft(new TreeNode<Integer>(2));
		root.setRight(new TreeNode<Integer>(1));
		root.left().setLeft(new TreeNode<Integer>(6));
		root.left().setRight(new TreeNode<Integer>(3));
		System.out.println("Before:");
		LinkedList<Integer> list = root.inorder();
		System.out.println("Inorder:");
		for (int i : list) {
			System.out.println(i);
		}
		TreeNode<Integer> rootAns = repairBST(root);
		System.out.println("After:");
		LinkedList<Integer> list2 = rootAns.inorder();
		System.out.println("Inorder:");
		for (int i : list2) {
			System.out.println(i);
		}
	}
	
	public static TreeNode<Integer> repairBST(TreeNode<Integer> root) {
		LinkedList<TreeNode<Integer>> inorder = nodeInorder(root);
		TreeNode<Integer> first = null;
		TreeNode<Integer> middle = null;
		TreeNode<Integer> last = null;
		for (int i = 1; i < inorder.size(); i++) {
			if (inorder.get(i - 1).data() > inorder.get(i).data()) {
				if (first == null) {
					first = inorder.get(i - 1);
					middle = inorder.get(i);
				}
				else {
					last = inorder.get(i);
				}
			}
		}
		if (first != null && last != null) {
			Integer temp = first.data();
			first.setData(last.data());
			last.setData(temp);
		}
		else if (first != null && middle != null) {
			Integer temp = first.data();
			first.setData(middle.data());
			middle.setData(temp);
		}
		return root;
	}
	
	static public LinkedList<TreeNode<Integer>> nodeInorder(TreeNode<Integer> root) {
		LinkedList<TreeNode<Integer>> list = new LinkedList<TreeNode<Integer>>();
		if (root.left() != null) list.addAll(nodeInorder(root.left()));
		list.add(root);
		if (root.right() != null) list.addAll(nodeInorder(root.right()));
		return list;	
	}
}
