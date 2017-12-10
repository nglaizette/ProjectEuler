/* Copyright (C) @year@ by ME.
 * All rights reserved.
 *
 */
package fr.ng.euler;

/**
 * <p>
 * Euler14:
 * <p>
 * Created on 23 nov. 2017
 *
 * @author NG
 */
public class Euler014 {
    public static void main(String[] args) {
        int longuest = 0;
        int longusestValue = 0;
        for (int i = 2; i < 1000000; i++) {
            long p = i;
            int n = 1;
            if (i % 1000 == 0) {
                System.out.println(i + ":");
            }
            while (p > 1) {
                if (p % 2 == 0) {
                    p = p / 2;
                }
                else {
                    p = 3 * p + 1;
                }
                // System.out.print(" " + p);
                n++;
            }
            // System.out.print("(" + n + ")\n");
            if (n > longuest) {
                longuest = n;
                longusestValue = i;
            }
        }
        System.out.println("Number : " + longusestValue + " longueur: " + longuest);
    }
}
