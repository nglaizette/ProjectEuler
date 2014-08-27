/* 
 * Shared code for solutions to Project Euler problems
 * By Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/project-euler-solutions
 * https://github.com/nayuki/Project-Euler-solutions
 */
package fr.ng.projectEuler.utilities;

import java.math.BigInteger;

final public class Library {

	/**
	 * Returns the reverse of the given string
	 */
	public static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	/**
	 * Test wheter the given string is a palindrome.
	 */
	public static boolean isPalindrome(String s) {
		return s.equals(reverse(s));
	}

	/**
	 * Test wheter the given integer is a palindrome in decimal
	 */
	public static boolean isPalindrome(int x) {
		return isPalindrome(Integer.toString(x));
	}

	/**
	 * Test whether x is a perfect square.
	 */
	public static boolean isSquare(int x) {
		if (x < 0) {
			return false;
		} else {
			int sqrt = sqrt(x);
			return sqrt * sqrt == x;
		}
	}

	/**
	 * Returns x to the power of y.
	 */
	public static int pow(int x, int y) {
		if (y < 0) {
			throw new IllegalArgumentException("Negative exponent");
		}
		int z = 1;
		for (int i = 0; i < y; i++) {
			if (Integer.MAX_VALUE / z < x) {
				throw new ArithmeticException("Overflow");
			}
			z *= x;
		}
		return z;
	}

	/**
	 * Returns x^y mod m ????
	 */
	public static int powMod(int x, int y, int m) {
		if (x < 0) {
			throw new IllegalArgumentException("Negative base not handled");
		}
		if (y < 0) {
			throw new IllegalArgumentException("Reciprocal not handled");
		}

		if (m <= 0) {
			throw new IllegalArgumentException("Invalid modulus");
		} else if (m == 1) {
			return 0;
		} else {

			// Exponentiation by squaring
			int z = 1;
			while (y != 0) {
				if ((y & 1) != 0) {
					z = (int) ((long) z * x % m);
				}
				x = (int) ((long) x * x % m);
				y >>>= 1;
			}
			return z;
		}
	}

