/**
* @author  Team 3
* @members Brandon Dupy, Valliapan Pethaperumal, Sudeepta Das, Alex Gregg
* @copyright ISTM 622 - 602 ALL RIGHTS RESERVED
* @version 0.5 Final Sumbission
* @since   12/7/2017 
**/
package presentationLayer;

import java.io.FileNotFoundException;
import java.io.IOException;

import businessLayer.CalcRiskAvg;
import businessLayer.RiskScore;
import dataLayer.ImportData;
import dataLayer.SaveData;

public class Main {

/**
The Main class is primary class for this application.
* It calls five important methods:
* 1. Import data
* 2. Risk Score Assess Risk
* 3. Save User Data
* 4. Displays the summary to the User
* 5. Calculate the aggregate risk score for each age group
**/
	
	public static void main(String args[]) throws IOException {
		ImportData importData = new ImportData();
		RiskScore riskScore = new RiskScore();
		
		try {
			importData.importData();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		riskScore.assessRisk();
		SaveData.saveData();
		riskScore.displayRisk();
		CalcRiskAvg.aggregate();
		
	}

}
