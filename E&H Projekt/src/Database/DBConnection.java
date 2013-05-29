/*
 * @author Pascal
 * @version 2.03
 */

package Database;

/*
 * imports
 */
import java.awt.Dimension;
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
							+ path + "\\Database\\Rechteverwaltung.accdb");
		} catch (SQLException e) {
			errorHandling(e, "Fehler bei Verbindungsaufbau zur Datenbank!");
		}
	}

	/**
	 * Disconnecting the database.
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
	 * description of the error and option to show the hole errormessage.
	 * 
	 * @param ex	the occurred error
	 * @param dialogText	Short description of the error
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
			textBox.setAutoscrolls(true);
			JScrollPane scrollPane = new JScrollPane(textBox);
			scrollPane.setPreferredSize(new Dimension(600, 200));
			JOptionPane.showMessageDialog(null, scrollPane, "Fehler-Details",
					JOptionPane.WARNING_MESSAGE);
		}
	}

}