package RightAllocation;

public class SqlStmts {
	
	static String generateUserInfoSQLStmt(String userId){
		String sql = "SELECT * FROM Users WHERE User_ID =" + userId + ";";
		return sql;
	}
	
	static String generateGetTableSQLStmt(String appId){
		String sql = "SELECT Table_Roles, Table_Ressources FROM Applications WHERE App_ID =" + appId + ";";
		return sql;
	}

}
