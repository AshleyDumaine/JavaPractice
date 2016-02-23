import java.util.Arrays;

public class Problem50 {
	public static void main(String args[]) {
		int limit = 1000000;
		long result = 0;
		int numberOfPrimes = 0;
		int N = 1000000;
	    boolean[] isPrime = new boolean[N + 1];
	    
	    for (int i = 2; i <= N; i++) {
	        isPrime[i] = true;
	    }
	    
	 // mark non-primes <= N using Sieve of Eratosthenes
	    for (int i = 2; i*i <= N; i++) {
	        // if i is prime, then mark multiples of i as nonprime
	        // suffices to consider mutiples i, i+1, ..., N/i
	        if (isPrime[i]) {
	            for (int j = i; i*j <= N; j++) {
	                isPrime[i*j] = false;
	            }
	        }
	    }
	    
	    
		long[] primes = new long[1000000];
		for (int i = 0; i < 1000; i++) {
			if (isPrime(i)) {
				primes[i] = i;
			}
		}
		long[] primeSum = new long[primes.length+1];
		 
		primeSum[0] = 0;
		for (int i = 0; i < primes.length; i++) {
		    primeSum[i+1] = primeSum[i] + primes[i];
		}
		 
		for (int i = numberOfPrimes; i < primeSum.length; i++) {
		    for (int j = i-(numberOfPrimes+1); j >= 0; j--) {
		        if (primeSum[i] - primeSum[j] > limit) break;
		 
		        if (Arrays.binarySearch(primes, primeSum[i] - primeSum[j]) >= 0) {
		            numberOfPrimes = i - j;
		            result = primeSum[i] - primeSum[j];
		        }
		    }
		}
		System.out.println(result);
	}	

    
	public static boolean isPrime(int i) {
		for (int j = 2; (j * j) <= i; j++) {
			if (i % j == 0) {
				return false;
			}
		}
		System.out.println("prime: " + i);
		return true;
	}
}
