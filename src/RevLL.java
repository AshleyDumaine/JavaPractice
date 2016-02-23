public class RevLL {
	public static Node reverseLinkedList(Node node) {
		if (node == null || node.next() == null) {
			return node;
		}
		Node temp = node.next();
		node.setNext(null);
		Node rev = reverseLinkedList(temp);
		//make the next pointer of the next point back to node
		temp.setNext(node);
		return rev;
	}
	//driver program
	public static void main(String args[]) {
		SinglyLinkedList intList = new SinglyLinkedList();
		for (int i = 0; i < 5; i++) {
			Node node = new Node(i, null);
			intList.addLast(node); //tack stuff onto end
		}
		Node rev = reverseLinkedList(intList.head());
		while (rev != null) {
			System.out.print(rev.data() + " ");
			rev = rev.next();
		}
	}
}
