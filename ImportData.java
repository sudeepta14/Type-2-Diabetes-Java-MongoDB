/**
* @author  Team 3
* @members Brandon Dupy, Valliapan Pethaperumal, Sudeepta Das, Alex Gregg
* @copyright ISTM 622 - 602 ALL RIGHTS RESERVED
* @version 0.5 Final Sumbission
* @since   12/7/2017 
**/

package dataLayer;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class ImportData {
	/**
	 * The ImportData class connects to MongoDB and checks whether the CSV file is
	 * already imported or not. If it is not imported, it imports the data into
	 * MongoDB.
	 * 
	 * The MongoImport method pulls the path from the Config file to the User's root
	 * location for mongoImport program/utility.
	 **/
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
	public String importPath;

	public void importData() throws FileNotFoundException, IOException {
		DBConnection dataBaseConnection = new DBConnection();

		try {
			boolean healthCareDatabaseExists = dataBaseConnection.getConnection().listCollectionNames()
					.into(new ArrayList<String>()).contains("patient");

			if (!healthCareDatabaseExists) {

				System.out.println("Adding Data From CSV to MongoDB using Java");
				String db = "dbrApplication";
				String col = "patient";
				String Host = "localhost";
				String Port = "27017";
				File file = new File("Data/Patients102617.csv");
				String fileName = file.getAbsolutePath();

				mongoImport();
				String command = importPath + " --host " + Host + " --port " + Port + " --db " + db + " --collection "
						+ col + " --headerline --type=csv --file " + fileName;

				System.out.println(command);
				Runtime runtime = Runtime.getRuntime();
				Process process = null;
				try {

					process = runtime.exec(command);
					System.out.println("Reading the CSV into the Database");
					dataBaseConnection.getConnection();
					System.out.println("SUCCESSFUL");
					dataBaseConnection.closeConnection();

				} catch (Exception e) {
					System.out.println("Error executing " + command + e.toString());

				}

			}

		} catch (Exception e) {
			System.out.println("Error executing ");
		} finally {
			System.out.print("");
		}
	}

	public void mongoImport() {
		InputStream in = ImportData.class.getClassLoader().getResourceAsStream("config.properties");

		Properties config = new Properties();
		try {
			config.load(in);
			this.importPath = config.getProperty("path");

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
