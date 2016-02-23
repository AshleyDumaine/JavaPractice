public class Lyft {
	/*
	 * Calculate the detour distance between two different rides. Given
	 * four latitude / longitude pairs, where driver one is traveling from
	 * point A to point B and driver two is traveling from point C to point
	 * D, write a function (in your language of choice) to calculate the
	 * shorter of the detour distances the drivers would need to take to
	 * pick-up and drop-off the other driver.
	 *
	 * Find if A-CD-B (driver 1 picks and drops off driver 2)
	 * or C-AB-D (driver 2 picks up and drops off driver 1) is shorter
	 * Use the Haversine formula
	 */
	public static void main(String args[]) {
		System.out.println(findShorterPath("(37.4, -121.5), (37.1, -121.9), (36.4, -120.9), (36.7, -121.3)"));
	}
	
	public static String findShorterPath(String input) {
		// turn input into coordinate array
		String[] coordinates = input.replaceAll("[(),]", "").split("\\s+");
		LatLong A = new LatLong(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]));
		LatLong B = new LatLong(Double.parseDouble(coordinates[2]), Double.parseDouble(coordinates[3]));
		LatLong C = new LatLong(Double.parseDouble(coordinates[4]), Double.parseDouble(coordinates[5]));
		LatLong D = new LatLong(Double.parseDouble(coordinates[6]), Double.parseDouble(coordinates[7]));
		double distAToB = calculateDistance(A, B);
		double distCToD = calculateDistance(C, D);
		System.out.println("A-B in miles: " + distAToB);
		System.out.println("C-D in miles: " + distCToD);
		if (distAToB > distCToD) {
			return "Driver 1 should pick up and drop off Driver 2.";
		}
		if (distAToB < distCToD) {
			return "Driver 2 should pick up and drop off Driver 1.";
		}
		return "Either driver can pick up and drop off the other.";
	}

	public static double calculateDistance(LatLong start, LatLong end) {
		final double earthRadius = 3963.1676;
		double startLat = Math.toRadians(start.latitude());
		double endLat = Math.toRadians(end.latitude());
		double diffLat = Math.toRadians(end.latitude() - start.latitude());
		double diffLong = Math.toRadians(end.longitude() - start.longitude());
		return 2 * earthRadius * 
				Math.asin(
						Math.sqrt(
								Math.pow(Math.sin(diffLat / 2), 2) +
								Math.cos(startLat) * Math.cos(endLat) * Math.pow(Math.sin(diffLong / 2), 2)
								)
						);
	}
}
