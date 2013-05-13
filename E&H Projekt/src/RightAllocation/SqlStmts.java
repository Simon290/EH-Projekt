package RightAllocation;

public class SqlStmts {
	
	static String generateUserInfoSQLStmt(String userId){
		String sql = "SELECT * FROM Users WHERE User_ID =" + userId;
		return sql;
	}
	
	static String generateRechteAbfragenStmt(String appId, String userId, String rightsId){
		String sql = "SELECT * FROM Table_Roles WHERE Role_ID =" + rightsId + ";";
		return sql;
	}

	static String generateAppInfoSQLStmt(String appId){
		String sql = "SELECT * FROM Applications WHERE App_ID =" + appId + ";";
		return sql;
	}
	
	
}
