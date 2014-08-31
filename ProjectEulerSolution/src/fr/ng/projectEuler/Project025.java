package fr.ng.projectEuler;

import java.math.BigInteger;

public class Project025 {
	// The Fibonacci sequence is defined by the recurrence relation:
	//
	// Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
	// Hence the first 12 terms will be:
	//
	// F1 = 1
	// F2 = 1
	// F3 = 2
	// F4 = 3
	// F5 = 5
	// F6 = 8
	// F7 = 13
	// F8 = 21
	// F9 = 34
	// F10 = 55
	// F11 = 89
	// F12 = 144
	// The 12th term, F12, is the first term to contain three digits.
	//
	// What is the first term in the Fibonacci sequence to contain 1000 digits?

	private static final int DIGITS = 1000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int i = 3;
		BigInteger fNMinusOne = BigInteger.ONE; // F1
		BigInteger fNMinusTwo = BigInteger.ONE; // F2
		BigInteger fN = fNMinusOne.add(fNMinusTwo);
		BigInteger limit = BigInteger.TEN.pow(DIGITS - 1);// As soon as we are
		                                                  // above this limit we
		                                                  // have DIGITS digits.

		while (fN.compareTo(limit) < 0) {
			fNMinusTwo = fNMinusOne;
			fNMinusOne = fN; // F1
			fN = fNMinusOne.add(fNMinusTwo);
			i++;
		}

		System.out.println(Integer.toString(i) + ": " + fN);
	}
}
