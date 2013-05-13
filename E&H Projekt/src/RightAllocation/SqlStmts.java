package RightAllocation;

public class SqlStmts {
	
	static String generateUserInfoSQLStmt(String userId){
		String sql = "SELECT * FROM Users WHERE User_ID =" + userId;
		return sql;
	}

}
