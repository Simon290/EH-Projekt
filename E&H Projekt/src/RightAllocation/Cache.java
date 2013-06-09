/**
 * @author Pascal Grunau, Simon Riedinger, Sarah Weinbecker, Anika Rist, Sebastian Abb
 * @version 1.0
 */

package RightAllocation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import Database.DBConnection;


/**
 * Stores the information of a logged-in user locally.
 */
public class Cache {
	
	private String[] userInfo;
	private String[] appInfo;
	private String role;
	private String[] permissions;
	private String[] resources;
	private String timeStamp;

	/**
	 * Constructor: Generates a cache object with the current time as time stamp.
	 */
	public Cache() {
		timeStamp = getCurrentTimeAsString();
	}

	/**
	 * Returns an array of strings with the user info.
	 * 
	 * @return Returns user info.
	 */
	public String[] getUserInfo() {
		return userInfo;
	}

	/**
	 * Sets the user info.
	 * 
	 * @param userInfo
	 */
	public void setUserInfo(String[][] userInfo) {
		try {
			int lng = userInfo[0].length;
			String[] userinf = new String[lng];

			for (int i = 0; i < lng; i++) {
				userinf[i] = userInfo[0][i];
			}

			this.userInfo = userinf;
		} catch (Exception e) {
			// no user info available
		}

	}

	/**
	 * Returns an array of strings with the application info.
	 * 
	 * @return Returns application info.
	 */
	public String[] getAppInfo() {
		return appInfo;
	}

	/**
	 * Sets the application info.
	 * 
	 * @param appInfo
	 */
	public void setAppInfo(String[][] appInfo) {
		try {
			int lng = appInfo[0].length;
			String[] appinf = new String[lng];

			for (int i = 0; i < lng; i++) {
				appinf[i] = appInfo[0][i];
			}

			this.appInfo = appinf;
		} catch (Exception e) {
			// no application info available
		}

	}

	/**
	 * Returns an array of strings with the permissions.
	 * 
	 * @return Returns the permissions.
	 */
	public String[] getPermissions() {
		return permissions;
	}

	/**
	 * Sets the permissions.
	 * 
	 * @param permissions
	 */
	public void setPermissions(String[][] permissions) {
		try {
			int lng = permissions[0].length;
			String[] perm = new String[lng];

			for (int i = 0; i < lng; i++) {
				perm[i] = permissions[0][i];
			}

			this.permissions = perm;
		} catch (Exception e) {
			// no permissions available
		}

	}

	/**
	 * Returns an array of strings with the resources.
	 * 
	 * @return Returns resources.
	 */
	public String[] getResources() {
		return resources;
	}

	/**
	 * Sets the resources.
	 * 
	 * @param resources
	 */
	public void setResources(String[][] resources) {
		try {
			int lng = resources.length;
			String[] res = new String[lng];

			for (int i = 0; i < lng; i++) {
				res[i] = resources[i][0];
			}

			this.resources = res;
		} catch (Exception e) {
			// no resources available
		}

	}

	/**
	 * Returns a string with the time stamp of the object, set by creating the
	 * object.
	 * 
	 * @return Returns the time stamp.
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Sets the time stamp.
	 * 
	 * @param timeStamp
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * Returns a string with the role of the object.
	 * 
	 * @return Returns the role.
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 * 
	 * @param role
	 */
	public void setRole(String role[][]) {
		try {
			this.role = role[0][0];
		} catch (Exception e) {
			// no role available
		}

	}

	/**
	 * Loads the data for the user-app-pair from the database into the
	 * cache-object of the user-app-pair.
	 * 
	 * @param appID
	 *            The appID from a specific application.
	 * @param userID
	 *            The userID of a specific user.
	 */
	public void addData(String appID, String userID) {
		String[][] sqlResultUserInfo;
		String[][] sqlResultAppInfo;
		String[][] sqlResultPermissions;
		String[][] sqlResultResources;
		String[][] sqlResultRole;

		DBConnection.connect();

		sqlResultUserInfo = DBConnection.sqlQuery(SqlStmts
				.generateSelectFromViewSqlStmt(appID, userID,
						"User_ID, Surname, Forename, Company, Mail"));
		sqlResultAppInfo = DBConnection.sqlQuery(SqlStmts
				.generateSelectFromViewSqlStmt(appID, userID,
						"App_ID, ApplicationName, ApplicationVersion"));
		sqlResultPermissions = DBConnection.sqlQuery(SqlStmts
				.generateSelectFromViewSqlStmt(appID, userID,
						"PermissionName, PermissionLevel"));
		sqlResultResources = DBConnection.sqlQuery(SqlStmts
				.generateSelectFromViewSqlStmt(appID, userID, "ResourceName"));
		sqlResultRole = DBConnection.sqlQuery(SqlStmts
				.generateSelectFromViewSqlStmt(appID, userID, "RoleName"));

		DBConnection.disconnect();

		setUserInfo(sqlResultUserInfo);
		setAppInfo(sqlResultAppInfo);
		setPermissions(sqlResultPermissions);
		setResources(sqlResultResources);
		setRole(sqlResultRole);
	}

	/**
	 * Returns a string with the current time stamp. Format: dd.MM.yyyy HH:mm:ss
	 * 
	 * @return Returns the current time stamp.
	 */
	static private String getCurrentTimeAsString() {
		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+2:00"));
		return formatter.format(new Date());
	}

}