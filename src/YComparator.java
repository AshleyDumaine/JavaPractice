import java.util.Comparator;

public class YComparator implements Comparator<Integer[]> {

	@Override
	public int compare(Integer[] o1, Integer[] o2) {
		if (o1[1] > o2[1]) {
			return 1;
		}
		else if (o1[1] < o2[1]) {
			return -1;
		}
		return 0;
	}	
}