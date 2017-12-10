package fr.ng.euler;

import java.util.Random;

public class Euler613 {
    private static final long TOTAL_NUMBER = 10_000_000L;

    private static final int Y = 30;

    private static final int X = 40;

    private static final int NUMBER_OF_EXPERIMENTS = 100;

    public static void main(String[] args) {

        int i = 0;

        double sum = 0;

        Random rand = new Random(System.currentTimeMillis());
        while (i < NUMBER_OF_EXPERIMENTS) {
            long count = 0L;
            long n = 1;
            while (n < TOTAL_NUMBER) {

                double r1 = rand.nextDouble();
                double r2 = rand.nextDouble();

                double xn = r2 * Math.sqrt(r1) * X;
                double yn = Math.sqrt(r1) * (1 - r2) * Y;

                double alpha = computeAngle(xn, yn);

                double theta = rand.nextDouble() * 2 * Math.PI;

                if (theta <= alpha) {
                    count++;
                }

                n++;
            }
            double experimentproba = (1.0 * count / (TOTAL_NUMBER));
            System.out.println(i + ": " + experimentproba);
            sum += experimentproba;
            i++;
        }

        System.out.println("Guessed proba: " + (sum / NUMBER_OF_EXPERIMENTS));
    }

    private static double computeAngle(double xn, double yn) {
        return (Math.PI / 2 + Math.atan(yn / (X - xn)) + Math.atan(xn / (Y - yn)));
    }
}
