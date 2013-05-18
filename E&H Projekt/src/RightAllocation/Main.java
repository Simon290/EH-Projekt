/*
 * @author Pascal
 * @version 2.03
 */

package RightAllocation;

/*
 * imports
 */
import java.util.HashMap;
import java.util.Map;

import Database.DBConnection;


/*
 *  Just for tests and development
 */
public class Main {
	
	static Map<String, Cache> m = new HashMap<String, Cache>();
	
	static boolean checkPassword(String password, String userID, String appID) {
		boolean passwordValid = false;
		if(checkUserPassword(userID,password)==true){
			passwordValid = true;
			login(appID, userID);
		}
		return passwordValid;
	}
	
	static boolean login(String appID, String userID) {
		boolean b = false;
		if(checkUserAppPair(appID, userID) == true){
			b = true;
			m.put(appID + userID, new Cache());
			m.get(appID + userID).addData(appID, userID);
			
		} else{
			b = false;
		}
		return b;
	}
	static boolean checkUserPassword(String userID, String password){
		boolean passwordValid = false;
		String[] result = new String[0];
		try {
			DBConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			result = DBConnection.sql(SqlStmts.generateValidatePasswordSqlStmt(userID, password));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(result.length == 0){
			passwordValid = false;
		} else{
			passwordValid = true;
		}	
		return passwordValid;
	}
	static boolean checkUserAppPair(String appID, String userID){
		boolean b;
		String[] result = new String[0];
		
		try {
			DBConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			result = DBConnection.sql(SqlStmts.generateCheckExistenceSQLStmt(userID, appID));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			DBConnection.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result.length == 0){
			b = false;
		} else{
			b = true;
		}	
		return b;
	}

	
	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		login("App1", "grupas");
				
	}

}