	/**
	 * Returns n!
	 */
	public static BigInteger factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Factorial of a negative number");
		}

		BigInteger prod = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			prod = prod.multiply(BigInteger.valueOf(i));
		}
		return prod;
	}

	/**
	 * Return n choose k
	 */
	public static BigInteger binomial(int n, int k) {
		return factorial(n).divide(factorial(n - k).multiply(factorial(k)));
	}

	/**
	 * Return the largest non-negative integer that divides both x and y.
	 */
	public static int gcd(int x, int y) {
		while (y != 0) {
			int z = x % y;
			x = y;
			y = z;
		}
		return x;
	}

	/**
	 * Test whether the given integer is prime
	 */
	public static boolean isPrime(int x) {
		if (x < 0) {
			throw new IllegalArgumentException("Negative Number");
		}
		if (x == 0 || x == 1) {
			return false;
		} else if (x == 2) {
			return true;
		} else if (x % 2 == 0) {
			return false;
		} else {

			for (int i = 3; i <= sqrt(x); i += 2) {
				if (x % i == 0) {
					return false;
				}
			}

			return true;

		}
	}

	/**
	 * Returns a Boolean array 'isPrime' where isPrime[i] indicates whether i is
	 * prime, for 0 <= i <= n.
	 * 
	 * For a large batch of queries, this is faster than calling isPrime() for
	 * each integer.
	 * 
	 * For example: listPrimality(100)={false, false,true, true, false, true,
	 * false, true, false, false ...}.
	 */
	public static boolean[] listPrimality(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Negative size");
		}
		boolean[] prime = new boolean[n + 1];
		if (n >= 2) {
			prime[2] = true;
		}
		for (int i = 3; i <= n; i += 2) {
			prime[i] = true;
		}

		// Sieve of Eratoshenes
		for (int i = 3; i <= sqrt(n); i += 2) {
			if (prime[i]) {
				for (int j = i * i; j <= n; j += i << 1) {
					prime[j] = false;
				}
			}
		}
		return prime;
	}

	/**
	 * Returns all the prime numbers less than or equal to n, in ascending
	 * order. For example: listPrimes(100) = {2, 3, 5, 7, 11, 13, 17, 19, 23,
	 * 29, ... , 83, 89, 97}.
	 */
	public static int[] listPrimes(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Negative size");
		}

		boolean[] isPrime = listPrimality(n);
		int count = 0;
		for (boolean b : isPrime) {
			if (b) {
				count++;
			}
		}

		int[] primes = new int[count];
		for (int i = 0, j = 0; i < isPrime.length; i++) {
			if (isPrime[i]) {
				primes[j] = i;
				j++;
			}
		}

		return primes;

	}

	/**
	 * Returns an array smallprimeFactor[k] of k, valid for 0 <= k <= n. For
	 * example: listSmallestPrimeFactor(10)={0,0,2,3,2,5,2,7,2,3,2}.
	 */
	public static int[] listSmallestPrimeFactors(int n) {
		int[] result = new int[n + 1];
		for (int i = 2; i < result.length; i++) {
			if (result[i] == 0) {
				result[i] = i;

				if ((long) i * i <= n) {
					for (int j = i * i; j <= n; j += i) {
						if (result[j] == 0) {
							result[j] = i;
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * Returns the number of integers in the range [1,n] that are coprime with
	 * n.
	 * 
	 * For example, totient(12) = 4 because these integers are coprime with 12:
	 * 1, 5, 7, 11.
	 */
	public static int totient(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Totent of non-positive integer");
		}
		int p = 1;
		for (int i = 2, end = sqrt(n); i <= end; i++) {
			if (n % i == 0) {// Found a factor
				p *= i - 1;
				n /= i;
				while (n % i == 0) {
					p *= i;
					n /= i;
				}
				end = sqrt(n);
			}
		}

		if (n != 1) {
			p *= n - 1;
		}
		return p;
	}

	/**
	 * Returns an array 'totients' where totients[i] == totient(i), for 0<=
	 * i<=n. For a large batch of queries, this is faster than calling totient()
	 * for each integer.
	 */
	public static int[] listTotients(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Negative size");
		}

		int[] totients = new int[n + 1];
		for (int i = 0; i < totients.length; i++) {
			totients[i] = i;
		}

		for (int i = 2; i < totients.length; i++) {
			if (totients[i] == i) {// i is prime
				for (int j = i; j < totients.length; j += i) {
					totients[j] = totients[j] / i * (i - 1);
				}
			}
		}

		return totients;
	}

	/**
	 * Returns the same result as x.multiply(y), but is faster for large
	 * integers.
	 */
	public static BigInteger multiply(BigInteger x, BigInteger y) {
		final int CUTOFF = 1536;
		if (x.bitLength() <= CUTOFF || y.bitLength() <= CUTOFF) {// Base case
			return x.multiply(y);
		} else { // Karatsuba fast multiplication
			int n = Math.max(x.bitLength(), y.bitLength());
			int half = (n + 32) / 64 * 32;
			BigInteger mask = BigInteger.ONE.shiftLeft(half).subtract(
			        BigInteger.ONE);
			BigInteger xlow = x.and(mask);
			BigInteger xhigh = x.shiftRight(half);

			BigInteger ylow = y.and(mask);
			BigInteger yhigh = y.shiftRight(half);

			BigInteger a = multiply(xhigh, yhigh);
			BigInteger b = multiply(xlow.add(xhigh), ylow.add(yhigh));
			BigInteger c = multiply(xlow, ylow);
			BigInteger d = b.subtract(a).subtract(c);
			return a.shiftLeft(half).add(d).shiftLeft(half).add(c);
		}
	}

	// --?????????????????
	/**
	 * Returns x^-1 mod m. ????? Note that x * x^-1 mod m = x^-1 * x mod m = 1
	 */
	public static int reciprocalMod(int x, int m) {
		if (m < 0 || x < 0 || x >= m) {
			throw new IllegalArgumentException();
		}

		// Based on a simplification of the extended Euclidean algorithm
		int y = x;
		x = m;
		int a = 0;
		int b = 1;
		while (y != 0) {
			int z = x % y;
			int c = a - x / y * b;
			x = y;
			y = z;
			a = b;
			b = c;
		}

		if (x == 1) {
			return (a + m) % m;

		} else {
			throw new IllegalArgumentException("Reciprocal does not exist");
		}
	}

	/**
	 * } Returns floor(sqrt(x)). ????
	 */
	public static long sqrt(long x) {
		if (x < 0) {
			throw new IllegalArgumentException("Square root of negative number");
		}
		long y = 0;
		for (long i = 1L << 31; i != 0; i >>>= 1) {
			y |= i;
			if (y > 3037000499L || y * y > x) {
				y ^= i;
			}
		}
		return y;
	}

	/**
	 * Returns floor(sqrt(x)). ?????
	 */
	public static int sqrt(int x) {
		if (x < 0) {
			throw new IllegalArgumentException("Square root of negative number");
		}
		int y = 0;
		for (int i = 32768; i != 0; i >>>= 1) {
			y |= i;
			if (y > 46340 || y * y > x) {
				y ^= i;
			}

		}
		return y;
	}
}
