package com.random.specification;

import com.random.util.PasswordType;

/**
 * Use to build the instance of PasswordSpecification using builder pattern
 * 
 * @author mazhar
 * @since 1.0.0
 */
public class PasswordSpecificationBuilder {
	private final int passwordLength;
	private boolean containsSymbol;
	private boolean containsLetter;
	private boolean containsNumber;
	private PasswordType passwordType;
	private boolean allLetterCaps;
	private boolean containsCapitalLetter;

	/**
	 * specify password length
	 * 
	 * @param passwordLength specify password length
	 */
	public PasswordSpecificationBuilder(int passwordLength) {
		this.passwordLength = passwordLength;
	}

	/**
	 * specify if password required symbols
	 * 
	 * @param containsSymbol specify if password required symbols
	 * @return PasswordSpecificationBuilder
	 */
	public PasswordSpecificationBuilder setContainsSymbol(boolean containsSymbol) {
		this.containsSymbol = containsSymbol;
		return this;
	}

	/**
	 * specify if password required letter
	 * 
	 * @param containsLetter specify if password required letter
	 * @return PasswordSpecificationBuilder
	 */
	public PasswordSpecificationBuilder setContainsLetter(boolean containsLetter) {
		this.containsLetter = containsLetter;
		return this;

	}

	/**
	 * specify if password required number
	 * 
	 * @param containsNumber specify if password required number
	 * @return PasswordSpecificationBuilder
	 */
	public PasswordSpecificationBuilder setContainsNumber(boolean containsNumber) {
		this.containsNumber = containsNumber;
		return this;

	}

	/**
	 * specify if password type Password type can be only ALPHABET, only NUMERIC or
	 * only SYMBOLS
	 * 
	 * @param passwordType specify if password type Password type can be ALPHABET,
	 *                     NUMERIC, SYMBOLS
	 * @return PasswordSpecificationBuilder
	 */
	public PasswordSpecificationBuilder setPasswordType(PasswordType passwordType) {
		this.passwordType = passwordType;
		switch (passwordType) {
		case ALL:
			this.containsLetter = true;
			this.containsNumber = true;
			this.containsSymbol = true;
			break;
		case ALPHABET:
			this.containsLetter = true;
			this.containsNumber = false;
			this.containsSymbol = false;
			break;
		case NUMERIC:
			this.containsLetter = false;
			this.containsNumber = true;
			this.containsSymbol = false;
			this.containsCapitalLetter = false;
			break;
		case SYMBOL:
			this.containsLetter = false;
			this.containsNumber = false;
			this.containsSymbol = true;
			this.containsCapitalLetter = false;
			break;
		case ALPHABET_NUMERIC:
			this.containsLetter = true;
			this.containsNumber = true;
			this.containsSymbol = false;
			break;
		case ALPHABET_SYMBOL:
			this.containsLetter = true;
			this.containsNumber = false;
			this.containsSymbol = true;
			break;
		case NUMERIC_SYMBOL:
			this.containsLetter = false;
			this.containsNumber = true;
			this.containsSymbol = true;
			this.containsCapitalLetter = false;
			break;
		}
		return this;
	}

	/**
	 * specify if password contains only capital letter
	 * 
	 * @param allLetterCaps specify if password contains only capital letter
	 * @return PasswordSpecificationBuilder
	 */
	public PasswordSpecificationBuilder setAllLetterCaps(boolean allLetterCaps) {
		this.allLetterCaps = allLetterCaps;
		return this;
	}

	/**
	 * specify if password contains few capital letter
	 * 
	 * @param containsCapitalLetter specify if password contains few capital letter
	 * 
	 * @return PasswordSpecificationBuilder
	 */
	public PasswordSpecificationBuilder setContainsCapitalLetter(boolean containsCapitalLetter) {
		this.containsCapitalLetter = containsCapitalLetter;
		return this;
	}

	/**
	 * Create instance of PasswordSpecification
	 * 
	 * @return PasswordSpecification
	 */
	public PasswordSpecification build() {
		PasswordSpecification specification = new PasswordSpecification();
		specification.setPasswordLength(passwordLength);
		specification.setContainsLetter(containsLetter);
		specification.setContainsNumber(containsNumber);
		specification.setContainsSymbol(containsSymbol);
		specification.setPasswordType(passwordType);
		specification.setAllLetterCapital(allLetterCaps);
		specification.setContainsCapitalLetter(containsCapitalLetter);
		return specification;
	}

}
