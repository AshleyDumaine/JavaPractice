package MockExamples;

import java.util.Random;

public class DDOSExample {
	// use a circular array (buffer) which is global to log number of cars at each second for 86400 seconds (24 hours)
	//
	// summing over it gives number of cars seen in the last minute, hour, day
	//
	// every time carPassed() is called, we have to check the current time versus the global last time it was called
	// if it is more than a second difference the slots in between need to be cleared to 0, if it's the same second
	// we need to increment the number of cars
	private int[] carNumArray;
	private int lastCarPassed;
	public DDOSExample() {
		carNumArray = new int[86400];
		lastCarPassed = 0;
	}
	
	public String countCars() {
		int currentTime = (int) (System.currentTimeMillis() / 1000) % 86400;
		clearStaleData(currentTime);
		int lastSecond = sumCarsInPastSeconds(currentTime, 1);
		int lastMinute = sumCarsInPastSeconds(currentTime, 60);
		int lastHour = sumCarsInPastSeconds(currentTime, 60*60);
		int lastDay = sumCarsInPastSeconds(currentTime, 60*60*24);		
		return "Cars in last second: " + lastSecond + "\nCars in last minute: " + lastMinute +
				"\nCars in last hour: " + lastHour + "\nCars in last day: " + lastDay;
	}
	
	public void carPassed() {
		int currentTime = (int) (System.currentTimeMillis() / 1000) % 86400;
		clearStaleData(currentTime);
		carNumArray[currentTime]++;
		lastCarPassed = currentTime;
	}
	
	public int sumCarsInPastSeconds(int currentTime, int seconds) {
		int res = 0;
		for (int i = 0; i < seconds; i++) {
			res += carNumArray[((currentTime - i + 86400) % 86400)];
		}
		return res;
	}
	
	public void clearStaleData(int currentTime) {
		// case 1: currentTime is after lastCarPassed time
		// case 2: currentTime has wrapped around to before lastCarPassed time
		if (currentTime > lastCarPassed) {  // case 1
			for (int i = currentTime; i > lastCarPassed; i--) {
				carNumArray[i] = 0;
			}
		}
		if (currentTime < lastCarPassed) {  // case 2
			for (int i = 0; i < 86400 - (lastCarPassed - currentTime); i++) {
				carNumArray[((currentTime - i + 86400) % 86400)] = 0;
			}
		}
	}
	
	public static void main(String args[]) {
		DDOSExample ex = new DDOSExample();
		while (true) {
			ex.carPassed();
			try {
				Thread.sleep(new Random().nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int currentTime = (int) (System.currentTimeMillis() / 1000) % 86400;
			if (currentTime % 20 == 0) { //every 5 seconds print out counts
				System.out.println("\n\n\n\n\n" + ex.countCars());
			}
		}
	}
}
