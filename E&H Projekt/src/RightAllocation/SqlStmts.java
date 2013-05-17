/*
 * @author Pascal, Simon, Anika
 * @version 2.03
 */

package RightAllocation;

/*
 *  Generates SQL statements according to some parameter.
 */
public class SqlStmts {
	
	///////
	
	
	/**
	 * Generates the SQL statement to get userID and appID if the pair exists.
	 * 
	 * @param userID
	 *            The userID of an specific user.
	 * @param appID
	 *            The appID of the specific application.
	 * @return Returns a String with the results.
	 */
	static String generateCheckExistenceSQLStmt(String appID, String userID) {
		String sql = "SELECT User_ID, App_ID FROM Main WHERE App_ID LIKE '"
				+ appID + "' AND User_ID LIKE '" + userID + "';";
		return sql;
	}

	/**
	 * Generates the SQL statement to get the user information for a specific
	 * user.
	 * 
	 * @param userID
	 *            The userID of an specific user.
	 * @return Returns a string with the SQL statement to get information about
	 *         a user by userID.
	 */
	static String generateGetUserInfoSQLStmt(String userID) {
		String sql = "SELECT * FROM Users WHERE User_ID LIKE '" + userID + "';";
		return sql;
	}

	/**
	 * Generates the SQL statement to get information about an application.
	 * 
	 * @param appID
	 *            The ID of an specific application.
	 * @return Returns a string with the SQL statement to get information about
	 *         an application by appID.
	 */
	static String generateGetAppInfoSQLStmt(String appID) {
		String sql = "SELECT * FROM Applications WHERE App_ID LIKE '" + appID
				+ "';";
		return sql;
	}

	/**
	 * Generates the SQL statement to get the Table_Roles of an specific
	 * application.
	 * 
	 * @param appID
	 *            The appId of the application.
	 * @return Returns a string with the SQL statement to get the Table_Roles.
	 */
	static String generateGetTableRolesSQLStmt(String appID) {
		String sql = "SELECT Table_Roles FROM Applications WHERE App_ID LIKE '"
				+ appID + "';";
		return sql;
	}

	/**
	 * Generates the SQL statement to get the Table_Resources of an specific
	 * application.
	 * 
	 * @param appID
	 *            The appId of the application.
	 * @return Returns a string with the SQL statement to get the
	 *         Table_Resources.
	 */
	static String generateGetTableResourcesSQLStmt(String appID) {
		String sql = "SELECT Table_Resources FROM Applications WHERE App_ID LIKE '"
				+ appID + "';";
		return sql;
	}

	/**
	 * Generates the SQL statement to get the RoleID of an specific user for
	 * specific application.
	 * 
	 * @param userID
	 *            The userID of an specific user.
	 * @param appID
	 *            The appId of the application.
	 * @return Returns a string with the SQL statement to get the RoleID.
	 */
	static String generateGetRoleIdSQLStmt(String appID, String userID) {
		String sql = "SELECT Role_ID FROM Main WHERE App_ID LIKE '" + appID
				+ "' AND User_ID LIKE '" + userID + "';";
		return sql;
	}

	/**
	 * Generates the SQL statement to get the ResourceID of an specific user for
	 * specific application.
	 * 
	 * @param userID
	 *            The userID of an specific user.
	 * @param appID
	 *            The appId of the application.
	 * @return Returns a string with the SQL statement to get the ResourceID.
	 */
	static String generateGetResourceIdSQLStmt(String appID, String userID) {
		String sql = "SELECT Resource_ID FROM Main WHERE App_ID like '" + appID
				+ "' AND User_ID LIKE '" + userID + "';";
		return sql;
	}

	/**
	 * Generates the SQL statement to get the rights of an specific user for
	 * specific application.
	 * 
	 * @param tableRoles
	 *            The name of the table.
	 * @param roleID
	 *            The roleID from the user.
	 * @return Returns a string with the SQL statement to get the rights.
	 */
	static String generateGetRightsSQLStmt(String tableRoles, String roleID) {
		String sql = "SELECT * FROM " + tableRoles + " WHERE Role_ID = "
				+ roleID + ";";
		return sql;
	}

	/**
	 * Generates the SQL statement to get the resources of an specific user for
	 * specific application.
	 * 
	 * @param tableResources
	 *            The name of the table.
	 * @param resourceID
	 *            The resourceID from the user.
	 * @return Returns a string with the SQL statement to get the resources.
	 */
	static String generateGetResourcesSQLStmt(String tableResources, String resourceID) {
		String sql = "SELECT * FROM " + tableResources + " WHERE Resource_ID = " + resourceID + ";";
		return sql;
	}

}
