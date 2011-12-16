package org.hjf.foobarqix;

/**
 * Listener implementation logging to the console
 * 
 * @author Henri Tremblay
 * @author Jean-François Larouche
 */
public class FooBarQixConsoleListener implements FooBarQixListener {
	@Override
	public void handleNumberResult(int num, String s) {
		System.out.println(s);
	}
}