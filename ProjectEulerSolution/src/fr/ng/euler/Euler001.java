package fr.ng.euler;

import java.util.stream.IntStream;

public class Euler001 {

	//
	// If we list all the natural numbers below 10 that are multiples of 3 or 5,
	// we get 3, 5, 6 and 9. The sum of these multiples is 23.
	//
	// Find the sum of all the multiples of 3 or 5 below 1000.
	public static void main(String[] args) {
		int somme = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 5 == 0) {
				somme += i;
			} else if (i % 3 == 0) {
				somme += i;
			}
		}

		System.out.println("Somme :" + somme);
	}
	static void run() {
        int sum = IntStream.range(0, 1000).filter(e -> e % 3 == 0 || e % 5 == 0).sum();
        System.out.println("Sum :" + sum);
    }
}
