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
	private String[] permissions;
	private String[] resources;
	private String timeStamp;
	
	
		
	/**
	 * Constructor: Generates a cache object with the current time as timestamp. 
	 */
	public Cache(){
		timeStamp = getCurrentTimeAsString();
	}
	
	/*
	 * Methods
	 */
	
	/**
	 * Returns an array of strings with the userinfo.
	 * 
	 * @return returns userinfo.
	 */
	public String[] getUserInfo() {
		return userInfo;
	}

	/**
	 * Sets the userinfo.
	 * 
	 * @param userInfo
	 */
	public void setUserInfo(String[][] userInfo) {
		int lng = userInfo[0].length;
		String[] userinf = new String[lng];
		
		for(int i = 0; i < lng; i++){
			userinf[i] = userInfo[0][i];
		}
		
		this.userInfo = userinf;
	}

	/**
	 * Returns an array of strings with the appinfo.
	 * 
	 * @return returns userinfo.
	 */
	public String[] getAppInfo() {
		return appInfo;
	}

	/**
	 * Sets the appinfo.
	 * 
	 * @param appInfo
	 */
	public void setAppInfo(String[][] appInfo) {
		int lng = appInfo[0].length;
		String[] appinf = new String[lng];
		
		for(int i = 0; i < lng; i++){
			appinf[i] = appInfo[0][i];
		}
		
		this.appInfo = appinf;
	}

	/**
	 * Returns an array of strings with the rights.
	 * 
	 * @return returns rights.
	 */
	public String[] getPermissions() {
		return permissions;
	}

	/**
	 * Sets the rights.
	 * 
	 * @param permissions
	 */
	public void setPermissions(String[][] permissions) {
		int lng = permissions[0].length;
		String[] perm = new String[lng];
		
		for(int i = 0; i < lng; i++){
			perm[i] = permissions[0][i];
		}
		
		this.permissions = perm;
	}

	/**
	 * Returns an array of strings with the resources.
	 * 
	 * @return returns resources.
	 */
	public String[] getResources() {
		return resources;
	}

	/**
	 * Sets the resources.
	 * 
	 * @param resources
	 */
	public void setResources(String[][] resources) {
		int lng = resources.length;
		String[] res = new String[lng];
		
		for(int i = 0; i < lng; i++){
			res[i] = resources[i][0];
		}
		
		this.resources = res;
	}

	/**
	 * Returns a strings with the timestamp of the object, set by creating the object.
	 * 
	 * @return returns timestamp.
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Sets the timestamp.
	 * 
	 * @param timeStamp
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	/**
	 * Loads the data for the user app pair from the database into the cache-object of the user app pair.
	 * 
	 * @param appID	The appID from a specific application.
	 * @param userID	The userID of a specific user.
	 */
	public void addData(String appID, String userID){
		String[][] sqlResultUserInfo = new String[0][0];
		String[][] sqlResultAppInfo = new String[0][0];
		String[][] sqlResultPermissions = new String[0][0];
		String[][] sqlResultResources = new String[0][0];
	
		
		try {
			DBConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {	
			sqlResultUserInfo = DBConnection.sqlQuery(SqlStmts.generateSelectFromViewSqlStmt(appID, userID, "User_ID, Surname, Forename, Company, Mail"));
			sqlResultAppInfo = DBConnection.sqlQuery(SqlStmts.generateSelectFromViewSqlStmt(appID, userID, "App_ID, ApplicationName, ApplicationVersion"));
			sqlResultPermissions = DBConnection.sqlQuery(SqlStmts.generateSelectFromViewSqlStmt(appID, userID, "PermissionName, PermissionLevel"));
			sqlResultResources = DBConnection.sqlQuery(SqlStmts.generateSelectFromViewSqlStmt(appID, userID, "ResourceName"));
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
		
		setUserInfo(sqlResultUserInfo);
		setAppInfo(sqlResultAppInfo);
		setPermissions(sqlResultPermissions);
		setResources(sqlResultResources);		
	}

	/**
	 * Returns a string with the current timestamp. Format: dd.MM.yyyy HH:mm:ss
	 * 
	 * @return returns timestamp.
	 */
	static private String getCurrentTimeAsString() {
	    DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"); 
	    formatter.setTimeZone(TimeZone.getTimeZone("GMT+2:00"));
	    return formatter.format(new Date());
	}	

}