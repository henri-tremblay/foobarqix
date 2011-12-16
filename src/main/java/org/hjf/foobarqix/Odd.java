package org.hjf.foobarqix;

/**
 * Enum to make conversion easier
 * 
 * @author Henri Tremblay
 * @author Jean-François Larouche
 */
public enum Odd {

	THREE(3, "Foo"), FIVE(5, "Bar"), SEVEN(7, "Qix");

	int number;
	String replacement;

	private Odd(int number, String replacement) {
		this.number = number;
		this.replacement = replacement;
	}
}
