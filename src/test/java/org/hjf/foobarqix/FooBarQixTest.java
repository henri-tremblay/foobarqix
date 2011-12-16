package org.hjf.foobarqix;

import static org.easymock.EasyMock.*;
import static org.hjf.foobarqix.Odd.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Henri Tremblay
 * @author Jean-François Larouche
 */
public class FooBarQixTest {

	private FooBarQix fbq = new FooBarQix();

	private String convertNumber(int num) {
		StringBuilder sb = new StringBuilder(12);
		fbq.convertNumber(num, sb);
		return sb.toString();
	}

	@Test
	public void testSpecifications() {
		assertEquals("1", convertNumber(1));
		assertEquals("2", convertNumber(2));
		assertEquals("FooFoo", convertNumber(3));
		assertEquals("4", convertNumber(4));
		assertEquals("BarBar", convertNumber(5));
		assertEquals("Foo", convertNumber(6));
		assertEquals("QixQix", convertNumber(7));
		assertEquals("8", convertNumber(8));
		assertEquals("Foo", convertNumber(9));
		assertEquals("Bar", convertNumber(10));

		// On regarde les diviseurs avant le contenu (ex: 51 -> FooBar)
		assertEquals("FooBar", convertNumber(51));
		// On regarde le contenu dans l’ordre où il apparait (ex: 53 -> BarFoo)
		assertEquals("BarFoo", convertNumber(53));
		// On regarde les multiples dans l’ordre Foo, Bar puis Qix (ex: 21 -> FooQix)
		assertEquals("FooQix", convertNumber(21));
		// 13 contient 3 donc s’écrit “Foo”
		assertEquals("Foo", convertNumber(13));
		// 15 est divisible par 3 et 5 et contient un 5 donc s’écrit “FooBarBar”
		assertEquals("FooBarBar", convertNumber(15));
		// 33 contient deux fois 3 et est divisible par 3 donc s’écrit “FooFooFoo”
		assertEquals("FooFooFoo", convertNumber(33));
	}

	private String textIfDividing(int num, Odd odd) {
		StringBuilder sb = new StringBuilder(12);
		fbq.textIfDividing(num, odd, sb);
		return sb.toString();
	}

	@Test
	public void testTextIfDividing() {
		assertEquals(THREE.replacement, textIfDividing(9, THREE));
		assertEquals("", textIfDividing(11, THREE));
	}

	private String textForContent(char c) {
		StringBuilder sb = new StringBuilder(12);
		fbq.textForContent(c, sb);
		return sb.toString();
	}

	@Test
	public void testTextForContent() {
		assertEquals(THREE.replacement, textForContent('3'));
		assertEquals(FIVE.replacement, textForContent('5'));
		assertEquals(SEVEN.replacement, textForContent('7'));
		for (char c = '0'; c <= '9'; c++) {
			if (c != '3' && c != '5' && c != '7') {
				assertEquals("", textForContent(c));
			}
		}
	}

