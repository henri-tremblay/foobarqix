package org.hjf.foobarqix;

import static org.hjf.foobarqix.Odd.*;

/**
 * Implementation of the specification defined
 * <a href="http://www.code-story.net/2011/11/16/foobarqix.html">here</a>.
 * 
 * @author Henri Tremblay
 * @author Jean-François Larouche
 */
public final class FooBarQix {

	//Contains the string who are written depending on the ASCII code
	//Why the null? To eliminate the need of subtracting the '0' value from the number
	private static String[] contains = { null, null, null, null, null, null, null, null, null, null, null, null, null,
		null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
		null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "", "",
		"", THREE.replacement, "", FIVE.replacement, "", SEVEN.replacement, "", "" };

	/**
	 * Process numbers from the firstNumber to the lastNumber inclusively. Give the result
	 * to the listener.
	 * 
	 * @param firstNumber first number to process
	 * @param lastNumber
	 * @param listener
	 */
	public void processNumbers(int firstNumber, int lastNumber, FooBarQixListener listener) {
		for (int i = firstNumber; i <= lastNumber; i++) {
			StringBuilder result = new StringBuilder(12); // 12 being the longest possible result
			convertNumber(i, result);
			listener.handleNumberResult(i, result);
		}
	}

	/**
	 * Convert the number to its string equivalent
	 * 
	 * @param num the number
	 * @param result result buffer
	 */
	void convertNumber(int num, StringBuilder result) {
		// check for division first
		textIfDividing(num, THREE, result);
		textIfDividing(num, FIVE, result);
		textIfDividing(num, SEVEN, result);

		// then the content
		String iStr = Integer.toString(num);
		for (int i = 0; i < iStr.length(); i++) {
			textForContent(iStr.charAt(i), result);
		}

		// when we don't find anything just write the number
		if (result.length() == 0) {
			result.append(iStr);
		}
	}



	/**
	 * Fill the result with the replacement string or nothing
	 * 
	 * @param c the number to convert
	 * @param result result buffer
	 */
	void textForContent(char c, StringBuilder result) {
		result.append(contains[c]);
	}

	/**
	 * Checks the number can be divised by num. If yes, append the replacement string to the buffer
	 * 
	 * @param number number to test
	 * @param divider the dividing number
	 * @param result result buffer
	 */
	void textIfDividing(int number, Odd divider, StringBuilder result) {
		if (number % divider.number == 0) {
			result.append(divider.replacement);
		}
	}
}
