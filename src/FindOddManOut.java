import java.util.Hashtable;
public class FindOddManOut {
	public static int findOddManOut(int[] array) {
		Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < array.length; i ++) {
			if (hash.get(array[i]) == null) {
				hash.put(array[i], 1);
				sum += array[i];
			}	
			else sum -= array[i];
		}
		return sum;
	}
	
	public static int smartMethod(int[] array) {
		int val = 0;
		for(int i = 0; i < array.length; i++) {
			val ^= array[i];
		}
		return val;
	}

	//driver program
	public static void main(String[] args) {
		int[] array = {9, 4, 7, 5, 3, 4, 3, 5, 9};
		int res = smartMethod(array);
		System.out.println(res);
	}
}
