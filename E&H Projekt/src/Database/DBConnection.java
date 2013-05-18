/*
 * @author Pascal
 * @version 2.03
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
				.getConnection("jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="
						+ path + "\\Database\\Rechteverwaltung.accdb");
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
	 * Disconnecting the database after creating a view.
	 * 
	 * @throws Exception
	 *             Throws exception if the disconnection failed.
	 */
	public static void viewDisconnect() throws Exception {
		stmt.close();
		con.close();
	}

	/**
	 * Interprets a SQL statement.
	 * 
	 * @param sqlStmt
	 *            The SQl statement to interpret.
	 * @return Returns the result of the SQL statement.
	 * @throws Exception
	 *             Throws exception if the SQL statement was wrong.
	 */
	public static String[] sqlQuery(String sqlStmt) throws Exception {		
		stmt = con.createStatement();

		rs = stmt.executeQuery(sqlStmt);
		ResultSetMetaData rsmd = rs.getMetaData();
		int clmCnt = rsmd.getColumnCount();
		String[] result = new String[clmCnt];

		while (rs.next()) {
			for (int i = 1; i <= clmCnt; i++) {
				result[i-1] = rs.getString(i);
			}
		}

		return result;
	}
	
	/**
	 * Creates a view in the database. Deletes an existing view, if existing.
	 * 
	 * @param sqlStmt
	 *            The SQl statement to create a view.
	 * @throws Exception
	 *             Throws exception if the SQL statement was wrong.
	 */
	public static void createView(String sqlStmt) throws Exception {
		stmt = con.createStatement();
		try{
			stmt.execute("DROP TABLE userAppPairView;");
		} catch (Exception e){

		}
		stmt.execute(sqlStmt);			
	}
}