package org.hjf.foobarqix;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class FooBarQixBench extends SimpleBenchmark {

	private final FooBarQix service = new FooBarQix();
	private final FooBarQixListener listener = new FooBarQixListener() {
		@Override
		public void handleNumberResult(int num, String s) {

		}
	};

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public int timeFooBarQix(int reps) throws Exception {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			service.processNumbers(1, 100, listener);
			result += i;
		}
		return result;
	}

	public static void main(String... args) {
		Runner.main(FooBarQixBench.class, args);
	}
}
