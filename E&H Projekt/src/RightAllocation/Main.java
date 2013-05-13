/*
 * @author Pascal
 * @version 2.03
 */

package RightAllocation;

/*
 * imports
 */
import Database.DBConnection;

/*
 *  Just for tests and development
 */
public class Main {

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DBConnection.connect();
		} catch (Exception e) {
			System.out.println("Database connection failed!");
			e.printStackTrace();
		}
		try {
			System.out.print(DBConnection.sql("SELECT * FROM Users"));
		} catch (Exception e) {
			System.out.println("Connection failed!");
			e.printStackTrace();
		}
		try {
			DBConnection.disconnect();
		} catch (Exception e) {
			System.out.println("Database disconnection failed!");
			e.printStackTrace();
		}
	}

}
