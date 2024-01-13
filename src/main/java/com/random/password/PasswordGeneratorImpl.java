/**
 * 
 */
package com.random.password;

import com.random.specification.PasswordSpecification;
import com.random.specification.PasswordSpecificationBuilder;
import com.random.specification.RandomInstance;
import com.random.util.PasswordType;
import com.random.util.PasswordUtils;

/**
 * @author mazhar
 * @since 1.0.0
 */
public class PasswordGeneratorImpl implements PasswordGenerator {

	@Override
	public String generateSimplePassword() {
		return generatePassword(new PasswordSpecificationBuilder(PasswordGenerator.DEFAULT_PASSWORD_LENGTH)
				.setPasswordType(PasswordType.ALPHABET).build());
	}

	@Override
	public String generateDefaultPassword(int passwordLength) {
		return generatePassword(new PasswordSpecificationBuilder(passwordLength).setPasswordType(PasswordType.ALL)
				.setContainsCapitalLetter(true).build());
	}

	@Override
	public String generatePassword(PasswordSpecification passwordSpecification) {
		passwordSpecification.setPasswordLength(getValidPasswordLength(passwordSpecification.getPasswordLength()));
		switch (passwordSpecification.getPasswordType()) {
		case ALPHABET:
			return generateAlphabetPassword(passwordSpecification);
		case NUMERIC:
			return generateNumberPassword(passwordSpecification);
		case SYMBOL:
			return generateSymbolPassword(passwordSpecification);
		default:
			return generateRandomPassword(passwordSpecification);
		}
	}

	private String generateRandomPassword(PasswordSpecification passwordSpecification) {
		StringBuilder randomPassword = new StringBuilder();
		randomPassword.append(generateTemporaryPassword(passwordSpecification));
		if (passwordSpecification.isContainsCapitalLetter() && !passwordSpecification.isAllLetterCapital()) {
			int iteration = passwordSpecification.getPasswordLength() / 4;
			int j = 0;
			while (j < iteration) {
				int randomIndex = getRandomindex(passwordSpecification.getPasswordLength());
				if (Character.isAlphabetic(randomPassword.charAt(randomIndex))) {
					randomPassword.setCharAt(randomIndex, Character.toUpperCase(randomPassword.charAt(randomIndex)));
					j++;
				}
			}
		}
		if (passwordSpecification.isAllLetterCapital()) {
			return randomPassword.toString().toUpperCase();
		}
		return randomPassword.toString();
	}

	private String generateTemporaryPassword(PasswordSpecification passwordSpecification) {
		StringBuilder randomPassword = new StringBuilder();
		int i = 0;
		while (i < passwordSpecification.getPasswordLength()) {
			if (passwordSpecification.isContainsLetter()) {
				randomPassword.append(getRandomCharacter(PasswordUtils.CONSONENT_SMALL_ARRAY));
				i++;
				if (i < passwordSpecification.getPasswordLength()) {
					randomPassword.append(getRandomCharacter(PasswordUtils.VOWELS_SMALL_ARRAY));
					i++;
				}
			}
			if (passwordSpecification.isContainsSymbol() && i < passwordSpecification.getPasswordLength()) {
				randomPassword.append(getRandomCharacter(PasswordUtils.SYMBOL_ARRAY));
				i++;
			}
			if (passwordSpecification.isContainsNumber() && i < passwordSpecification.getPasswordLength()) {
				randomPassword.append(getRandomCharacter(PasswordUtils.NUMBERS_ARRAY));
				i++;
			}
		}
		return randomPassword.toString();
	}

	private String generateAlphabetPassword(PasswordSpecification passwordSpecification) {
		StringBuilder randomPassword = new StringBuilder();
		int i = 0;
		while (i < passwordSpecification.getPasswordLength()) {
			if (i < passwordSpecification.getPasswordLength()) {
				randomPassword.append(getRandomCharacter(PasswordUtils.CONSONENT_SMALL_ARRAY));
				i++;
			}
			if (i < passwordSpecification.getPasswordLength()) {
				randomPassword.append(getRandomCharacter(PasswordUtils.VOWELS_SMALL_ARRAY));
				i++;
			}
		}
		if (passwordSpecification.isContainsCapitalLetter() && !passwordSpecification.isAllLetterCapital()) {
			int iteration = passwordSpecification.getPasswordLength() / 4;
			int j = 0;
			while (j < iteration) {
				int randomIndex = getRandomindex(passwordSpecification.getPasswordLength());
				if (Character.isAlphabetic(randomPassword.charAt(randomIndex))) {
					randomPassword.setCharAt(randomIndex, Character.toUpperCase(randomPassword.charAt(randomIndex)));
					j++;
				}
			}
		}
		if (passwordSpecification.isAllLetterCapital()) {
			return randomPassword.toString().toUpperCase();
		}
		return randomPassword.toString();
	}

	private String generateNumberPassword(PasswordSpecification passwordSpecification) {
		StringBuilder randomPassword = new StringBuilder();
		long i = 0;
		while (i < passwordSpecification.getPasswordLength()) {
			randomPassword.append(getRandomCharacter(PasswordUtils.NUMBERS_ARRAY));
			i++;
		}
		return randomPassword.toString();
	}

	private String generateSymbolPassword(PasswordSpecification passwordSpecification) {
		StringBuilder randomPassword = new StringBuilder();
		int i = 0;
		while (i < passwordSpecification.getPasswordLength()) {
			randomPassword.append(getRandomCharacter(PasswordUtils.SYMBOL_ARRAY));
			i++;
		}
		return randomPassword.toString();
	}

	private char getRandomCharacter(char[] charArray) {
		return charArray[getRandomindex(charArray.length)];
	}

	private int getRandomindex(int upperBound) {
		return RandomInstance.getInstance().getRandom().nextInt(upperBound);
	}

	private int getValidPasswordLength(int passwordLength) {
		if (passwordLength < 0) {
			return PasswordGenerator.DEFAULT_PASSWORD_LENGTH;
		}
		if (passwordLength > Integer.MAX_VALUE) {
			return PasswordGenerator.MAX_PASSWORD_LENGTH;
		}
		return passwordLength;
	}

}
