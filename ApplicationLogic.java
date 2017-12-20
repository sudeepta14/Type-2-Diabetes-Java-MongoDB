/**
* @author  Team 3
* @members Brandon Dupy, Valliapan Pethaperumal, Sudeepta Das, Alex Gregg
* @copyright ISTM 622 - 602 ALL RIGHTS RESERVED
* @version 0.5 Final Sumbission
* @since   12/7/2017 
**/

package businessLayer;

import java.util.Scanner;

public class ApplicationLogic {
	/**
	 * The ApplicationLogic class implements the functionality to collect important
	 * user data and attributes used to calculate Type-2 diabetes risk.
	 **/

	Scanner input = new Scanner(System.in);
	
	Validation validation = new Validation();

	public String getFirstName() {
		int i = 0;
		String firstName = "";
		while (i != 1) {
			System.out.println("\nPlease enter your First Name");
			firstName = input.nextLine();
			if (validation.nameValidation(firstName)) {
				i = 1;
			} else {
				i = 0;
			}
		} 
		return firstName;
	}

	public String getLastName() {
		String lastName = "";
		int i = 0;
		while (i != 1) {
			System.out.println("\nPlease enter your Last Name");
			lastName = input.nextLine();
			if (validation.nameValidation(lastName)) {
				i = 1;
			} else {
				i = 0;
			}
		}
		return lastName;
	}

	public String getPhoneNumber() {
		String phoneNumber = "";
		int i = 0;
		while (i != 1) {
			System.out.println("\nPlease enter your Phone Number (10 digits, no dashes, ex. '2149641280')");
			phoneNumber = input.nextLine();
			if (validation.phoneNumberValidation(phoneNumber)) {
				i = 1;
			} else {
				i = 0;
			}
		}
		return phoneNumber;
	}

	public String getEmail() {
		String email = "";
		int i = 0;
		while (i != 1) {
			System.out.println("\nPlease enter your Email Address");
			email = input.nextLine();

			if (validation.emailValidation(email)) {
				i = 1;
			} else {
				{
				i = 0;
				}
			}
		}
		return email;
	}

	public int getSexValue() {
		int flag = 0;
		String sexValue = "";
		while (flag != 1) {
			System.out.println("\nPlease enter male / female");
			sexValue = input.nextLine().toLowerCase();
			if (validation.sexValidation(sexValue)) {
				if ((sexValue.equalsIgnoreCase("male"))) {
					return 1;
				} else if ((sexValue.equalsIgnoreCase("female"))) {
					return 0;
				}
			}
		}
		return flag;
	}

	public int getAge() {
		int flag = 0;
		String age1 = "";
		int age = 0;
		int ageFactor;

		while (flag != 1) {
			System.out.println("\nPlease enter your age");
			age1 = input.nextLine();
			int min = 0;
			int max = 120;
			if (validation.integerValidation(age1, min, max)) {
				flag = 1;
			} else {
				{
				flag = 0;
				}
			}
		}
		// Separating age into buckets to apply risk factor

		age = Integer.parseInt(age1);

		if (age < 40) {
			ageFactor = 0;
			return ageFactor;
		} else if (age < 49) {
			ageFactor = 1;
			return ageFactor;
		} else if (age < 59) {
			ageFactor = 2;
			return ageFactor;
		} else {
			ageFactor = 3;
			return ageFactor;
		}

	}

	public int getWeight() {
		String weight = "";
		int flag = 0;
		while (flag != 1) {
			System.out.println("\nPlease enter your weight");
			weight = input.nextLine();
			int min = 0;
			int max = 1000;

			if (validation.integerValidation(weight, min, max)) {
				flag = 1;
			} else {
				flag = 0;
			}
		}
		return (Integer.parseInt(weight));
	}

	// Instead of asking the user to calculate their height in inches, we ask for
	// the first and second numbers, and calculate for them.

	public int getFeet() {
		String feet = "";
		int flag = 0;
		while (flag != 1) {
			System.out.println("\nPlease enter the feet portion of height :");
			feet = input.nextLine();
			int min = 2;
			int max = 8;
			if (validation.integerValidation(feet, min, max)) {
				flag = 1;
			} else {
				flag = 0;
			}
		}

		return (Integer.parseInt(feet));
	}

	public int getInches() {
		String inches = "";
		int flag = 0;

		while (flag != 1) {
			System.out.println("\nPlease enter the inches portion of height :");
			inches = input.nextLine();
			int min = 0;
			int max = 11;
			if (validation.integerValidation(inches, min, max)) {
				flag = 1;
			} else {
				flag = 0;
			}
		}

		return (Integer.parseInt(inches));
	}

