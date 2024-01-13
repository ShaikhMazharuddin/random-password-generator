/**
 * 
 */
package com.random.specification;

import com.random.util.PasswordType;

/**
 * @author mazhar
 * @since 1.0.0
 */
public class PasswordSpecification {
	private int passwordLength;
	private boolean containsSymbol;
	private boolean containsLetter;
	private boolean containsNumber;
	private boolean allLetterCapital;
	private boolean containsCapitalLetter;
	private PasswordType passwordType;

	public PasswordSpecification() {
	}

	public PasswordSpecification(int passwordLength) {
		this.passwordLength = passwordLength;
	}

	public int getPasswordLength() {
		return passwordLength;
	}

	public void setPasswordLength(int passwordLength) {
		this.passwordLength = passwordLength;
	}

	public boolean isContainsSymbol() {
		return containsSymbol;
	}

	public void setContainsSymbol(boolean containsSymbol) {
		this.containsSymbol = containsSymbol;
	}

	public boolean isContainsLetter() {
		return containsLetter;
	}

	public void setContainsLetter(boolean containsLetter) {
		this.containsLetter = containsLetter;
	}

	public boolean isContainsNumber() {
		return containsNumber;
	}

	public void setContainsNumber(boolean containsNumber) {
		this.containsNumber = containsNumber;
	}

	public void setAllLetterCapital(boolean allLetterCapital) {
		this.allLetterCapital = allLetterCapital;
	}

	public PasswordType getPasswordType() {
		return passwordType;
	}

	public void setPasswordType(PasswordType passwordType) {
		this.passwordType = passwordType;
	}

	public boolean isAllLetterCapital() {
		return allLetterCapital;
	}

	public boolean isContainsCapitalLetter() {
		return containsCapitalLetter;
	}

	public void setContainsCapitalLetter(boolean containsCapitalLetter) {
		this.containsCapitalLetter = containsCapitalLetter;
	}
}
