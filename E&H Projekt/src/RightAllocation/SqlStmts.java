/**
 * @author Pascal Grunau, Simon Riedinger, Sarah Weinbecker, Anika Rist, Sebastian Abb
 * @version 1.0
 */

package RightAllocation;

/**
 *  Generates SQL statements according to some parameters.
 */
public class SqlStmts {

	/**
	 * Generates the SQL statement to get specific columns from the view table.
	 * 
	 * @param userID
	 *            The userID of an specific user.
	 * @param appID
	 *            The appID of the specific application.
	 * @param parameter
	 *            The columns which should be selected. String is comma
	 *            separated.
	 * @return Returns the Statement for reading the view table.
	 */
	static String generateSelectFromViewSqlStmt(String appID, String userID,
			String parameter) {
		if (parameter == "") {
			parameter = "*";
		}
		String sql = "SELECT DISTINCT " + parameter + " From View"
				+ " WHERE App_ID = " + appID + " AND User_ID LIKE '" + userID
				+ "';";
		return sql;
	}

	/**
	 * Generates the SQL statement to validate the password for a specific
	 * user.
	 * 
	 * @param userID
	 *            The userID of an specific user.
	 * @param password
	 *            The password for the user.
	 * @return Returns the SQL Statement for checking the password
	 */
	static String generateValidatePasswordSqlStmt(String userID, String password) {
		String sql = "SELECT User_ID, Password" + " FROM Users"
				+ " WHERE User_ID LIKE '" + userID + "'"
				+ " AND Password LIKE '" + password + "';";
		return sql;
	}

	/**
	 * Generates the SQL statement to get userID and appID if the pair exists
	 * for a role.
	 * 
	 * @param userID
	 *            The userID of an specific user.
	 * @param appID
	 *            The appID of the specific application.
	 * @return Returns a String with the SQL statement.
	 */
	static String generateCheckRoleExistenceSQLStmt(String appID, String userID) {
		String sql = "SELECT UserRoles.User_ID, Roles.App_ID"
				+ " FROM Roles INNER JOIN UserRoles ON Roles.Role_ID = UserRoles.Role_ID"
				+ " WHERE Roles.App_ID LIKE '" + appID + "'"
				+ " AND User_ID LIKE '" + userID + "';";
		return sql;
	}

	/**
	 * Generates the SQL statement to get userID and appID if the pair exists
	 * for a resource.
	 * 
	 * @param userID
	 *            The userID of an specific user.
	 * @param appID
	 *            The appID of the specific application.
	 * @return Returns a String with the SQL statement.
	 */
	static String generateCheckResourceExistenceSQLStmt(String appID,
			String userID) {
		String sql = "SELECT Resource_ID" + " FROM UserResources"
				+ " WHERE App_ID LIKE '" + appID + "' AND User_ID LIKE '"
				+ userID + "';";
		return sql;
	}

}
