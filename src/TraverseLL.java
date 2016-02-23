import java.util.LinkedList;
import java.util.ListIterator;

public class TraverseLL {
	public static void main(String args[]) {
		LinkedList<String> list = new LinkedList<String>();
	    list.add("eBay");
	    list.add("Paypal");
	    list.add("Google");
	    list.add("Yahoo");
	    list.add("IBM");
	    list.add("Facebook");
	    traverse(list);
	    findMiddle(list);
	}
	
	public static void traverse(LinkedList<String> list) {
		ListIterator<String> iterator = list.listIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public static void findMiddle(LinkedList<String> list) {
		int size = list.size();
		if (size % 2 == 1)
			System.out.println("Middle element: " + list.get((int) size/2));
		else
			System.out.println("Middle elements: " + list.get((int) size/2 - 1) + ", " + list.get((int) size/2));
	}
}
