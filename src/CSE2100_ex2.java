import java.util.Scanner;

public class CSE2100_ex2 {
	private static int preorder_index = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter preorder traversal:");
		String preorder = sc.nextLine();
		System.out.println("Enter inorder traversal:");
		String inorder = sc.nextLine();
		String[] preorder_split= preorder.split(" ");
		String[] inorder_split= inorder.split(" ");
		String[] preorder_array = new String[preorder_split.length]; 
		String[] inorder_array = new String[inorder_split.length];
		for (int x = 0; x < preorder_split.length; x++) 
		{
			preorder_array[x] = preorder_split[x];
			inorder_array[x] = inorder_split[x];
		}
		TreeNode<String> res = constructTree(preorder_array, inorder_array, 0, inorder_array.length-1);
		System.out.println("answer:");
		//print answer using a level order traversal with formatting
        BTreePrinter.printNode(res);
		sc.close();
	}
	
	public static TreeNode<String> constructTree(String[] preorder, String[] inorder, int inorder_start, int inorder_end) {		
		/* BASE CASES */
		if (inorder_start > inorder_end) return null; //to handle IndexOutOfBound errors
		
		String preorder_elem = preorder[preorder_index++];
		TreeNode<String> treenode = new TreeNode<String>(preorder_elem);
		
		//if node has no children return
		if (inorder_start == inorder_end) return treenode;
		
		/* RECURSIVE CASE */
		//find index of current preorder element in inorder traversal
		int inorder_index = java.util.Arrays.asList(inorder).indexOf(preorder_elem);
		//construct left and right subtrees using the index
		treenode.setLeft(constructTree(preorder, inorder, inorder_start, inorder_index-1));
		treenode.setRight(constructTree(preorder, inorder, inorder_index+1, inorder_end));
		return treenode;
	}
}
