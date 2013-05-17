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
	 * Generates the SQL statement to get userID and appID if the pair exists.
	 * 
	 * @param userID
	 *            The userID of an specific user.
	 * @param appID
	 *            The appID of the specific application.
	 * @param parameter
	 *            The parameter which collums are selected. Comma separated
	 * @return Returns a String with the results.
	 */
	static String generateCheckExistenceSQLStmt(String appID, String userID, String parameter) {
		// Falls keine Parameter mitgegeben werden, selektiere alles
		if(parameter == ""){
			parameter = "*";
		}
		String sql = "SELECT User_ID, App_ID FROM Main " +
				"WHERE App_ID LIKE '"
				+ appID + "' AND User_ID LIKE '" + userID + "';";
		return sql;
	}



}
