/*
 * @author Pascal, Simon, Anika
 * @version 2.03
 */

package RightAllocation;

/*
 *  Generates SQL statements according to some parameter.
 */
public class SqlStmts {
 // komische Änderung
	/**
	 * Generates the SQL statement to get the user information for a specific
	 * user.
	 * 
	 * @param userId
	 *            The userID of an specific user.
	 * @return Returns a string with the SQL statement to get information about
	 *         a user by userID.
	 */
	static String generateGetUserInfoSQLStmt(String userId) {
		String sql = "SELECT * FROM Users WHERE User_ID =" + userId + ";";
		return sql;
	}

	/**
	 * Generates the SQL statement to get information about an application.
	 * 
	 * @param appId
	 *            The ID of an specific application.
	 * @return Returns a string with the SQL statement to get information about
	 *         an application by appID.
	 */
	static String generateAppInfoSQLStmt(String appId) {
		String sql = "SELECT * FROM Applications WHERE App_ID =" + appId + ";";
		return sql;
	}

	/**
	 * Generates the SQL statement to get the RoleID of an specific user for
	 * specific application.
	 * 
	 * @param userId
	 *            The userID of an specific user.
	 * @param appId
	 *            The appId of the application.
	 * @return Returns a string with the SQL statement to get the RoleID.
	 */
	static String generateGetRoleIdSQLStmt(String userId, String appId) {
		String sql = "SELECT Role_ID FROM Main WHERE User_ID like '" + userId
				+ "' AND App_ID like '" + appId + ";";
		return sql;
	}

	/**
	 * Generates the SQL statement to get the ResourceID of an specific user for
	 * specific application.
	 * 
	 * @param userId
	 *            The userID of an specific user.
	 * @param appId
	 *            The appId of the application.
	 * @return Returns a string with the SQL statement to get the ResourceID.
	 */
	static String generateGetResourceIdSQLStmt(String userId, String appId) {
		String sql = "SELECT Resource_ID FROM Main WHERE User_ID like '"
				+ userId + "' AND App_ID like '" + appId + ";";
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
	static String generateGetRightsSqlStmt(String tableRoles, String roleId) {
		String sql = "SELECT * FROM " + tableRoles + " WHERE Role_ID = "
				+ roleId + ";";
		return sql;
	}

	/**
	 * Generates the SQL statement to get the resources of an specific user for
	 * specific application.
	 * 
	 * @param tableResources
	 *            The name of the table.
	 * @param resourceId
	 *            The resourceID from the user.
	 * @return Returns a string with the SQL statement to get the resources.
	 */
	static String generateGetResourcesSqlStmt(String tableResources,
			String resourceId) {
		String sql = "SELECT * FROM " + tableResources
				+ " WHERE Resource_ID = " + resourceId + ";";
		return sql;
	}

}
