package fr.ng.projectEuler.utilities;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class FractionTest {

	@Test
	public void testHashCode() {

		BigInteger num = new BigInteger("1");
		BigInteger denom = new BigInteger("2");
		Fraction fraction1 = new Fraction(num, denom);
		int hashCode = num.hashCode() + denom.hashCode();
		assertEquals("hashCode is num hashcode + denom hashCode", hashCode,
		        fraction1.hashCode());
	}

	@Test
	public void testFraction() {
		Fraction fraction1 = new Fraction(new BigInteger("5"), new BigInteger(
		        "10"));
		Fraction fraction2 = new Fraction(new BigInteger("1"), new BigInteger(
		        "2"));
		assertEquals("5/10 is 1/2", fraction2, fraction1);
	}

	@Test
	public void testAdd() {
		Fraction fraction1 = new Fraction(new BigInteger("3"), new BigInteger(
		        "10"));
		Fraction fraction2 = new Fraction(new BigInteger("2"), new BigInteger(
		        "5"));
		assertEquals("3/10+2/5 is 7/10", new Fraction(new BigInteger("7"),
		        new BigInteger("10")), fraction1.add(fraction2));
	}

	@Test
	public void testSubstract() {
		Fraction fraction1 = new Fraction(new BigInteger("3"), new BigInteger(
		        "10"));
		Fraction fraction2 = new Fraction(new BigInteger("2"), new BigInteger(
		        "5"));
		assertEquals("3/10 - 2/5 = -1/10 ", new Fraction(new BigInteger("-1"),
		        new BigInteger("10")), fraction1.substract(fraction2));
	}

	@Test
	public void testMultiply() {
		Fraction fraction1 = new Fraction(new BigInteger("3"), new BigInteger(
		        "10"));
		Fraction fraction2 = new Fraction(new BigInteger("2"), new BigInteger(
		        "5"));
		assertEquals("3/10 * 2/5 = 3/25 ", new Fraction(new BigInteger("3"),
		        new BigInteger("25")), fraction1.multiply(fraction2));
	}

	@Test
	public void testDivide() {
		Fraction fraction1 = new Fraction(new BigInteger("3"), new BigInteger(
		        "10"));
		Fraction fraction2 = new Fraction(new BigInteger("2"), new BigInteger(
		        "5"));
		assertEquals("3/10 / 2/5 = 3/4 ", new Fraction(new BigInteger("3"),
		        new BigInteger("4")), fraction1.divide(fraction2));
	}

	@Test
	public void testEqualsObject() {
		Fraction fraction1 = new Fraction(new BigInteger("5"), new BigInteger(
		        "10"));
		assertEquals("", fraction1, fraction1);
	}

	@Test
	public void testToString() {
		Fraction fraction2 = new Fraction(new BigInteger("1"), new BigInteger(
		        "2"));
		assertEquals("1/2 is 1/2", "1/2", fraction2.toString());
	}

	@Test
	public void testGetClass() {
		Fraction fraction1 = new Fraction(new BigInteger("5"), new BigInteger(
		        "10"));
		assertEquals("fraction class is Fraction", Fraction.class,
		        fraction1.getClass());
	}
}
