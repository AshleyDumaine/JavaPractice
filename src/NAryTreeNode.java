/*************************************
N-ARY Tree implementation + traversals
 **************************************/
import java.util.*;

public class NAryTreeNode<T> {
	private T data;
	private NAryTreeNode<T> parent;
	private List<NAryTreeNode<T>> children;
	public NAryTreeNode(T rootData) {
		this.parent = null;
		this.data = rootData;
		this.children = new ArrayList<NAryTreeNode<T>>();
	}

	public void setChild(NAryTreeNode<T> child) {
		this.children.add(child);
		child.parent = this;
	}

	public T data() {
		return this.data;
	}

	public List<NAryTreeNode<T>> children() {
		return this.children;
	}

	public NAryTreeNode<T> parent() {
		return this.parent;
	}

	public List<T> dfs(HashSet<NAryTreeNode<T>> visitedSet) {
		List<T> list = new LinkedList<T>();
		if (!visitedSet.contains(this)) list.add(this.data);
			visitedSet.add(this);
		for (NAryTreeNode<T> child : this.children) {
			if (!visitedSet.contains(child))
				list.addAll(child.dfs(visitedSet));
		}
		if (this.parent != null) list.addAll(this.parent.dfs(visitedSet));
		return list;
	}

	public List<T> bfs(HashSet<NAryTreeNode<T>> visitedSet) {
		List<T> list = new LinkedList<T>();
		Queue<NAryTreeNode<T>> queue = new LinkedList<NAryTreeNode<T>>();
		queue.add(this);
		visitedSet.add(this);
		while (!queue.isEmpty()) {
			NAryTreeNode<T> node = queue.remove();
			list.add(node.data);
			for (NAryTreeNode<T> child : node.children) {
				if (!visitedSet.contains(child)) {
					queue.add(child);
					visitedSet.add(child);
				}
			}

		}
		return list;
	}

	public List<T> rightToLeftbfs(HashSet<NAryTreeNode<T>> visitedSet) {
		List<T> list = new LinkedList<T>();
		Queue<NAryTreeNode<T>> queue = new LinkedList<NAryTreeNode<T>>();
		queue.add(this);
		visitedSet.add(this);
		while (!queue.isEmpty()) {
			NAryTreeNode<T> node = queue.remove();
			list.add(node.data);
			for (int i = node.children.size() -1; i >= 0; i--) {
				if (!visitedSet.contains(node.children.get(i))) {
					queue.add((node.children.get(i)));
					visitedSet.add((node.children.get(i)));
				}
			}
		}
		return list;
	}

	public List<T> reverseLevelOrder(HashSet<NAryTreeNode<T>> visitedSet) { //I have a feeling this might be useful…
		//use right to left bfs with a stack so result is left to right
		List<T> list = this.rightToLeftbfs(visitedSet);
		List<T> res = new LinkedList<T>();
		Stack<T> stack = new Stack<T>();
		for(T i : list) 
			stack.push(i);
		while(!stack.isEmpty())
			res.add(stack.pop());
		return res;	
	}

	//driver program
	public static void main(String[] args) {
		NAryTreeNode<String> root = new NAryTreeNode<String>("1");
		NAryTreeNode<String> child1 = new NAryTreeNode<String>("2");
		NAryTreeNode<String> child2 = new NAryTreeNode<String>("6");
		NAryTreeNode<String> child3 = new NAryTreeNode<String>("10");
		child1.setChild(new NAryTreeNode<String>("3"));
		child1.setChild(new NAryTreeNode<String>("4"));
		child1.setChild(new NAryTreeNode<String>("5"));
		child2.setChild(new NAryTreeNode<String>("7"));
		child2.setChild(new NAryTreeNode<String>("8"));
		child2.setChild(new NAryTreeNode<String>("9"));
		child3.setChild(new NAryTreeNode<String>("11"));
		child3.setChild(new NAryTreeNode<String>("12"));
		root.setChild(child1);
		root.setChild(child2);
		root.setChild(child3);
		HashSet<NAryTreeNode<String>> visitedSet = new HashSet<NAryTreeNode<String>>();
		List<String> list4 = root.dfs(visitedSet);
		System.out.println("dfs:");
		for (String i : list4) {
			System.out.println(i);
		}
		visitedSet.clear();
		List<String> list5 = root.bfs(visitedSet);
		System.out.println("bfs:");
		for (String i : list5) {
			System.out.println(i);
		}
		visitedSet.clear();
		List<String> list6 = root.reverseLevelOrder(visitedSet);
		System.out.println("ReverseLevelOrder:");
		for (String i : list6) {
			System.out.println(i);
		}
	}
}

