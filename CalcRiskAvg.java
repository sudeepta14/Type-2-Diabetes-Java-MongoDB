/**
* @author  Team 3
* @members Brandon Dupy, Valliapan Pethaperumal, Sudeepta Das, Alex Gregg
* @copyright ISTM 622 - 602 ALL RIGHTS RESERVED
* @version 0.5 Final Sumbission
* @since   12/7/2017 
**/

package businessLayer;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CalcRiskAvg {
	/**
	* The CalcRiskAvg class implements the aggregation functionality to find the average 
	* Type 2 diabetes risk score for each age group.
	**/
	
	public static void aggregate() {
		
		MongoClient client1 = new MongoClient("localhost", 27017);
		MongoDatabase databaseSave = client1.getDatabase("dbrApplication");
		MongoCollection<Document> collectionSave = databaseSave.getCollection("patient");
		int j = 0, count0 = 0, count1 = 0, count2 = 0, count3 = 0, averageRiskScoreFor0 = 0, averageRiskScoreFor1 = 0,
				averageRiskScoreFor2 = 0, averageRiskScoreFor3 = 0;
		Integer i = 0;
		for (Document cur : collectionSave.find()) {
			i = cur.getInteger("AgeFactor");
			if (i != null) {
				if (i == 0) {
					j = cur.getInteger("RiskFactor");
					averageRiskScoreFor0 = averageRiskScoreFor0 + j;
					count0++;
				} else if (i == 1) {
					j = cur.getInteger("RiskFactor");
					averageRiskScoreFor1 = averageRiskScoreFor1 + j;
					count1++;
				} else if (i == 2) {
					j = cur.getInteger("RiskFactor");
					averageRiskScoreFor2 = averageRiskScoreFor2 + j;
					count2++;
				} else if (i == 3) {
					j = cur.getInteger("RiskFactor");
					averageRiskScoreFor3 = averageRiskScoreFor3 + j;
					count3++;
				}

			}

		}
		System.out.println("\n ****** Average Risk Score for Age Group less than 40 is " + (averageRiskScoreFor0 / count0));
		System.out.println("\n ****** Average Risk Score for Age Group between 40-49 is " + (averageRiskScoreFor1 / count1));
		System.out.println("\n ****** Average Risk Score for Age Group between 50-59 is " + (averageRiskScoreFor2 / count2));
		System.out.println("\n ****** Average Risk Score for Age Group over 60 is " + (averageRiskScoreFor3 / count3));
		System.out.println();
		
		client1.close();
	}
}

