package fr.ng.sedgewick.union;

import java.util.Arrays;

import fr.ng.sedgewick.utilities.StdDraw;
import fr.ng.sedgewick.utilities.StdRandom;

public class NGTestDraw {

	public static void main(String[] args) {
		int n = 50;
		double[] a = new double[n];
		for (int i = 0; i < n; i++) {
			a[i] = StdRandom.uniform();
		}

		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			double x = 1.0 * i / n;
			double y = a[i] / 2;
			double rw = 0.5 / n;
			double rh = a[i] / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
}
