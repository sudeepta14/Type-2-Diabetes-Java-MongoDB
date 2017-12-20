/**
* @author  Team 3
* @members Brandon Dupy, Valliapan Pethaperumal, Sudeepta Das, Alex Gregg
* @copyright ISTM 622 - 602 ALL RIGHTS RESERVED
* @version 0.5 Final Sumbission
* @since   12/7/2017 
**/

package dataLayer;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import businessLayer.RiskScore;

public class SaveData {
/**
 * The SaveData class connects to MongoDB and saves the user's risk data. 
 */
	public String setfName;
	public String lName;
	public int sexValue;
	public String phoneNumber;
	public String email;
	public String ethnicity;
	public int physicallyActive;
	public int bloodPressure;
	public int familyDiabetes;
	public int gestationalDiabetes;
	public int ageFactor;
	public int feet;
	public int inches;
	public int weight;
	public int bmiFactor;
	public int riskScore;
	public double heightInches;
	
	public static void saveData() {
		
		DBConnection dataBaseConnection = new DBConnection();
		
		// Incrementing the MemberID
		int i = 0;
		for (Document cur : dataBaseConnection.getCollection().find()) {
			i = cur.getInteger("MemberID");

		}
		int newMemberId = i + 1;

		RiskScore newData = new RiskScore();

		Document doc1 = new Document("MemberID", newMemberId).append("FirstName", newData.returnFName())
				.append("LastName", newData.returnLName()).append("Email", newData.returnemail())
				.append("PhoneNumber", newData.returnphoneNumber()).append("Sex ", newData.returnSexValue())
				.append("HeightInches ", newData.returnHeightInches()).append("WeightPounds", newData.returnWeight())
				.append("EthnicityFactor ", newData.returnEthnicity())
				.append("PhysicallyActive:", newData.returnPhysicallyActive())
				.append("BloodPressure:", newData.returnBloodPressure())
				.append("ImmeFamilyDiabetes:", newData.returnfamilyDiabetes())
				.append("GestationalDiabetes:", newData.returnGestationalDiabetes())
				.append("BMI", newData.returnBMIFactor()).append("RiskFactor", newData.returnRiskFactor());
		dataBaseConnection.getCollection().insertOne(doc1);

		try {			
			Document myDoc = (Document) dataBaseConnection.getCollection().find().sort(new BasicDBObject("_id", -1)).first();

			System.out.println(myDoc);
			dataBaseConnection.closeConnection();

		} catch (Exception e) {
			System.out.println("Error executing ");

		}
		dataBaseConnection.closeConnection();
	}

}

