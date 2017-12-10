package us.rs.sedgewick;

import fr.ng.sedgewick.utilities.StdRandom;

public class Experiment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 100;
		Double[] a = new Double[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform();
		}

	}
}
