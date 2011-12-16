package org.hjf.foobarqix;

/**
 * Main class launching the FooBarQix application.
 * 
 * @author Henri Tremblay
 * @author Jean-François Larouche
 * @see FooBarQix
 */
public class Main {

	/**
	 * Main entry point to the application. The result of FooBqrQix is shown
	 * on the command line
	 * 
	 * @param args no parameters required
	 */
	public static void main(String[] args) {
		FooBarQix fbq = new FooBarQix();
		fbq.processNumbers(1, 100, new FooBarQixConsoleListener());
	}
}
