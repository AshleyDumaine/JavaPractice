import java.util.Comparator;

public class XComparator implements Comparator<Integer[]> {

	@Override
	public int compare(Integer[] o1, Integer[] o2) {
		if (o1[0] > o2[0]) {
			return 1;
		}
		else if (o1[0] < o2[0]) {
			return -1;
		}
		return 0;
	}
}