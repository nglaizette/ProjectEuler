package fr.ng.euler;

import java.util.stream.IntStream;

public class Euler003 {

	// The prime factors of 13195 are 5, 7, 13 and 29.
	//
	// What is the largest prime factor of the number 600851475143 ?
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		long n = 600851475143L;
//		// long n = 13195;
//		long lastFactor;
//		if (n % 2 == 0) {
//			lastFactor = 2;
//			n /= 2;
//			while (n % 2 == 0) {
//				n /= 2;
//			}
//		} else {
//			lastFactor = 1;
//		}
//		long factor = 3;
//		double maxFactor = Math.sqrt(n);
//		while (n > 1 && factor <= maxFactor) {
//			if (n % factor == 0) {
//				n /= factor;
//				lastFactor = factor;
//				System.out.println(lastFactor);
//				while (n % factor == 0) {
//					n /= factor;
//					maxFactor = Math.sqrt(n);
//				}
//
//			}
//			factor += 2;
//		}
//
//		if (n == 1) {
//			System.out.println(lastFactor);
//		} else {
//			System.out.println(n);
//		}
//	}
//	
//	    long number = 600851475143L;
//        long bigestDivisor = 1L;
//
//        for (long i = 2; i < Math.sqrt(number); i++) {
//            if (number % i == 0) {
//                number /= i;
//                if (i > bigestDivisor) {
//                    bigestDivisor = i;
//                    System.out.println("Bigest divisor :" + bigestDivisor);
//                }
//            }
//        }
//
//        System.out.println("Bigest divisor :" + number);
//        System.out.println("t divisor :" + bigestDivisor);
//    }

     public static void main(String[] args) {
     long given = 600851475143L;
     int ans = IntStream.rangeClosed(2, (int) Math.sqrt(given)).filter(i -> given % i == 0 &&
     isPrime(i)).max().getAsInt();
     System.out.println(ans);
     }
    
     private static boolean isPrime(int i) {
     return IntStream.rangeClosed(2, (int) Math.sqrt(i)).noneMatch(k -> i%k == 0);
     }
}
