import java.util.HashSet;

public class CanSumTo {
	public static boolean canSumTo(int[] numbers, int sum) {
		// store the differences between the sum and each number in a set
		HashSet<Integer> set = new HashSet<Integer>();
		for (int num : numbers) {
			set.add(sum - num);
		}
		for (int num : numbers) {
			if (set.contains(num)) {
				return true;
			}
		}
		return false;
	}

	//driver program
	public static void main(String[] args) {
		int[] nums = {5, 6, 2, 9, 4, 15};
		boolean res = canSumTo(nums, 24);
		System.out.println(res);
	}
}
