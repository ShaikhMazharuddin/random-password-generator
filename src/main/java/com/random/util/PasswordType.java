/**
 * 
 */
package com.random.util;

/**
 * @author mazhar
 * @since 1.0.0
 */
public enum PasswordType {
	/**
	 * Password contains alphabet, number, symbols
	 */
	ALL,
	/**
	 * Password contains only alphabet
	 */
	ALPHABET,
	/**
	 * Password contains only numbers
	 */
	NUMERIC,
	/**
	 * Password contains only symbol
	 */
	SYMBOL,
	/**
	 * Password contains alphabet and numbers
	 */
	ALPHABET_NUMERIC,
	/**
	 * Password contains alphabet and symbol
	 */
	ALPHABET_SYMBOL,
	/**
	 * Password contains only numbers and symbol
	 */
	NUMERIC_SYMBOL;
}
