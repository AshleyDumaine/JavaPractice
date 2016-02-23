import java.util.Arrays;


public class CanSumTo2 {
// if 2 elements in the array can sum to another in the array
	public static boolean canSumTo(int[] array) {
		Arrays.sort(array);
		System.out.println(Arrays.toString(array)); //debug
		int start = 0;
		int end  = array.length - 1;
		while (array[start] < array[end]) {
			int sum = array[start] + array[end];
			if (Arrays.asList(array).contains(sum)) {
				return true;
			}
			else {
				if (array[start + 1] - array[start] > array[end] - array[end - 1]) end--;
				else start++;
			}
		}
		return false;
		
	}
	
	public static void main(String args[]) {
		int[] array = {1, 4, 2, 9, 5};
		System.out.println(canSumTo(array));
	}
}
