/*
 * @author Pascal
 * @version 2.0
 */

package Database;

/*
 * imports
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/*
 *  Manage the connection to the database. Also interpret the SQL statement.
 */

public class DBConnection {
	
	/*
	 * Static attributes needed for the database connection.
	 */
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	private static ResultSetMetaData rsmd;
	private static int clmCnt;
	
	private static String path = System.getProperty("user.dir");

	
	/**
	 * Establish the connection to the database.
	 * 
	 * @throws Exception
	 *             Throws exception if the connection failed.
	 */
	public static void connect() throws Exception {

		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con = DriverManager
				.getConnection("jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + path + "\\Database\\Rechteverwaltung.accdb");

	}

	/**
	 * Disconnecting the database.
	 * 
	 * @throws Exception
	 *             Throws exception if the disconnection failed.
	 */
	public static void disconnect() throws Exception {
		rs.close();
		stmt.close();
		con.close();
	}

	/**
	 * Establish the connection to the database.
	 * 
	 * @param sqlStmt
	 *            The SQl statement to interpret.
	 * @return Returns the result of the SQL statement.
	 * @throws Exception
	 *             Throws exception if the SQL statement was wrong.
	 */
	public static String sql(String sqlStmt) throws Exception {
		String result = "";
		stmt = con.createStatement();

		rs = stmt.executeQuery(sqlStmt);
		rsmd = rs.getMetaData();
		clmCnt = rsmd.getColumnCount();

		while (rs.next()) {
			for (int i = 1; i <= clmCnt; i++) {
				result = result + rs.getString(i) + "   ";
			}
			result = result + "\n";
		}

		return result;
	}
}