	@Test
	public void testResult() {
		FooBarQixListener listener = createStrictMock(FooBarQixListener.class);
		listener.handleNumberResult(1, "1");
		listener.handleNumberResult(2, "2");
		listener.handleNumberResult(3, "FooFoo");
		listener.handleNumberResult(4, "4");
		listener.handleNumberResult(5, "BarBar");
		listener.handleNumberResult(6, "Foo");
		listener.handleNumberResult(7, "QixQix");
		listener.handleNumberResult(8, "8");
		listener.handleNumberResult(9, "Foo");
		listener.handleNumberResult(10, "Bar");
		listener.handleNumberResult(11, "11");
		listener.handleNumberResult(12, "Foo");
		listener.handleNumberResult(13, "Foo");
		listener.handleNumberResult(14, "Qix");
		listener.handleNumberResult(15, "FooBarBar");
		listener.handleNumberResult(16, "16");
		listener.handleNumberResult(17, "Qix");
		listener.handleNumberResult(18, "Foo");
		listener.handleNumberResult(19, "19");
		listener.handleNumberResult(20, "Bar");
		listener.handleNumberResult(21, "FooQix");
		listener.handleNumberResult(22, "22");
		listener.handleNumberResult(23, "Foo");
		listener.handleNumberResult(24, "Foo");
		listener.handleNumberResult(25, "BarBar");
		listener.handleNumberResult(26, "26");
		listener.handleNumberResult(27, "FooQix");
		listener.handleNumberResult(28, "Qix");
		listener.handleNumberResult(29, "29");
		listener.handleNumberResult(30, "FooBarFoo");
		listener.handleNumberResult(31, "Foo");
		listener.handleNumberResult(32, "Foo");
		listener.handleNumberResult(33, "FooFooFoo");
		listener.handleNumberResult(34, "Foo");
		listener.handleNumberResult(35, "BarQixFooBar");
		listener.handleNumberResult(36, "FooFoo");
		listener.handleNumberResult(37, "FooQix");
		listener.handleNumberResult(38, "Foo");
		listener.handleNumberResult(39, "FooFoo");
		listener.handleNumberResult(40, "Bar");
		listener.handleNumberResult(41, "41");
		listener.handleNumberResult(42, "FooQix");
		listener.handleNumberResult(43, "Foo");
		listener.handleNumberResult(44, "44");
		listener.handleNumberResult(45, "FooBarBar");
		listener.handleNumberResult(46, "46");
		listener.handleNumberResult(47, "Qix");
		listener.handleNumberResult(48, "Foo");
		listener.handleNumberResult(49, "Qix");
		listener.handleNumberResult(50, "BarBar");
		listener.handleNumberResult(51, "FooBar");
		listener.handleNumberResult(52, "Bar");
		listener.handleNumberResult(53, "BarFoo");
		listener.handleNumberResult(54, "FooBar");
		listener.handleNumberResult(55, "BarBarBar");
		listener.handleNumberResult(56, "QixBar");
		listener.handleNumberResult(57, "FooBarQix");
		listener.handleNumberResult(58, "Bar");
		listener.handleNumberResult(59, "Bar");
		listener.handleNumberResult(60, "FooBar");
		listener.handleNumberResult(61, "61");
		listener.handleNumberResult(62, "62");
		listener.handleNumberResult(63, "FooQixFoo");
		listener.handleNumberResult(64, "64");
		listener.handleNumberResult(65, "BarBar");
		listener.handleNumberResult(66, "Foo");
		listener.handleNumberResult(67, "Qix");
		listener.handleNumberResult(68, "68");
		listener.handleNumberResult(69, "Foo");
		listener.handleNumberResult(70, "BarQixQix");
		listener.handleNumberResult(71, "Qix");
		listener.handleNumberResult(72, "FooQix");
		listener.handleNumberResult(73, "QixFoo");
		listener.handleNumberResult(74, "Qix");
		listener.handleNumberResult(75, "FooBarQixBar");
		listener.handleNumberResult(76, "Qix");
		listener.handleNumberResult(77, "QixQixQix");
		listener.handleNumberResult(78, "FooQix");
		listener.handleNumberResult(79, "Qix");
		listener.handleNumberResult(80, "Bar");
		listener.handleNumberResult(81, "Foo");
		listener.handleNumberResult(82, "82");
		listener.handleNumberResult(83, "Foo");
		listener.handleNumberResult(84, "FooQix");
		listener.handleNumberResult(85, "BarBar");
		listener.handleNumberResult(86, "86");
		listener.handleNumberResult(87, "FooQix");
		listener.handleNumberResult(88, "88");
		listener.handleNumberResult(89, "89");
		listener.handleNumberResult(90, "FooBar");
		listener.handleNumberResult(91, "Qix");
		listener.handleNumberResult(92, "92");
		listener.handleNumberResult(93, "FooFoo");
		listener.handleNumberResult(94, "94");
		listener.handleNumberResult(95, "BarBar");
		listener.handleNumberResult(96, "Foo");
		listener.handleNumberResult(97, "Qix");
		listener.handleNumberResult(98, "Qix");
		listener.handleNumberResult(99, "Foo");
		listener.handleNumberResult(100, "Bar");

		replay(listener);

		fbq.processNumbers(1, 100, listener);

		verify(listener);
	}
}
