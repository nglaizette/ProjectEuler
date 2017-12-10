package fr.ng.euler;

import java.util.ArrayList;
import java.util.List;

public class Euler023 {
	private final static int MAX = 28123;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> numberNotToSum = new ArrayList<Integer>();

		List<Integer> abundantNumbers = getAbundantNumber(MAX);
		for (int i = 1; i < MAX; i++) {
			if (!isSumOfTwoElements(i, abundantNumbers)) {
				numberNotToSum.add(i);
			}
		}

		int result = 0;
		for (Integer integer : numberNotToSum) {
			result += integer;
		}

		System.out.println("Result=" + result);

	}

	private static List<Integer> getAbundantNumber(int number) {
		ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
		for (int i = 1; i < number; i++) {
			if (isAbundant(i)) {
				abundantNumbers.add(i);
			}
		}
		return abundantNumbers;
	}

	private static boolean isAbundant(int number) {
		return number < divisorSum(number);
	}

	private static int divisorSum(int number) {
		int sum = 0;
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				sum += i;
			}
		}
		return sum;
	}

	private static boolean isSumOfTwoElements(int number,
	        List<Integer> abundantNumbers) {

		boolean isSumOfTwoItems = false;
		for (int i = 0; i < abundantNumbers.size(); i++) {
			int lower = abundantNumbers.get(i);
			for (int j = abundantNumbers.size() - 1; i <= j; j--) {
				int upper = abundantNumbers.get(j);

				if (number < 2 * lower || 2 * upper < number) {
					break;
				}

				if (lower + upper == number) {
					System.out.printf("%d = %d + %d\n", number, lower, upper);
					isSumOfTwoItems = true;
					break;
				}

				if (number < 2 * lower || isSumOfTwoItems) {
					break;
				}
			}
		}
		return isSumOfTwoItems;
	}

}
