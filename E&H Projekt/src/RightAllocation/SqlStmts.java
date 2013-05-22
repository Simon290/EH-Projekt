/*
 * @author Pascal, Simon, Anika
 * @version 2.03
 */

package RightAllocation;

/*
 *  Generates SQL statements according to some parameter.
 */
public class SqlStmts {
	
	
	/**
	 * Generates the SQL statement to get specific columns from the View table.
	 * 
	 * @param userID
	 *            The userID of an specific user.
	 * @param appID
	 *            The appID of the specific application.
	 * @param parameter
	 * 			  The columns which should be selected. Sting is comma separated.           
	 * @return Returns the Statement for reading the View table.
	 */
	static String generateSelectFromViewSqlStmt(String appID, String userID, String parameter) {
		if(parameter == ""){
			parameter = "*";			
		}
		String sql = "SELECT DISTINCT " + parameter
					+ " From View"
					+ " WHERE App_ID = " + appID
					+ " AND User_ID LIKE '" + userID + "';";
		return sql;
	}
	
	/**
	 * Generates the SQL statement to get validate the password for a specific user.
	 * 
	 * @param userID
	 *            The userID of an specific user.
	 * @param password
	 *            The password for the user.          
	 * @return Returns the SQL Statement for checking the Password
	 */
	static String generateValidatePasswordSqlStmt(String userID, String password) {
		String sql = "SELECT User_ID, Password"
					+ " FROM Users"
					+ " WHERE User_ID LIKE '" + userID + "'"
					+ " AND Password LIKE '" + password + "';";
		return sql;
	}
	
	
	/**
	 * Generates the SQL statement to get userID and appID if the pair exists for a role.
	 * 
	 * @param userID
	 *            The userID of an specific user.
	 * @param appID
	 *            The appID of the specific application.
	 * @return Returns a String with the SQL statement.
	 */
	
	static String generateCheckRoleExistenceSQLStmt(String appID, String userID) {
		String sql = "SELECT User_ID, App_ID" 
					+ " FROM View" 
					+ " WHERE App_ID LIKE '" + appID + "'" 
					+ " AND User_ID LIKE '" + userID + "';";
		return sql;
	}
	
	/**
	 * Generates the SQL statement to get userID and appID if the pair exists for a resource.
	 * 
	 * @param userID
	 *            The userID of an specific user.
	 * @param appID
	 *            The appID of the specific application.
	 * @return Returns a String with the SQL statement.
	 */
	static String generateCheckResourceExistenceSQLStmt(String appID, String userID) {
		String sql = "SELECT User_ID, App_ID" 
					+ " FROM View" 
					+ " WHERE App_ID LIKE '"	+ appID + "' AND User_ID LIKE '" + userID + "';";
		return sql;
	}
	
	
	// wird nicht benötigt und in der nächsten Version entfernt
	/**
	 * Generates the SQL statement to create a view about user and app pair.
	 * 
	 * @param userID
	 *            The userID of an specific user.
	 * @param appID
	 *            The appID of the specific application.
	 * @return Returns a String with the SQL statement.
	 */
	/*static String genearteCreateViewSQLStmt(String appID, String userID){
		String sql = "CREATE VIEW " + appID + userID + "View AS" 
					+ " SELECT Users.User_ID, Users.Surname, Users.Forename, Users.Company, Users.Mail," 
					+ " Applications.App_ID, Applications.ApplicationName, Applications.ApplicationVersion, UserResources.Resource_ID, Resources.ResourceName," 
					+ " UserRoles.Role_ID, Roles.RoleName, Roles.Permission_ID," 
					+ " Permissions.PermissionName, Permissions.PermissionLevel" 
					+ " FROM Users INNER JOIN ((Permissions RIGHT JOIN Roles ON Permissions.Permission_ID = Roles.Permission_ID)" 
					+ " RIGHT JOIN ((Resources RIGHT JOIN (Applications INNER JOIN UserResources ON" 
					+ " Applications.App_ID = UserResources.App_ID) ON Resources.Resource_ID = UserResources.Resource_ID)" 
					+ " INNER JOIN UserRoles ON Applications.App_ID = UserRoles.App_ID) ON Roles.Role_ID = UserRoles.Role_ID)" 
					+ " ON (Users.User_ID = UserRoles.User_ID) AND (Users.User_ID = UserResources.User_ID)" 
					+ " WHERE (((Users.User_ID)='" + userID + "') AND ((Applications.App_ID)= " + appID + "));";
		return sql;
	}
	*/
	
	/**
	 * Generates the SQL statement to delete a view.
	 * 
	 * @param userID
	 *            The userID of an specific user.
	 * @param appID
	 *            The appID of the specific application.
	 * @return Returns a String with the SQL statement.
	 */
	static String generateDropTableSQLStmt(String table){
		String sql ="DROP TABLE " + table + "View;";
		return sql;
	}
	

}
