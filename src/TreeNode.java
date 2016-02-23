/******************************************
 * BINARY Tree implementation and traversals
 ******************************************/
import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class TreeNode<T> {
	private T data;
	private TreeNode<T> parent;
	private TreeNode<T> left;
	private TreeNode<T> right;
	public TreeNode(T rootData) {
		this.parent = null;
		this.data = rootData;
		this.left = null;
		this.right = null;
	}
	
	public void setData(T data) {
		this.data = data;
	}

	public void setLeft(TreeNode<T> left) {
		if (left == null) return;
		this.left = left;
		left.parent = this;
	}

	public void setRight(TreeNode<T> right) {
		if (right == null) return;
		this.right = right;
		right.parent = this;
	}

	public T data() {
		return this.data;
	}

	public TreeNode<T> right() {
		return this.right;
	}

	public TreeNode<T> left() {
		return this.left;
	}

	public TreeNode<T> parent() {
		return this.parent;
	}

	public LinkedList<T> preorder() {
		LinkedList<T> list =  new LinkedList<T>();
		list.add(this.data());
		if (this.left != null) list.addAll(this.left.preorder());
		if (this.right != null) list.addAll(this.right.preorder());
		return list;
	}

	public LinkedList<T> postorder() {
		LinkedList<T> list = new LinkedList<T>();
		if (this.left != null) list.addAll(this.left.postorder());
		if (this.right != null) list.addAll(this.right.postorder());
		list.add(this.data());
		return list;
	}

	public LinkedList<T> inorder() {
		LinkedList<T> list = new LinkedList<T>();
		if (this.left != null) list.addAll(this.left.inorder());
		list.add(this.data());
		if (this.right != null) list.addAll(this.right.inorder());
		return list;	
	}

	public LinkedList<T> dfs(HashSet<TreeNode<T>> visitedSet) { // like preorder except with a visited set
		LinkedList<T> list = new LinkedList<T>();
		if (!visitedSet.contains(this)) list.add(this.data);
		visitedSet.add(this);
		if (this.left != null) list.addAll(this.left.dfs(visitedSet));
		if (this.right != null) list.addAll(this.right.dfs(visitedSet));
		return list;
	}

	public LinkedList<T> bfs(HashSet<TreeNode<T>> visitedSet) { //aka level order traversal
		LinkedList<T> list = new LinkedList<T>();
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		queue.add(this);
		visitedSet.add(this);
		while (!queue.isEmpty()) {
			TreeNode<T> node = queue.remove();
			list.add(node.data);
			if (node.left != null) {
				if (!visitedSet.contains(node.left)) {
					queue.add(node.left);
					visitedSet.add(node.left);
				}
			}
			if (node.right != null) {
				if (!visitedSet.contains(node.right)) {
					queue.add(node.right);
					visitedSet.add(node.right);
				}
			}
		}
		visitedSet.clear();
		return list;
	}
	
	public LinkedList<T> rightToLeftBFS(HashSet<TreeNode<T>> visitedSet) { 
		LinkedList<T> list = new LinkedList<T>();
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		queue.add(this);
		visitedSet.add(this);
		while (!queue.isEmpty()) {
			TreeNode<T> node = queue.remove();
			list.add(node.data);
			if (node.right != null) {
				if (!visitedSet.contains(node.right)) {
					queue.add(node.right);
					visitedSet.add(node.right);
				}
			}
			if (node.left != null) {
				if (!visitedSet.contains(node.left)) {
					queue.add(node.left);
					visitedSet.add(node.left);
				}
			}
		}
		visitedSet.clear();
		return list;
	}

	public LinkedList<T> inverseBFS(HashSet<TreeNode<T>> visitedSet) { //I have a feeling this might be useful�
		//use right to left bfs with a stack so result is left to right
		LinkedList<T> list = this.rightToLeftBFS(visitedSet);
		LinkedList<T> res = new LinkedList<T>();
		Stack<T> stack = new Stack<T>();
		for(T i : list) 
			stack.push(i);
		while(!stack.isEmpty())
			res.add(stack.pop());
		return res;	
	}

	//driver program
	public static void main(String[] args) {
		TreeNode<String> root = new TreeNode<String>("4");
		root.setLeft(new TreeNode<String>("2"));
		root.setRight(new TreeNode<String>("6"));
		root.left().setLeft(new TreeNode<String>("1"));
		root.left().setRight(new TreeNode<String>("3"));
		root.right().setLeft(new TreeNode<String>("5"));
		root.right().setRight(new TreeNode<String>("7"));
		LinkedList<String> list = root.inorder();
		System.out.println("Inorder:");
		for (String i : list) {
			System.out.println(i);
		}
		LinkedList<String> list2 = root.preorder();
		System.out.println("Preorder:");
		for (String i : list2) {
			System.out.println(i);
		}
		LinkedList<String> list3 = root.postorder();
		System.out.println("Postorder:");
		for (String i : list3) {
			System.out.println(i);
		}
		HashSet<TreeNode<String>> visitedSet = new HashSet<TreeNode<String>>();
		LinkedList<String> list4 = root.dfs(visitedSet);
		System.out.println("dfs:");
		for (String i : list4) {
			System.out.println(i);
		}
		visitedSet.clear();
		LinkedList<String> list5 = root.bfs(visitedSet);
		System.out.println("bfs:");
		for (String i : list5) {
			System.out.println(i);
		}
		LinkedList<String> list6 = root.inverseBFS(visitedSet);
		System.out.println("ReverseLevelOrder:");
		for (String i : list6) {
			System.out.println(i);
		}
	}
}


