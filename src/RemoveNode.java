
public class RemoveNode {
	public static void removeNode(Node node) {
		// last node in list
		if (node.next() == null) {
			node = null;
		}
		// middle or first node
		// make this node into a copy of its next node
		node.setData(node.next().data());
		node.setNext(node.next().next());
		// garbage collector will get rid of unreferenced next node
		// since nothing is pointing to it anymore
	}
	public static void main(String args[]) {
		Node first = new Node("Hello");
		first.setNext(new Node("world"));
		first.next().setNext(new Node("!!"));
		removeNode(first.next());
		System.out.println(first.data() + " " + first.next().data());
	}
}
