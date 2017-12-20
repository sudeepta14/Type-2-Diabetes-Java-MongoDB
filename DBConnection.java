/**
* @author  Team 3
* @members Brandon Dupy, Valliapan Pethaperumal, Sudeepta Das, Alex Gregg
* @copyright ISTM 622 - 602 ALL RIGHTS RESERVED
* @version 0.5 Final Sumbission
* @since   12/7/2017 
**/

package dataLayer;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DBConnection {
	/**
	* The DBConnection class connects to the instance of the database. 
	**/
	
	MongoClient databaseClient = new MongoClient("127.0.0.1", 27017);
	MongoDatabase db = databaseClient.getDatabase("dbrApplication");
	
	public MongoDatabase getConnection(){
		return db;
	}
	
	public void closeConnection() {
		databaseClient.close();
	}
	
	
	public MongoCollection<Document> getCollection() {
		DBConnection dbc = new DBConnection();
		MongoCollection<Document> collectionRecord = dbc.getConnection().getCollection("patient");
		return collectionRecord;
	}
		
}
