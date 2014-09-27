package fr.ng.projectEuler;

public class ProjectX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// BigInteger findPrime = new BigInteger("600851475143");
		// BigInteger i = BigInteger.ONE;
		// i.add(new BigInteger("1"));
		// System.out.println(i + ", ");
		//
		// for (; i.compareTo(findPrime.divide(new BigInteger("2"))) < 0; i = i
		// .subtract(BigInteger.ONE)) {
		// if (findPrime.remainder(i).compareTo(BigInteger.ZERO) == 0) {
		// System.out.println(i + ", ");
		// }
		// }

		Long findPrime = 600851475143L;
		Long i = 1L;
		System.out.println(i + ", ");

		for (; i < findPrime / 2; i += 2) {
			if (findPrime % i == 0) {
				System.out.println(i + ", ");
			}
		}

		System.out.println("end");
	}
}
