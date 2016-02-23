
public class Example {
		public static Integer commonNode(SinglyLinkedList first, SinglyLinkedList second) {
			
			int[] firstArray = new int[first.getSize()];
			int[] secondArray = new int[second.getSize()];
			Node current1 = first.head();
			Node current2 = second.head();
			
			// put lists into arrays
			for (int i =0; i < firstArray.length; i++) {
				firstArray[i] = (Integer) current1.data();
				System.out.println(firstArray[i]);
				current1 = current1.next();
			}
			for (int i = 0; i < secondArray.length; i++) {
				secondArray[i] = (Integer) current2.data();
				System.out.println(secondArray[i]);
				current2 = current2.next();
			}
			
			for (int i = 0; i < firstArray.length; i++) {
				for (int j = 0; j < secondArray.length; j++) {
					if (firstArray[i] == secondArray[j]) {
						return firstArray[i];
					}
				}
			}
			// no common node
			return null;
		}
		public static void main(String args[]) {
			SinglyLinkedList first = new SinglyLinkedList();
			SinglyLinkedList second = new SinglyLinkedList();
			first.addLast(new Node(1));
			first.addLast(new Node(2));
			first.addLast(new Node(3));
			second.addLast(new Node(4));
			second.addLast(new Node(2));
			second.addLast(new Node(3));
			System.out.println(commonNode(first, second));
			
		}
}
