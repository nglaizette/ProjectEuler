package fr.ng.euler;

public class Euler4 {
    public static void main(String[] args) {
        Long product = Long.valueOf(1);
        for (int i = 100; i < 1_000; i++) {
            for (int j = i; j < 1_000; j++) {
                Long d = Long.valueOf(i * j);
                StringBuilder toto = new StringBuilder(d.toString());
                if (toto.reverse().toString().equals(d.toString()) && d.compareTo(product) > 0) {
                    product = d;
                }
            }
        }

        System.out.println(product.intValue());
    }
}
