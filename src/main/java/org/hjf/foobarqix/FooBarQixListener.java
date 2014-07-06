package org.hjf.foobarqix;

/**
 * Listener receiving the resulting string for every number processed
 * by FooBarQix.
 * 
 * @author Henri Tremblay
 * @author Jean-François Larouche
 * @see FooBarQix
 */
public interface FooBarQixListener {
	/**
	 * Method called for every number processed
	 * 
	 * @param num the converted number
	 * @param s the result string for the number
	 */
	void handleNumberResult(int num, CharSequence s);
}
