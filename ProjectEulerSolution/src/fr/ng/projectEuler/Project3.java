package fr.ng.projectEuler;

public class Project3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long n = 600851475143L;
		// long n = 13195;
		long lastFactor;
		if (n % 2 == 0) {
			lastFactor = 2;
			n /= 2;
			while (n % 2 == 0) {
				n /= 2;
			}
		} else {
			lastFactor = 1;
		}
		long factor = 3;
		double maxFactor = Math.sqrt(n);
		while (n > 1 && factor <= maxFactor) {
			if (n % factor == 0) {
				n /= factor;
				lastFactor = factor;
				System.out.println(lastFactor);
				while (n % factor == 0) {
					n /= factor;
					maxFactor = Math.sqrt(n);
				}

			}
			factor += 2;
		}

		if (n == 1) {
			System.out.println(lastFactor);
		} else {
			System.out.println(n);
		}
	}
}
