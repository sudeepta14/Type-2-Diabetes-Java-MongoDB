/**
* @author  Team 3
* @members Brandon Dupy, Valliapan Pethaperumal, Sudeepta Das, Alex Gregg
* @copyright ISTM 622 - 602 ALL RIGHTS RESERVED
* @version 0.5 Final Sumbission
* @since   12/7/2017 
**/

package businessLayer;

public class RiskScore {
	/**
	* The RiskScore class implements the functionality to assess the  
	* Type 2 diabetes risk score and displays the summary output message for the particular user. 
	**/
	
	private static String fname;
	private static String lName;
	private static int sexValue;
	private static String phoneNumber;
	private static String email;
	private static String ethnicity;
	private static int physicallyActive;
	private static int bloodPressure;
	private static int familyDiabetes;
	private static int gestationalDiabetes;
	private static int ageFactor;
	private static int feet;
	private static int inches;
	private static int weight;
	private static int bmiFactor;
	private static int riskScore;
	private static int heightInches;

	ApplicationLogic logic = new ApplicationLogic();
	
	public void assessRisk() {
		
		fname = logic.getFirstName();
		lName = logic.getLastName();
		phoneNumber = logic.getPhoneNumber();
		email = logic.getEmail();
		sexValue = logic.getSexValue();
		ageFactor = logic.getAge();
		feet = logic.getFeet();
		inches = logic.getInches();
		weight = logic.getWeight();
		bmiFactor = logic.getBMICalculation(inches, feet, weight);
		ethnicity = logic.getEthnicity();
		physicallyActive = logic.getPhysicallyActive();
		bloodPressure = logic.getBloodPressure();
		familyDiabetes = logic.getFamilyDiabetes();
		if (sexValue == 0) {
			gestationalDiabetes = logic.getGestDiabetes();
		}
		riskScore = logic.getRiskScore(ageFactor, sexValue, gestationalDiabetes, familyDiabetes, bloodPressure,
				physicallyActive, bmiFactor);
		heightInches = ((feet * 12) + inches);
	} 
		public void displayRisk() {
			
		
		riskScore = logic.getRiskScore(ageFactor, sexValue, gestationalDiabetes, familyDiabetes, bloodPressure,
				physicallyActive, bmiFactor);
		heightInches = ((feet * 12) + inches);
		System.out.println("\n ****** Your Type 2 Diabetes Risk Score is: " + riskScore + " ******");
		System.out.println();
		if (riskScore >= 5) {
			System.out.println("\n ****** You are at risk of having Type 2 Diabetes. \n"
					+ "\n ****** Please consult your doctor as soon as possible for further tests. \n"
					+ " ****** You can reduce your risk by getting more exercise and following a healthy diet.");
			System.out.println();
			if (ethnicity == "African American / Black" || ethnicity == "Hispanic American / Latino"
					|| ethnicity == "Asian American / Asian" || ethnicity == "Native American or Pacific Islander") {
				System.out.println(" ****** Additionally, your ethnic background of " + ethnicity
						+ " indicates you may be at increased risk for Type-2 Diabetes.");
				System.out.println();
			}
		} else {
			System.out.println("\n ****** Good news! You are not currently at high risk of getting Type-2 Diabetes. \n"
					+ " ****** Keep exercising, following a healthy diet, and have fun! ");
			System.out.println();
			if (ethnicity == "African American / Black" || ethnicity == "Hispanic American / Latino"
					|| ethnicity == "Asian American / Asian" || ethnicity == "Native American or Pacific Islander") {
				System.out.println(" ****** However, your ethnic background of " + ethnicity
						+ " indicates you may be at increased risk for Type-2 Diabetes. "
						+ "\n ****** It is recommended that you consult your doctor for a full analysis.");
			}
		}
		System.out.println("\n ****** This risk assessment algorithm is provided by the American Diabetes Association."
				+ "\n ****** It is not meant to be taken as medical advice, only a certified medical doctor can diagnose Type-2 Diabetes.");
		System.out.println(); 	
	}

	public String returnFName() {
		return fname;
	}

	public String returnLName() {
		return lName;
	}

	public int returnSexValue() {
		return sexValue;
	}

	public String returnphoneNumber() {
		return phoneNumber;
	}

	public String returnemail() {
		return email;
	}

	public String returnEthnicity() {
		return ethnicity;
	}

	public int returnPhysicallyActive() {
		return physicallyActive;
	}

	public int returnfamilyDiabetes() {
		return familyDiabetes;
	}

	public int returnBloodPressure() {
		return bloodPressure;
	}

	public int returnGestationalDiabetes() {
		return gestationalDiabetes;
	}

	public int returnAgeFactor() {
		return ageFactor;
	}

	public int returnWeight() {
		return weight;
	}

	public int returnBMIFactor() {
		return bmiFactor;
	}

	public int returnRiskFactor() {
		return riskScore;
	}

	public int returnHeightInches() {
		return heightInches;
	}

}

