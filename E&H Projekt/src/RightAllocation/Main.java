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
	
	public static boolean login(String appID,String userID, String password) {
		
		if(checkUserPassword(userID,password)){
			if(checkUserAppPair(appID, userID)){
				//createUserAppPairView(appID, userID);
				loadData(appID, userID);
				// TODO lade alle Recourcen und Rollen und Permissions in die Cache Klasse 
				System.out.println("login erfolgreich");
				return true;
			} else{
				System.out.println("keine Rechte für diese Application");
				return false;
			}
		} else{
			System.out.println("Passwort oder Username falsch");
			return false;
		}
	}
	
	static boolean checkUserPassword(String userID, String password){
		boolean passwordValid = false;
		String[][] result = new String[0][0];
		try {
			DBConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			result = DBConnection.sqlQuery(SqlStmts.generateValidatePasswordSqlStmt(userID, password));
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
		String[][] resultRole;
		String[][] resultResource;
		
		try {
			DBConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			resultRole = DBConnection.sqlQuery(SqlStmts.generateCheckRoleExistenceSQLStmt(appID, userID));
			resultResource = DBConnection.sqlQuery(SqlStmts.generateCheckResourceExistenceSQLStmt(appID, userID));
		} catch (Exception e) {
			resultRole = new String[0][0];
			resultResource = new String[0][0];
			e.printStackTrace();
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
	/*
	static void createUserAppPairView(String appID, String userID){
		try {
			DBConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		try {
			// View ist schon da!
			// DBConnection.createView(SqlStmts.genearteCreateViewSQLStmt(appID, userID));
		} catch (Exception e) {
					
		}
		
		try {
			// View bleibt bestehen
			// DBConnection.viewDisconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/
	// gibt Rollen und Permission zurück
	public static String[] getPermission(String appID, String userID){
		String[] permissions;
		permissions = m.get(appID + userID).getPermissions();
		return permissions;
	}
	
	// gibt die verfügbaren Recoucen zurück
	public static String[] getRecources(String appID, String userID){
		String resources[];
		resources = m.get(appID + userID).getResources();
		return resources;
	}
	
	// speichert alle Daten in die Cache Klasse
	public static void loadData(String appID, String userID) {
		m.put(appID + userID, new Cache());
		m.get(appID + userID).addData(appID, userID);			
	}	
	/**
	 * Nur zum Testen
	 * 
	 * @param args
	 */
	public static void main(String[] args) {						
		login("1", "grupas", "123");
		String[] a = new String[3];
		a = m.get("1grupas").getAppInfo();
		System.out.println("Appid: " + a[0] + " Appname: " + a[1] + " ApplicationVersion: " + a[2]);
		
				
	}

}
