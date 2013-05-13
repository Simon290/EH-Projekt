/*
 * @author Pascal
 * @version 1.0
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
	static Connection con;
	static Statement stmt;
	static ResultSet rs;
	static ResultSetMetaData rsmd;
	static int clmCnt;
	
	static String path = System.getProperty("user.dir");

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			connect();
		} catch (Exception e) {
			System.out.println("Database connection failed!");
			e.printStackTrace();
		}
		try {
			System.out.print(sql("SELECT User.Vorname, User.Name, User.Firma, User.Mail, Main.App_ID FROM User, Main WHERE User.User_ID = Main.User_ID;"));
		} catch (Exception e) {
			System.out.println("Connection failed!");
			e.printStackTrace();
		}
		try {
			disconnect();
		} catch (Exception e) {
			System.out.println("Database disconnection failed!");
			e.printStackTrace();
		}
	}

	/**
	 * Establish the connection to the database.
	 * 
	 * @throws Exception
	 *             Throws exception if the connection failed.
	 */
	static void connect() throws Exception {

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
	static void disconnect() throws Exception {
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
	static String sql(String sqlStmt) throws Exception {
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