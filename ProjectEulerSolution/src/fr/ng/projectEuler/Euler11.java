package fr.ng.euler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Euler11 {

    public static void main(String[] args) throws FileNotFoundException {

        // new File(".").getAbsolutePath();
        FileReader ff = new FileReader("resources/Grid_File(20X20).txt");
        int[][] num = new int[20][20];
        try (Scanner in = new Scanner(ff)) {
            // reading the numbers into 2D array
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    num[i][j] = in.nextInt();
                }
            }
        }

        int max = 0;
        int currentProduct = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {

                // lignes
                if (i > 3) {
                    currentProduct = num[i - 3][j] * num[i - 2][j] * num[i - 1][j] * num[i][j];
                }
                if (currentProduct > max) {
                    max = currentProduct;
                }
                if (i < 17) {
                    currentProduct = num[i][j] * num[i + 1][j] * num[i + 2][j] * num[i + 3][j];
                }
                if (currentProduct > max) {
                    max = currentProduct;
                }

                // colones
                if (j > 3) {
                    currentProduct = num[i][j - 3] * num[i][j - 2] * num[i][j - 1] * num[i][j];
                }
                if (currentProduct > max) {
                    max = currentProduct;
                }
                if (j < 17) {
                    currentProduct = num[i][j] * num[i][j + 1] * num[i][j + 2] * num[i][j + 3];
                }
                if (currentProduct > max) {
                    max = currentProduct;
                }

                // diag 1

                if (i > 3 && j > 3) {
                    currentProduct = num[i - 3][j - 3] * num[i - 2][j - 2] * num[i - 1][j - 1]
                            * num[i][j];
                }
                if (currentProduct > max) {
                    max = currentProduct;
                }
                if (i < 17 && j < 17) {
                    currentProduct = num[i][j] * num[i + 1][j + 1] * num[i + 2][j + 2]
                            * num[i + 3][j + 3];
                }
                if (currentProduct > max) {
                    max = currentProduct;
                }

                // diag 2
                if (i > 3 && j < 17) {
                    currentProduct = num[i - 3][j + 3] * num[i - 2][j + 2] * num[i - 1][j + 1]
                            * num[i][j];
                }
                if (currentProduct > max) {
                    max = currentProduct;
                }
                if (i < 17 && j > 3) {
                    currentProduct = num[i][j] * num[i + 1][j - 1] * num[i + 2][j - 2]
                            * num[i + 3][j - 3];
                }
                if (currentProduct > max) {
                    max = currentProduct;
                }
            }
        }

        System.out.println("Max product:" + max);
    }
}
