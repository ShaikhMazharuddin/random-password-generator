/**
 * 
 */
package com.random.password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.random.specification.PasswordSpecificationBuilder;
import com.random.util.PasswordType;

/**
 * 
 */
class PasswordGeneratorImplTest {
	private PasswordGenerator passwordGenerator;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		passwordGenerator = new PasswordGeneratorImpl();
	}

	/**
	 * Test method for
	 * {@link com.random.password.PasswordGeneratorImpl#generateSimplePassword()}.
	 */
	@Test
	void testGenerateSimplePassword() {
		IntStream.range(0, 5).forEach(i -> {
			String result = passwordGenerator.generateSimplePassword();
			Assertions.assertTrue(result.matches("[a-z]+"));
			Assertions.assertEquals(8, result.length());
		});
	}

	/**
	 * Test method for
	 * {@link com.random.password.PasswordGeneratorImpl#generateDefaultPassword(int)}.
	 */
	@Test
	void testGenerateDefaultPassword() {
		IntStream.range(0, 5).forEach(i -> {
			String result = passwordGenerator.generateDefaultPassword(10);
			Matcher matcher1 = Pattern.compile("[0-9]").matcher(result);
			Matcher matcher2 = Pattern.compile("[A-Z]").matcher(result);
			Matcher matcher3 = Pattern.compile("[!@#$%^&*()-_=+[{]}\\|,<.>?]").matcher(result);
			Assertions.assertTrue(matcher1.find());
			Assertions.assertTrue(matcher2.find());
			Assertions.assertTrue(matcher3.find());
			Assertions.assertEquals(10, result.length());
		});
	}

	/**
	 * Test method for
	 * {@link com.random.password.PasswordGeneratorImpl#generatePassword(com.random.specification.PasswordSpecification)}.
	 */
	@Test
	void testGenerateAlphabetPassword() {
		IntStream.range(0, 5).forEach(i -> {
			String result = passwordGenerator
					.generatePassword(new PasswordSpecificationBuilder(PasswordGenerator.DEFAULT_PASSWORD_LENGTH)
							.setPasswordType(PasswordType.ALPHABET).setContainsCapitalLetter(true).build());
			Matcher matcher1 = Pattern.compile("[a-z]").matcher(result);
			Matcher matcher2 = Pattern.compile("[A-Z]").matcher(result);
			Assertions.assertTrue(matcher1.find());
			Assertions.assertTrue(matcher2.find());
			Assertions.assertEquals(PasswordGenerator.DEFAULT_PASSWORD_LENGTH, result.length());

		});

	}

	/**
	 * Test method for
	 * {@link com.random.password.PasswordGeneratorImpl#generatePassword(com.random.specification.PasswordSpecification)}.
	 */
	@Test
	void testGenerateNumberPassword() {
		IntStream.range(0, 5).forEach(i -> {
			String result = passwordGenerator.generatePassword(new PasswordSpecificationBuilder(10)
					.setPasswordType(PasswordType.NUMERIC).setContainsCapitalLetter(true).build());
			Matcher matcher1 = Pattern.compile("[0-9]").matcher(result);
			Assertions.assertTrue(matcher1.find());
			Assertions.assertEquals(10, result.length());

		});
	}

	/**
	 * Test method for
	 * {@link com.random.password.PasswordGeneratorImpl#generatePassword(com.random.specification.PasswordSpecification)}.
	 */
	@Test
	void testGenerateSymbolPassword() {
		IntStream.range(0, 5).forEach(i -> {
			String result = passwordGenerator.generatePassword(new PasswordSpecificationBuilder(10)
					.setPasswordType(PasswordType.SYMBOL).setContainsCapitalLetter(true).build());
			Matcher matcher1 = Pattern.compile("[!@#$%^&*()-_=+[{]}\\|,<.>?]").matcher(result);
			Assertions.assertTrue(matcher1.find());
			Assertions.assertEquals(10, result.length());
		});
	}

}
