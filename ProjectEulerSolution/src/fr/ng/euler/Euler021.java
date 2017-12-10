package fr.ng.euler;

public class Euler021 {

	// Let d(n) be defined as the sum of proper divisors of n (numbers less than
	// n which divide evenly into n).
	// If d(a) = b and d(b) = a, where a � b, then a and b are an amicable pair
	// and each of a and b are called amicable numbers.
	//
	// For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22,
	// 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1,
	// 2, 4, 71 and 142; so d(284) = 220.
	//
	// Evaluate the sum of all the amicable numbers under 10000.
	/**
	 * @param args
	 */
	public static int NUMBER_MAX = 10000;

	public static void main(String[] args) {

		long sumOfAmicable = 0L;
		for (int i = 0; i < NUMBER_MAX; i++) {
			if (isAmicable(i)) {
				sumOfAmicable += i;
			}
		}

		System.out.println(Long.toString(sumOfAmicable));

		long sum = 0L;
		int[] listOfDivisorSum = buildList(NUMBER_MAX);
		for (int i = 0; i < listOfDivisorSum.length; i++) {
			for (int j = 0; j < listOfDivisorSum.length; j++) {
				if (listOfDivisorSum[i] == j && listOfDivisorSum[j] == i
				        && i != j) {
					sum += i;
				}
			}
		}
		System.out.println(Long.toString(sum));
	}

	private static boolean isAmicable(int n) {
		int m = divisorSum(n);
		return m != n && divisorSum(m) == n;
	}

	private static int divisorSum(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		return sum;
	}

	private static int[] buildList(int numberMax) {
		int[] list = new int[numberMax];
		for (int i = 0; i < list.length; i++) {
			int sumOfdivisor = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					sumOfdivisor += j;
				}
			}
			list[i] = sumOfdivisor;
		}
		return list;
	}
}
