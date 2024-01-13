/**
 * 
 */
package com.random.specification;

import java.util.Random;

/**
 * Class provide instance of java.util.Random to select random character from
 * available character set
 * 
 * @author mazhar
 * @since 1.0.0
 */
public final class RandomInstance {
	private final Random random;
	private static RandomInstance randomInstance;

	private RandomInstance(Random random) {
		this.random = random;
	}

	public static RandomInstance getInstance() {
		synchronized (RandomInstance.class) {
			if (randomInstance == null) {
				randomInstance = new RandomInstance(new Random());
			}
		}
		return randomInstance;
	}

	public Random getRandom() {
		return this.random;
	}

}