	public int getBMICalculation(int inches, int feet, int weight) {
		Double bmi;
		int bmiFactor = 0;
		double heightInches = ((feet * 12) + inches);
		
		// Separating BMI into buckets to apply risk factor 
		
		bmi = (double) ((703 * weight) / (heightInches * heightInches));
		System.out.println("\n******Your BMI is " + bmi + "******");
		if (bmi <= 25) {
			bmiFactor = 0;
			return bmiFactor;
		} else if (bmi > 25 & bmi < 30) {
			bmiFactor = 1;
			return bmiFactor;
		} else if (bmi >= 30 & bmi < 40) {
			bmiFactor = 2;
			return bmiFactor;
		} else if (bmi >= 40) {
			bmiFactor = 3;
			return bmiFactor;
		}
		return 0;

	}

	// Ethnicity not used in risk calculation, but will be referenced in the return message.

	public String getEthnicity() {
		String flag = "";
		String ethnicity = "";
		int i = 0;
		while (i != 1) {
			System.out.println("\nPlease enter ethnicity according to the following values:\n"
					+ "0 - Caucasian / White \n" + "1 - African American / Black\n" + "2 - Hispanic American / Latino\n"
					+ "3 - Asian American / Asian\n" + "4 - Native American or Pacific Islander");
			ethnicity = input.nextLine().toLowerCase();
			if ((ethnicity.equalsIgnoreCase("0"))) {
				String a = "Caucasian / White";
				return a;
			} else if ((ethnicity.equalsIgnoreCase("1"))) {
				String b = "African American / Black";
				return b;
			} else if ((ethnicity.equalsIgnoreCase("2"))) {
				String c = "Hispanic American / Latino";
				return c;
			} else if ((ethnicity.equalsIgnoreCase("3"))) {
				String d = "Asian American / Asian";
				return d;
			} else if ((ethnicity.equalsIgnoreCase("4"))) {
				String e = "Native American or Pacific Islander";
				return e;
			} else {
				System.out.println("\nSorry, that entry was invalid. Please enter a correct value!");
			}
		}
		return flag;
	}

	public int getPhysicallyActive() {
		String physicallyActive = "";
		int i = 0;
		while (i != 1) {
			System.out.println("\nAre you physically active? (yes/no) : ");
			physicallyActive = input.nextLine();
			if (validation.yesNoValidation(physicallyActive)) {
				if ((physicallyActive.equalsIgnoreCase("no"))) {
					return 1;
				} else if ((physicallyActive.equalsIgnoreCase("yes"))) {
					return 0;
				}
			}
		}
		return 0;
	}

	public int getBloodPressure() {
		String bloodPressure = "";
		int i = 0;
		while (i != 1) {
			System.out.println("\nHave you ever been diagnosed with high blood pressure? (yes/no) : ");
			bloodPressure = input.nextLine();
			if (validation.yesNoValidation(bloodPressure)) {
				if ((bloodPressure.equalsIgnoreCase("yes"))) {
					return 1;
				} else if ((bloodPressure.equalsIgnoreCase("no"))) {
					return 0;
				}
			}
		}
		return 0;
	}

	public int getFamilyDiabetes() {
		String familyDiabetes = "";
		int i = 0;
		while (i != 1) {
			System.out.println("\nHas anyone in your immediate family been diagnosed with type 2 diabetes? (yes/no) : ");
			familyDiabetes = input.nextLine();
			if (validation.yesNoValidation(familyDiabetes)) {
				if ((familyDiabetes.equalsIgnoreCase("yes"))) {
					return 1;
				} else if ((familyDiabetes.equalsIgnoreCase("no"))) {
					return 0;
				}
			}
		}
		return 0;
	}

	// Gestational diabetes method only runs if user has entered 'female'

	public int getGestDiabetes() {
		String gestDiabetes = "";
		int i = 0;
		while (i != 1) {
			System.out.println("\nHave you ever been diagnosed with gestational diabetes? (yes/no) : ");
			gestDiabetes = input.nextLine();
			if (validation.yesNoValidation(gestDiabetes)) {
				if ((gestDiabetes.equalsIgnoreCase("yes"))) {
					return 1;
				} else if ((gestDiabetes.equalsIgnoreCase("no"))) {
					return 0;
				}
			}
		}
		input.close();
		return 0;
	}
	

	// Summing factors to gain a score 0-11 to determine risk for Type 2 Diabetes
	public int getRiskScore(int ageFactor, int sexValue, int gestationalDiabetes, int familyDiabetes, int bloodPressure,
			int physicallyActive, int bmiFactor) {
		int riskScore = (sexValue + ageFactor + gestationalDiabetes + familyDiabetes + bloodPressure + physicallyActive
				+ bmiFactor);
		return riskScore;
	} 
}