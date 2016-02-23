import java.util.Arrays;

// Returns true if there is a subset of set[] with sun equal to given sum
public class SubsetSumProblem {
	public static Boolean isSubsetSum(int set[], int n, int sum)
	{
		// Base Cases
		if (set.length < 3)
			return false;
		if (Arrays.asList(set).contains(sum))
			return true;

		// If last element is greater than sum, then ignore it
		if (set[n-1] > sum)
			return isSubsetSum(set, n-1, sum);

		/* else, check if sum can be obtained by any of the following
      (a) including the last element
      (b) excluding the last element   */
		return isSubsetSum(set, n-1, sum) || isSubsetSum(set, n-1, sum-set[n-1]);
	}

	// Driver program to test above function
	public static void main(String args[]) {
		int set[] = {1, 1, 2, 4};
		int n = set.length;
		Arrays.sort(set);
		for (int i = 0; i < n; i++) {
			if (isSubsetSum(set, n, set[i]) == false) {
				System.out.println("No subset with given sum");
				System.exit(0);
			}
		}
		System.out.println("No subset with given sum");
	}
}