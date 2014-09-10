package fr.ng.sedgewick.percolation;

import us.rs.sedgewick.union.WeightedQuickUnionUF;

public class Percolation {
	// 0-closed, 1-open
	private final int[] grid;
	private final int size;
	private final WeightedQuickUnionUF cellStorage;

	/**
	 * create N-by-N grid, with all sites blocked
	 */
	public Percolation(int N) {
		// +2 are for additional top and bottom cells
		grid = new int[N * N + 2];
		size = N;
		for (int i = 0; i < grid.length; i++) {
			grid[i] = 0;
		}
		grid[N * N] = 1;
		grid[N * N + 1] = 1;

		cellStorage = new WeightedQuickUnionUF(N * N + 2);
	}

	/**
	 * open site (row i, column j) if it is not already
	 * 
	 * @param i
	 * @param j
	 */
	public void open(int i, int j) {
		checkPosition(i, j);
		if (isOpen(i, j)) {
			return;
		}
		int cellindex = getCellIndex(i, j);
		grid[cellindex] = 1;

		// if not top row
		if (i != 1 && isOpen(i - 1, j)) {
			union(getCellIndex(i - 1, j), cellindex);
		} else if (i == 1) {
			// connect to virtual top cell
			union(cellindex, size);
		}

		// if not bottom row
		if (i != size && isOpen(i + 1, j)) {
			union(getCellIndex(i + 1, j), cellindex);
		} else if (i == size) {
			// connect to virtual bottom cell
			union(cellindex, size * size + 1);
		}

		// if not left border
		if (j != 1 && isOpen(i, j - 1)) {
			union(getCellIndex(i, j - 1), cellindex);
		}

		// if not right border
		if (j != size && isOpen(i, j + 1)) {
			union(getCellIndex(i, j + 1), cellindex);
		}
	}

	private int getCellIndex(int i, int j) {
		return (size * (i - 1)) + j - 1;
	}

	private void checkPosition(int i, int j) {
		if (i <= 0 || j <= 0 || i > size || j > size) {
			throw new IndexOutOfBoundsException();
		}
	}

	private void union(int i, int j) {
		if (!cellStorage.connected(i, j)) {
			cellStorage.union(i, j);
		}
	}

	/**
	 * is site(row i, column j) open?
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean isOpen(int i, int j) {
		checkPosition(i, j);
		return grid[getCellIndex(i, j)] == 1;
	}

	/**
	 * is site(row i, column j) full?
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean isFull(int i, int j) {
		checkPosition(i, j);
		return cellStorage.connected(size * size, getCellIndex(i, j));
	}

	/**
	 * does the system percolate?
	 * 
	 * @return
	 */
	public boolean percolates() {
		return cellStorage.connected(size * size, size * size + 1);
	}
}
