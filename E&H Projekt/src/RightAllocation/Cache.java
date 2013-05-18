package RightAllocation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import Database.DBConnection;



public class Cache {
	
	/*
	 * Attributes 
	 */	
	private String[] userInfo;
	private String[] appInfo;
	private String[] rights;
	private String[] resources;
	private String timeStamp;
	
	
	/*
	 * Constructor
	 */
	public Cache(){
		timeStamp = getCurrentTimeAsString();
	}
	
	/*
	 * Methods
	 */
	public String[] getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String[] userInfo) {
		this.userInfo = userInfo;
	}

	public String[] getAppInfo() {
		return appInfo;
	}

	public void setAppInfo(String[] appInfo) {
		this.appInfo = appInfo;
	}

	public String[] getRights() {
		return rights;
	}

	public void setRights(String[] rights) {
		this.rights = rights;
	}

	public String[] getResources() {
		return resources;
	}

	public void setResources(String[] resources) {
		this.resources = resources;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public void addData(String appID, String userID){
		String[] sqlResultUserInfo = new String[0];
		String[] sqlResultAppInfo = new String[0];
		String[] sqlResultRigths = new String[0];
		String[] sqlResultResources = new String[0];
	
		
		try {
			DBConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			/*			
			sqlResultUserInfo = DBConnection.sql(SqlStmts.generateGetUserInfoSQLStmt(userID));
			sqlResultAppInfo = DBConnection.sql(SqlStmts.generateGetAppInfoSQLStmt(appID));
			sqlResultRigths = DBConnection.sql(SqlStmts.generateGetRightsSQLStmt(tableRoles[0], roleID[0]));
			sqlResultResources = DBConnection.sql(SqlStmts.generateGetResourcesSQLStmt(tableResources[0], resourceID[0]));*/
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			DBConnection.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < sqlResultUserInfo.length; i++){
			System.out.println("1 " + sqlResultUserInfo[i]);
		}
		for (int ii = 0; ii < sqlResultAppInfo.length; ii++){
			System.out.println("2 " + sqlResultAppInfo[ii]);
		}
		for (int iii = 0; iii < sqlResultRigths.length; iii++){
			System.out.println("3 " + sqlResultRigths[iii]);
		}
		for (int iiii = 0; iiii < sqlResultResources.length; iiii++){
			System.out.println("4 " + sqlResultResources[iiii]);
		}
		
		setUserInfo(sqlResultUserInfo);
		setAppInfo(sqlResultAppInfo);
		setRights(sqlResultRigths);
		setResources(sqlResultResources);
		
	}

	static private String getCurrentTimeAsString() {
	    DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"); 
	    formatter.setTimeZone(TimeZone.getTimeZone("GMT+2:00"));
	    return formatter.format(new Date());
	}
	
	

}