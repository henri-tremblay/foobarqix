--------------------------------------------------------------------------------------
Environment
--------------------------------------------------------------------------------------
Was tested with:
- Maven 3.0.3
- Eclipse Indigo SR1 with m2e
- JDK 1.7

--------------------------------------------------------------------------------------
To build everything with tests
--------------------------------------------------------------------------------------
- mvn package

--------------------------------------------------------------------------------------
To run from maven
--------------------------------------------------------------------------------------
- mvn -Prun

--------------------------------------------------------------------------------------
To run in standalone
--------------------------------------------------------------------------------------
- java -jar target/foobarqix-1.0.jar

--------------------------------------------------------------------------------------
To bench
--------------------------------------------------------------------------------------
- mvn clean package -Pbench -DskipTests
- java -jar target\foobarqix-1.0-jar-with-dependencies.jar --printScore --trials 2

--------------------------------------------------------------------------------------
To check dependencies and plugins versions
--------------------------------------------------------------------------------------
- mvn versions:display-dependency-updates versions:display-plugin-updates

--------------------------------------------------------------------------------------
To Import in Eclipse fully integrated
--------------------------------------------------------------------------------------
- Import the Maven project to Eclipse
- Add the "bench" profile to the Maven configuration of the project if you want the bench classes and dependencies

--------------------------------------------------------------------------------------
Original naive implementation before optimizations
--------------------------------------------------------------------------------------
package org.hjf.foobarqix;

/**
 * Implementation of the specification defined
 * <a href="http://www.code-story.net/2011/11/16/foobarqix.html">here</a>.
 * 
 * @author Henri Tremblay
 * @author Jean-François Larouche
 */
public class FooBarQix {

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
			String s = convertNumber(i);
			listener.handleNumberResult(i, s);
		}
	}

	/**
	 * Convert the number to its string equivalent
	 * 
	 * @param num the number
	 * @return the string equivalent
	 */
	public String convertNumber(int num) {
		// check for division first
		StringBuilder result = new StringBuilder(12); // 12 being the longest possible result
		result.append(textIfDividing(num, 3, "Foo"));
		result.append(textIfDividing(num, 5, "Bar"));
		result.append(textIfDividing(num, 7, "Qix"));

		String iStr = Integer.toString(num);
		for (int i = 0; i < iStr.length(); i++) {
			result.append(textForContent(iStr.charAt(i)));
		}
		return result.length() == 0 ? iStr : result.toString();
	}

	/**
	 * Return the wanted string for a given number in char
	 * 
	 * @param c the number to convert
	 * @return the replacement string or the empty string if there's no replacement needed
	 */
	protected String textForContent(char c) {
		// Could be replaced by a Map if more numbers are used
		switch (c) {
		case '3':
			return "Foo";
		case '5':
			return "Bar";
		case '7':
			return "Qix";
		}
		return "";
	}

	/**
	 * Checks the number can be divised by num. If yes, return the replacement string
	 * 
	 * @param number number to test
	 * @param divider divider
	 * @param replacement replacement string
	 * @return the replacement string or the empty string
	 */
	protected String textIfDividing(int number, int divider, String replacement) {
		return (number % divider == 0) ? replacement : "";
	}
}
