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

import javax.swing.JOptionPane;

import Test.GuiTest;

import Database.DBConnection;

/*
 *  Just for tests and development
 */
public class Main {

	public static Map<String, Cache> m = new HashMap<String, Cache>();

	/**
	 * Check the password and the username in the database. sends it to Database
	 * 
	 * @param appID
	 *            The ID of the current App
	 * @param userID
	 *            The ID of the current User
	 * @param password
	 *            The password, which should be validated
	 * @return returns weather the password was correct or not
	 */
	public static boolean checkPassword(String appID, String userID,
			String password) {
		if (checkUserPassword(userID, password)) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"Passwort oder Username falsch oder nicht vorhanden!",
					"Loginfehler ", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	/**
	 * Check in the database weather the user has Roles for the current
	 * Application
	 * 
	 * @param appID
	 *            The ID of the current App
	 * @param userID
	 *            The ID of the current User
	 * @return returns weather the User has a Role in this Application
	 */
	public static boolean hasRole(String appID, String userID) {
		if (checkUserRoleAppPair(appID, userID)) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"Keine Rolle für diese Application vorhanden!",
					"Keine Rolle", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	/**
	 * Check in the database weather the user has Resources for the current
	 * Application
	 * 
	 * @param appID
	 *            The ID of the current App
	 * @param userID
	 *            The ID of the current User
	 * @return returns weather the User has resources in this Application
	 */
	public static boolean hasResources(String appID, String userID) {
		if (checkUserResourceAppPair(appID, userID)) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"Keine Ressourcen für diese Application vorhanden!",
					"Keine Ressource", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	/**
	 * Check in the database weather the for the current user is correct
	 * 
	 * @param userID
	 *            The ID of the current User
	 * @param password
	 *            The password of the current User
	 * @return returns weather the password is correct
	 */
	static boolean checkUserPassword(String userID, String password) {
		boolean passwordValid = false;
		String[][] result = new String[0][0];

		DBConnection.connect();

		result = DBConnection.sqlQuery(SqlStmts
				.generateValidatePasswordSqlStmt(userID, password));

		DBConnection.disconnect();

		if (result.length == 0) {
			passwordValid = false;
		} else {
			passwordValid = true;
		}
		return passwordValid;
	}

	/**
	 * Check in the database weather the user has Role for the current
	 * Application
	 * 
	 * @param appID
	 *            The ID of the current App
	 * @param userID
	 *            The ID of the current User
	 * @return returns weather the User has Role in this Application
	 */
	static boolean checkUserRoleAppPair(String appID, String userID) {
		String[][] resultRole;

		DBConnection.connect();

		resultRole = DBConnection.sqlQuery(SqlStmts
				.generateCheckRoleExistenceSQLStmt(appID, userID));

		DBConnection.disconnect();

		if (resultRole.length == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Check in the database weather the user has Resources for the current
	 * Application
	 * 
	 * @param appID
	 *            The ID of the current App
	 * @param userID
	 *            The ID of the current User
	 * @return returns weather the User has resources in this Application
	 */
	static boolean checkUserResourceAppPair(String appID, String userID) {
		String[][] resultResource;

		DBConnection.connect();

		resultResource = DBConnection.sqlQuery(SqlStmts
				.generateCheckResourceExistenceSQLStmt(appID, userID));

		DBConnection.disconnect();

		if (resultResource[0][0].equals("0")) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Reads the Permissions from Cache
	 * 
	 * @param appID
	 *            The ID of the current App
	 * @param userID
	 *            The ID of the current User
	 * @return returns the Permissions for current user
	 */
	public static String[] getPermission(String appID, String userID) {
		String[] permissions;
		permissions = m.get(appID + userID).getPermissions();
		return permissions;
	}

	/**
	 * Reads the Resources from Cache
	 * 
	 * @param appID
	 *            The ID of the current App
	 * @param userID
	 *            The ID of the current User
	 * @return returns the Resources for current user
	 */
	public static String[] getRecources(String appID, String userID) {
		String resources[];
		resources = m.get(appID + userID).getResources();
		return resources;
	}

	/**
	 * Reads the Role from Cache
	 * 
	 * @param appID
	 *            The ID of the current App
	 * @param userID
	 *            The ID of the current User
	 * @return returns the Role for current user
	 */
	public static String getRole(String appID, String userID) {
		String role;
		role = m.get(appID + userID).getRole();
		return role;
	}

	/**
	 * Saves all available Data for current User and current Application
	 * 
	 * @param appID
	 *            The ID of the current App
	 * @param userID
	 *            The ID of the current User
	 */
	public static void loadData(String appID, String userID) {
		m.put(appID + userID, new Cache());
		m.get(appID + userID).addData(appID, userID);
	}

	/**
	 * Deletes reference on the Cache Object, so the Garbage Collector will
	 * delete it
	 * 
	 * @param appID
	 *            The ID of the current App
	 * @param userID
	 *            The ID of the current User
	 */
	public static void deleteData(String appID, String userID) {
		m.remove(appID + userID);
	}

	/**
	 * Just for testing. Edits the Cache of current User.
	 * 
	 * @param appID
	 *            The ID of the current App
	 * @param userID
	 *            The ID of the current User
	 */
	public static void EditCache(String appID, String userID) {

		String[] oldRes = m.get(appID + userID).getResources();
		String[][] newRes = new String[oldRes.length + 1][oldRes.length + 1];

		for (int i = 0; i < oldRes.length; i++) {
			newRes[i][0] = oldRes[i];
			newRes[0][i] = oldRes[i];
		}

		if (GuiTest.getJTfAddRes().getText().trim().equals("")) {
			newRes[oldRes.length][0] = "New";
		} else {
			newRes[oldRes.length][0] = GuiTest.getJTfAddRes().getText().trim();
		}

		m.get(appID + userID).getResources();
		m.get(appID + userID).setResources(newRes);
	}

}
