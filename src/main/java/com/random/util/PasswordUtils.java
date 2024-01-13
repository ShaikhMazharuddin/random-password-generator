/**
 * 
 */
package com.random.util;

/**
 * Utility class which provide values for generating password
 * 
 * @author mazhar
 * @since 1.0.0
 */
public final class PasswordUtils {

	/**
	 * Array of capital alphabets 
	 */
	public static final char[] CONSONENT_CAPITAL_ARRAY = new char[] { 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
			'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Y' };
	/**
	 * Array of capital vowels
	 */
	public static final char[] VOWELS_CAPITAL_ARRAY = new char[] { 'A', 'E', 'I', 'O', 'U' };
	/**
	 * Array of small alphabets
	 */
	public static final char[] CONSONENT_SMALL_ARRAY = new char[] { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
			'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z' };
	/**
	 * Array of small vowels
	 */
	public static final char[] VOWELS_SMALL_ARRAY = new char[] { 'a', 'e', 'i', 'o', 'u' };
	/**
	 * Array of symbols
	 */
	public static final char[] SYMBOL_ARRAY = new char[] { '!', '@', '#', '$', '%', '^', '&', '*', '-', '+', '?', '=',
			'~' };
	/**
	 * Array of capital numbers
	 */
	public static final char[] NUMBERS_ARRAY = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	private PasswordUtils() {
		super();
	}

}
