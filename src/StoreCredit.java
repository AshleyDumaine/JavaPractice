import java.util.Arrays;
import java.util.Scanner;

public class StoreCredit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numCases = sc.nextInt();
		for (int i = 0; i < numCases; i++) {
			int maxCredit = sc.nextInt();
			int numItems = sc.nextInt();
			Item[] items = new Item[numItems];
			for (int j = 0; j < numItems; j++) {
				items[j] = new Item(sc.nextInt(), j);
			}
			Arrays.sort(items);
			int start = 0;
			int end = items.length - 1;
			while (start < end) {
				if (items[start].price() + items[end].price() == maxCredit) {
					if ((items[start].index()+1) < (items[end].index()+1)) {
						System.out.println("Case #" + (i+1) + ": " + (items[start].index()+1) + " " + (items[end].index()+1));
					}
					else {
						System.out.println("Case #" + (i+1) + ": " + (items[end].index()+1) + " " + (items[start].index()+1));
					}
					break;
				}
				else if (items[start].price() + items[end].price() > maxCredit) {
					end--;
				}
				else {
					start++;
				}
			}
		}
		sc.close();
	}
}
