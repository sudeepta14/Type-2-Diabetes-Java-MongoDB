/**
* @author  Team 3
* @members Brandon Dupy, Valliapan Pethaperumal, Sudeepta Das, Alex Gregg
* @copyright ISTM 622 - 602 ALL RIGHTS RESERVED
* @version 0.5 Final Sumbission
* @since   12/7/2017 
**/

package businessLayer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
/**
 * This class contains various methods for 
 * validating user inputs from the console. 
 */
	
	public void printErrorMessage() {
		System.out.print("\nSorry, that entry was invalid. Please enter a valid entry."); 

	}

	public boolean nameValidation(String name) {
		Validation validation = new Validation();
		name = name.toLowerCase();
		if (name == "" || (!Pattern.matches("[a-z]+", name))) {
			validation.printErrorMessage();
			return false;
		} else {
			return true;
		}
	}

	public boolean phoneNumberValidation(String phoneNumber) {
		Validation validation = new Validation();
		if(phoneNumber != "" && phoneNumber.matches("^[0-9]{10}$")) {
			return true;
		}
		else {
			validation.printErrorMessage();
			return false;
		}
	}

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;
	
	public boolean emailValidation(String email) {
		Validation validation = new Validation();
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		if(matcher.matches() == true) {
			return true;
		}
		else {
			validation.printErrorMessage();
			return false;
		}

	}

	public boolean sexValidation(String sexValue) {
		sexValue = sexValue.toLowerCase();
		Validation validation = new Validation();
		if(sexValue.equalsIgnoreCase("male") || sexValue.equalsIgnoreCase("female")) {
			return true;
		}else {
			validation.printErrorMessage();
			return false;
		}
	}
	public boolean yesNoValidation(String value) {
		value = value.toLowerCase();
		Validation validation = new Validation();
		if(value.equalsIgnoreCase("yes") || value.equalsIgnoreCase("no")) {
			return true;
		}else {
			validation.printErrorMessage();
			return false;
		}
	}
	

	public boolean integerValidation(String value, int min, int max) {
		Validation validation = new Validation();
		if(value.matches("[0-9]+") && value.length() > 0) {
			{
				int value1 = Integer.parseInt(value);
				if(value1 <=max && value1 >=min) {
					return true;
				}else {
					validation.printErrorMessage();
					return false;
				}
			}
		}else {
			validation.printErrorMessage();
			return false;
		}
	}
}
