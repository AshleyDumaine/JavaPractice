import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class ClosestPoints {
	public static Object[] findClosestPoints(Integer[][] pointArray) {
		// stable sort (merge sort) by X values
		Arrays.sort(pointArray, new XComparator());
		// stable sort (merge sort) by Y values
		Arrays.sort(pointArray, new YComparator());
		HashMap<Integer[][], Double> distances = new HashMap<Integer[][], Double>();
		for (int i = 1; i < pointArray.length; i++) {
			double distance = Math.sqrt(
					(int) Math.pow(pointArray[i][0] - pointArray[i-1][0], 2) + 
					(int) Math.pow(pointArray[i][1] - pointArray[i-1][1], 2));
			distances.put(new Integer[][]{pointArray[i-1],  pointArray[i]}, distance);
		}
		Double minDistance = Double.MAX_VALUE;
		Integer[][] pointPair = null;
		for (Map.Entry<Integer[][], Double> entry : distances.entrySet()) {
			if (entry.getValue() < minDistance) {
				minDistance = entry.getValue();
				pointPair = entry.getKey();
			}
		}
		return new Object[]{pointPair, minDistance};
	}
	
	public static void main(String args[]) {
		Integer[][] input = new Integer[][]{{7,9},{9,20},{4,0},{0,1},{5,6}};
		Object[] output = findClosestPoints(input);
		Integer[][] points = (Integer[][]) output[0];
		System.out.println("Points: (" + points[0][0] + "," + points[0][1] +
				"), (" + points[1][0] + "," + points[1][1] + ")");
		System.out.println("Distance: " + output[1]);
	}
}
