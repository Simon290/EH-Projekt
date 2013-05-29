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
import java.sql.SQLException;
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
	public static void connect() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager
					.getConnection("jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="
							+ path + "\\Database\\Rechteverwaltung.accdb");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Disconnecting the database.
	 * 
	 * @throws Exception
	 *             Throws exception if the disconnection failed.
	 */
	public static void disconnect() {
		try {
			rs.close();
		
			stmt.close();
		
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public static String[][] sqlQuery(String sqlStmt) {
		String[][] result = null;
		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sqlStmt);
			ResultSetMetaData rsmd = rs.getMetaData();
			int clmCnt = rsmd.getColumnCount();
			int rowCnt = 0;
			while (rs.next()) {
				rowCnt++;
			}
			result = new String[rowCnt][clmCnt];
			rs = stmt.executeQuery(sqlStmt);

			int r = 0;
			while (rs.next()) {
				for (int i = 1; i <= clmCnt; i++) {
					result[r][i - 1] = rs.getString(i);
				}
				r++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}