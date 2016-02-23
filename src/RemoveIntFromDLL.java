public class RemoveIntFromDLL {
	public static void removeInt(Node node, int value) {
		Node current = node;
		while (current != null) {
			if ((Integer)current.data() == value) {
				if (current.next() != null) current.next().setPrev(current.prev());
				if (current.prev() != null) current.prev().setNext(current.next());
				break;
			}
			current = current.next();
			
		}
	}

	//driver program
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();	
		dll.addFirst(new Node(1));
		dll.addFirst(new Node(2));
		dll.addFirst(new Node(3));
		dll.addFirst(new Node(4));
		dll.addFirst(new Node(5));
		dll.addFirst(new Node(6));
		removeInt(dll.getFirst(), 3);
		Node root = dll.getFirst();
		while (root != null) {
			System.out.println((Integer)root.data());
			root = root.next();
		}
	}
}
