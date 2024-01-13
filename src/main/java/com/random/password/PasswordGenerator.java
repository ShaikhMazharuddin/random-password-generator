/**
 * 
 */
package com.random.password;

import com.random.specification.PasswordSpecification;

/**
 * Declaration of methods required to generate password
 * 
 * @author mazhar
 * @since 1.0.0
 */
public interface PasswordGenerator {
	/**
	 * Default length i.e. {@value} of password if password length not specified 
	 */
	int DEFAULT_PASSWORD_LENGTH = 8;
	/**
	 * Passowrd's maximum length i.e. {@value}
	 */
	int MAX_PASSWORD_LENGTH = Integer.MAX_VALUE;

	/**
	 * Generate password provided by specification
	 * 
	 * @param passwordSpecification contains length of password will it contains
	 *                              number special character, will it capital case
	 * @return password
	 */
	String generatePassword(PasswordSpecification passwordSpecification);

	/**
	 * Generate password with given length and password will contains alphabet,
	 * number, symbols and some alphabets in capital case
	 * 
	 * @param passwordLength length of the password
	 * @return password
	 */
	String generateDefaultPassword(int passwordLength);

	/**
	 * Generate character password with default length
	 * 
	 * @return password
	 */
	String generateSimplePassword();
}
