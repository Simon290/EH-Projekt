package RightAllocation;

public class SqlStmts {

	static String generateUserInfoSQLStmt(String userId) {
		String sql = "SELECT * FROM Users WHERE User_ID =" + userId + ";";
		return sql;
	}
	
	static String generateGetRoleIdSQLStmt(String userId, String appId) {
		String sql = "SELECT Role_ID, Ressource_ID FROM Main WHERE User_ID like '" + userId + "' AND App_ID like '" + appId + ";";
		return sql;
	}

	static String generateGetTableSQLStmt(String appId) {
		String sql = "SELECT Table_Roles, Table_Ressources FROM Applications WHERE App_ID ="
				+ appId + ";";
		return sql;
	}

}
