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

	public static boolean checkPassword(String appID, String userID,
			String password) {
		if (checkUserPassword(userID, password)) {
			return true;
		} else {
			System.out.println("Passwort oder Username falsch");
			return false;
		}
	}

	public static boolean hasRole(String appID, String userID) {
		if (checkUserRoleAppPair(appID, userID)) {			
			return true;
		} else {
			System.out.println("keine Role für diese Application");
			return false;
		}
	}

	public static boolean hasResources(String appID, String userID) {
		if (checkUserResourceAppPair(appID, userID)) {			
			return true;
		} else {
			System.out.println("keine Ressourcen für diese Application");
			return false;
		}
	}

	static boolean checkUserPassword(String userID, String password) {
		boolean passwordValid = false;
		String[][] result = new String[0][0];
		try {
			DBConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			result = DBConnection.sqlQuery(SqlStmts
					.generateValidatePasswordSqlStmt(userID, password));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (result.length == 0) {
			passwordValid = false;
		} else {
			passwordValid = true;
		}
		return passwordValid;
	}

	static boolean checkUserRoleAppPair(String appID, String userID) {
		String[][] resultRole;

		try {
			DBConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			resultRole = DBConnection.sqlQuery(SqlStmts
					.generateCheckRoleExistenceSQLStmt(appID, userID));

		} catch (Exception e) {
			resultRole = new String[0][0];
			e.printStackTrace();
		}

		try {
			DBConnection.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (resultRole.length == 0) {
			return false;
		} else {
			return true;
		}
	}

	static boolean checkUserResourceAppPair(String appID, String userID) {
		String[][] resultResource;

		try {
			DBConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			resultResource = DBConnection.sqlQuery(SqlStmts
					.generateCheckResourceExistenceSQLStmt(appID, userID));
		} catch (Exception e) {

			resultResource = new String[0][0];
			e.printStackTrace();
		}

		try {
			DBConnection.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (resultResource.length == 0) {
			return false;
		} else {
			return true;
		}

	}

	// gibt Permission zurück
	public static String[] getPermission(String appID, String userID) {
		String[] permissions;
		permissions = m.get(appID + userID).getPermissions();
		return permissions;
	}

	// gibt die verfügbaren Recoucen zurück
	public static String[] getRecources(String appID, String userID) {
		String resources[];
		resources = m.get(appID + userID).getResources();
		return resources;
	}

	// gibt die Rolle zurück
	public static String getRole(String appID, String userID) {
		String role;
		role = m.get(appID + userID).getRole();
		return role;
	}

	// speichert alle Daten in die Cache Klasse
	public static void loadData(String appID, String userID) {
		m.put(appID + userID, new Cache());
		m.get(appID + userID).addData(appID, userID);
	}

	// löscht das Cacheobjekt, bzw nur die Referenz und gubt es so für den
	// Garbage-Collector frei.
	public static void deleteData(String appID, String userID) {
		Cache c = m.get(appID + userID);
		c = null;
	}

}
