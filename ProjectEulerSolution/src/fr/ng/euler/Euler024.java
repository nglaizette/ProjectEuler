package fr.ng.euler;

public class Euler024 {

	private static final int PERMUTATION_NUMBER = 1000000;
	private static final int DIGITSNUMBER = 10;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = initNumber(DIGITSNUMBER);
		permute(0, numbers, 0, PERMUTATION_NUMBER);
	}

	private static int permute(int startIndex, int[] numbers, int counter,
	        int max) {
		if (numbers.length <= startIndex) {

			if (counter % 100 == 0) {
				for (int k : numbers) {
					System.out.print(k);
				}
				System.out.print("-" + (counter + 1));
				System.out.println();
			}

			return counter + 1;
		}

		for (int i = startIndex; i < numbers.length; i++) {
			for (int j = startIndex + 1; j <= i; j++) {
				int temp = numbers[startIndex];
				numbers[startIndex] = numbers[j];
				numbers[j] = temp;
			}

			counter = permute(startIndex + 1, numbers, counter, max);

			for (int j = i; startIndex <= j; j--) {
				int temp = numbers[startIndex];
				numbers[startIndex] = numbers[j];
				numbers[j] = temp;
			}

			if (counter == max) {
				for (int k : numbers) {
					System.out.print(k);
				}
				System.out.println();
				return counter;
			}
		}
		return counter;
	}

	private static int[] initNumber(int digitsnumber2) {
		int[] result = new int[digitsnumber2];
		for (int i = 0; i < digitsnumber2; i++) {
			result[i] = i;
		}
		return result;
	}

}
