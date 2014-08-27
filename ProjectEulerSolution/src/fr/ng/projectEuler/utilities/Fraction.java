package fr.ng.projectEuler.utilities;

import java.math.BigInteger;

public class Fraction {

	private final BigInteger numerator; // Always coprime with denominator
	private final BigInteger denominator; // Always positive

	/**
	 * Immutable unlimited precision fraction
	 * 
	 * @param num
	 * @param denom
	 */
	public Fraction(BigInteger num, BigInteger denom) {
		if (denom.signum() == 0) {
			throw new ArithmeticException("Division by zero");
		}

		// Reduce to canonical form
		if (denom.signum() == -1) {
			num = num.negate();
			denom = denom.negate();
		}

		BigInteger gcd = num.gcd(denom);
		if (!gcd.equals(BigInteger.ONE)) {
			num = num.divide(gcd);
			denom = denom.divide(gcd);
		}

		this.numerator = num;
		this.denominator = denom;
	}

	public Fraction add(Fraction other) {
		BigInteger num = numerator.multiply(other.getDenominator()).add(
		        other.getNumerator().multiply(denominator));
		BigInteger den = denominator.multiply(other.getDenominator());
		return new Fraction(num, den);
	}

	public Fraction substract(Fraction other) {
		BigInteger num = numerator.multiply(other.getDenominator()).subtract(
		        other.getNumerator().multiply(denominator));
		BigInteger den = denominator.multiply(other.getDenominator());
		return new Fraction(num, den);
	}

	public Fraction multiply(Fraction other) {
		return new Fraction(numerator.multiply(other.getNumerator()),
		        denominator.multiply(other.denominator));
	}

	public Fraction divide(Fraction other) {
		return new Fraction(numerator.multiply(other.getDenominator()),
		        denominator.multiply(other.getNumerator()));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fraction) {
			Fraction other = (Fraction) obj;
			return numerator.equals(other.getNumerator())
			        && denominator.equals(other.getDenominator());
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return numerator.hashCode() + denominator.hashCode();
	}

	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}

	private BigInteger getDenominator() {
		return this.denominator;
	}

	private BigInteger getNumerator() {
		return this.numerator;
	}

}
