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
		

}
