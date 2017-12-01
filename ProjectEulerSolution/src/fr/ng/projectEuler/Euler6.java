/*
 * Copyright (C) @year@ by me.
 * All rights reserved.
 *
 */
package fr.ng.euler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * Euler46:
 * <p>
 * Created on 22 nov. 2017
 *
 * @author NG
 */
public class Euler46 {
    private static List<Long> primeNumber = new ArrayList<>();

    private static List<Long> squareNumber = new ArrayList<>();

    public static void main(String[] args) {
        long maxValue = 1000000;// Long.MAX_VALUE;
        long squareMax = Double.valueOf(Math.sqrt(maxValue)).longValue();
        boolean found = false;
        long n = 3L;
        primeNumber.add(1L);
        primeNumber.add(2L);
        squareNumber.add(1L * 1);
        squareNumber.add(1L * 1 + 2 * 1 + 1);
        while (!found && n < maxValue) {

            if (isprime(n)) {
                primeNumber.add(n);

            }
            else {
                if (isSumOfAprimeAndTwice(n)) {
                    // found = true;
                    System.out.println("Found :" + n);
                }
            }
            if (n < squareMax) {
                squareNumber.add(n * n);
                squareNumber.add(n * n + 2 * n + 1);
            }
            n = n + 2;
        }
    }

    private static boolean isSumOfAprimeAndTwice(long n) {
        List<Long> list = primeNumber.stream().map(e -> (n - e) / 2).collect(Collectors.toList());
        return list.stream().filter(squareNumber::contains).collect(Collectors.toList()).isEmpty();
    }

    private static boolean isprime(long n) {
        return !primeNumber.stream().filter(e -> e.longValue() != 1).map(e -> n % e)
                .filter(e -> e.longValue() == 0).findFirst().isPresent();
    }
}
