package com.jayasanka.thread.safe.a.stateless;

import java.math.BigInteger;

/**
 * The factorial() method is a stateless deterministic function.
 * 
 * method neither relies on external state nor maintains state at all. So, it's considered to be thread-safe and can be
 * safely called by multiple threads at the same time.
 *
 * Therefore, stateless implementations are the simplest way to achieve thread-safety.
 *
 */
public class StatelessFunctions {

	public static BigInteger factorial(int number) {
		BigInteger f = new BigInteger("1");
		for (int i = 2; i <= number; i++) {
			f = f.multiply(BigInteger.valueOf(i));
		}
		return f;
	}
}
