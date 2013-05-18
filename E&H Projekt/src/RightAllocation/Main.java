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
		boolean userAppPairExists;
		String[] resultRole = new String[0];
		String[] resultResource = new String[0];
		
		try {
			DBConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			resultRole = DBConnection.sql(SqlStmts.generateCheckRoleExistenceSQLStmt(userID, appID));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			resultResource = DBConnection.sql(SqlStmts.generateCheckResourceExistenceSQLStmt(userID, appID));
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
		
		if(resultRole.length == 0 && resultResource.length == 0){
			userAppPairExists = false;
		} else{
			userAppPairExists = true;
		}	
		return userAppPairExists;
	}

	
	/**
	 * Nur zum Testen
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		login("App1", "grupas");
				
	}

}
