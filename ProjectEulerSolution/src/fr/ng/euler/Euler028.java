package fr.ng.euler;

public class Euler028 {
	static int size = 1001;
	static int[][] grid = new int[size][size];

	// Starting with the number 1 and moving to the right in a clockwise
	// direction a 5 by 5 spiral is formed as follows:
	//
	// 21 22 23 24 25
	// 20 7 8 9 10
	// 19 6 1 2 11
	// 18 5 4 3 12
	// 17 16 15 14 13
	//
	// It can be verified that the sum of the numbers on the diagonals is 101.
	//
	// What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
	// formed in the same way?
	public static void main(String[] args) {

		methode1();
		drawSpiral();
	}

	private static void drawSpiral() {
		int numberToBeInserted = 1;

		// Compute the center of the grid
		int center = size / 2;
		int x = center;
		int y = center;

		// insert 1 at the center
		grid[x][y] = numberToBeInserted;

		// insert 2 one cell to he right of 1
		numberToBeInserted++;
		grid[center][center + 1] = numberToBeInserted;
		// update x and y;
		x = center + 1;
		y = center;

		numberToBeInserted++;

	}

	private static void methode1() {
		int size = 1001;

		int somme = 1;
		int initial = 1, difference = 2;
		for (int i = 3; i <= size; i += 2) {
			for (int j = 1; j < 5; j++) {
				initial += difference;
				somme += initial;
			}

			difference += 2;
		}

		System.out.println("somme :" + somme);
	}
}
