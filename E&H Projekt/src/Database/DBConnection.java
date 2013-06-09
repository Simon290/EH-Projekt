/**
 * @author Pascal Grunau, Simon Riedinger, Sarah Weinbecker, Anika Rist. Sebastian Abb
 * @version 1.0
 */

package Database;

import java.awt.Dimension;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *  Manages the connection to the database. Also interprets the SQL statement.
 */
public class DBConnection {

	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;

	private static String path = System.getProperty("user.dir");

	/**
	 * Establish the connection to the database.
	 */
	public static void connect() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			errorHandling(e, "Fehler beim Laden des Treibers!");
		}
		try {
			con = DriverManager
					.getConnection("jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="
							+ path + "\\Data\\Rechteverwaltung.accdb");
				
		} catch (SQLException e) {
			errorHandling(e, "Fehler bei Verbindungsaufbau zur Datenbank!");
		}
	}

	/**
	 * Disconnects the database.
	 */
	public static void disconnect() {
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			errorHandling(e, "Fehler bei Verbindungsabbau zur Datenbank!");
		}
	}

	/**
	 * Interprets a SQL statement.
	 * 
	 * @param sqlStmt
	 *            The SQl statement to interpret.
	 * @return Returns the result of the SQL statement.
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
			errorHandling(e, "Fehler im SQL Statment!");
		}
		return result;
	}

	/**
	 * Handles the different errors. Shows an info dialog, with a short
	 * description of the error and the option to show the whole errormessage.
	 * 
	 * @param ex
	 *            the occurred error.
	 * @param dialogText
	 *            Short description of the error.
	 */
	public static void errorHandling(Exception ex, String dialogText) {
		String[] buttons = { "OK", "Details" };
		int jop = JOptionPane.showOptionDialog(null, dialogText, "Fehler",
				JOptionPane.ERROR_MESSAGE, 0, null, buttons, buttons[0]);
		if (jop == 1) {
			Writer writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter(writer);
			ex.printStackTrace(printWriter);
			String s = writer.toString();
			JTextArea textBox = new JTextArea(s);
			textBox.setBorder(null);
			textBox.setEditable(false);
			textBox.setLineWrap(true);
			JScrollPane scrollPane = new JScrollPane(textBox);
			scrollPane.setPreferredSize(new Dimension(600, 200));
			JOptionPane.showMessageDialog(null, scrollPane, "Fehler-Details",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/**
	 * Initial connect to avoid a delay at the first regular connection to the DB.
	 */
	public static void firstInit() {
		connect();	
	}

	/**
	 * Checks existence of the DB.
	 * 
	 * @return True if DB exists. False if not.
	 */
	public static boolean checkDBConnection() {
		File f = new File(path + "\\Data\\Rechteverwaltung.accdb");

		if (f.exists()) {
			return true;
		} else {
			connect();
			return false;
		}
	}

	/**
	 * Just for testing. Sets the path to the database.
	 * 
	 * @param p
	 *            the new Path
	 */
	public static void setPath(String p) {
		path = p;
	}

}