package fr.ng.projectEuler;

public class Project004 {
	// A palindromic number reads the same both ways. The largest palindrome
	// made from the product of two 2-digit numbers is 9009 = 91 × 99.
	//
	// Find the largest palindrome made from the product of two 3-digit numbers.
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int largestPalingdrome = 0;
		int a = 999;

		while (a >= 100) {
			int b = 999;
			while (b >= a) {
				if (a * b <= largestPalingdrome) {
					break; // Since a*b is always going to be too small
				}

				if (isPalindrome(a * b)) {
					largestPalingdrome = a * b;
				}
				b--;
			}
			a--;
		}
		System.out.println(largestPalingdrome);
	}

	private static boolean isPalindrome(int n) {
		return (n == reverse(n));
	}

	private static int reverse(int n) {
		int reversed = 0;
		while (n > 0) {
			reversed = 10 * reversed + n % 10;
			n = n / 10;
		}
		return reversed;
	}
}
