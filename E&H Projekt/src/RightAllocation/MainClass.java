/**
 * @author Pascal Grunau, Simon Riedinger, Sarah Weinbecker, Anika Rist, Sebastian Abb
 * @version 1.0
 */

package RightAllocation;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import Test.GuiTest;

import Database.DBConnection;

/**
 *  Administrates the cache. Contains the main functions. Controls database access.
 */
public class MainClass {

	public static Map<String, Cache> m = new HashMap<String, Cache>();

	/**
	 * Displays an error, if the password and/or the username is wrong, or the user doesn't exists.
	 * 
	 * @param appID
	 *            The ID of the current application.
	 * @param userID
	 *            The ID of the current User.
	 * @param password
	 *            The password, which should be validated.
	 * @return Returns true, if the login was successful.
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
	 * Displays an error, if there is no role for the current application for the user.
	 * 
	 * @param appID
	 *            The ID of the current application.
	 * @param userID
	 *            The ID of the current User.
	 * @return Returns true, if the user has a role in this application.
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
	 * Displays an error, if there are no resources for the current application for the user.
	 * 
	 * @param appID
	 *            The ID of the current application.
	 * @param userID
	 *            The ID of the current user.
	 * @return Returns true, if the user has resources in this application.
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
	 * Checks in the database weather the password for the current user is correct.
	 * 
	 * @param userID
	 *            The ID of the current user.
	 * @param password
	 *            The password of the current user.
	 * @return Returns true, if the password is correct.
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
	 * Checks in the database weather the user has a role for the current
	 * application.
	 * 
	 * @param appID
	 *            The ID of the current application.
	 * @param userID
	 *            The ID of the current user.
	 * @return Returns true, if the user has a role in this Application.
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
	 * Check in the database weather the user has resources for the current
	 * application.
	 * 
	 * @param appID
	 *            The ID of the current application.
	 * @param userID
	 *            The ID of the current user.
	 * @return Returns true, if the user has resources in this application.
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
	 * Reads the permissions from the cache.
	 * 
	 * @param appID
	 *            The ID of the current application.
	 * @param userID
	 *            The ID of the current user.
	 * @return Returns the permissions for the current user.
	 */
	public static String[] getPermission(String appID, String userID) {
		String[] permissions;
		permissions = m.get(appID + userID).getPermissions();
		return permissions;
	}

	/**
	 * Reads the resources from the cache.
	 * 
	 * @param appID
	 *            The ID of the current application.
	 * @param userID
	 *            The ID of the current user.
	 * @return Returns the resources for the current user.
	 */
	public static String[] getRecources(String appID, String userID) {
		String resources[];
		resources = m.get(appID + userID).getResources();
		return resources;
	}

	/**
	 * Reads the role from the cache.
	 * 
	 * @param appID
	 *            The ID of the current application.
	 * @param userID
	 *            The ID of the current user.
	 * @return Returns the role for the current user.
	 */
	public static String getRole(String appID, String userID) {
		String role;
		role = m.get(appID + userID).getRole();
		return role;
	}

	/**
	 * Saves all available data for current user and current application.
	 * 
	 * @param appID
	 *            The ID of the current application.
	 * @param userID
	 *            The ID of the current user.
	 */
	public static void loadData(String appID, String userID) {
		m.put(appID + userID, new Cache());
		m.get(appID + userID).addData(appID, userID);
	}

	/**
	 * Deletes reference on the Cache Object, so the garbage collector will
	 * delete it.
	 * 
	 * @param appID
	 *            The ID of the current application.
	 * @param userID
	 *            The ID of the current user.
	 */
	public static void deleteData(String appID, String userID) {
		m.remove(appID + userID);
	}

	/**
	 * Just for testing. Adds a resource to the cache of the current user.
	 * 
	 * @param appID
	 *            The ID of the current application.
	 * @param userID
	 *            The ID of the current user.
	 */
	public static void addOneResource(String appID, String userID) {

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
