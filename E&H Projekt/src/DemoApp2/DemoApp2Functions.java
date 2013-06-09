/**
 * @author Pascal Grunau, Simon Riedinger, Sarah Weinbecker, Anika Rist. Sebastian Abb
 * @version 1.0
 */

package DemoApp2;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Database.DBConnection;
import RightAllocation.MainClass;
import Test.GuiTest;

/**
 * Functions for demo application 2.
 */
public class DemoApp2Functions {

	/**
	 * This method is called, when the login button is pressed.
	 * 
	 * @param appID
	 *            The appID of the current application.
	 * 
	 * @param userID
	 *            The userID of the current user.
	 * 
	 * @param password
	 *            The password of the current user.
	 */
	public static void Login(String appID, String userID, String password) {
		if (DBConnection.checkDBConnection()) {
			if (MainClass.checkPassword(appID, userID, password)) {
				JOptionPane.showMessageDialog(null, "Login erfolgreich!", "",
						JOptionPane.INFORMATION_MESSAGE);
				DemoApp2.getbLogin().setEnabled(false);
				DemoApp2.getbLogout().setEnabled(true);
				DemoApp2.getTfUserName().setEditable(false);
				DemoApp2.getTfUserPassword().setEditable(false);
				MainClass.loadData(appID, userID);
				if (MainClass.hasRole(appID, userID)) {
					setRole(appID, userID);
					setPermissions(appID, userID);
					if (MainClass.hasResources(appID, userID)) {
						setResources(appID, userID);
						DemoApp2.getbUpdateData().setEnabled(true);
						GuiTest.getJBAddRes2().setEnabled(true);
					}
				}
			}
		}
	}

	/**
	 * Gets the resources from the cache and updates the gui.
	 * 
	 * @param appID
	 *            The appID of the current application.
	 * 
	 * @param userID
	 *            The userID of the current user.
	 */
	public static void update(String appID, String userID) {
		setResources(appID, userID);
	}

	/**
	 * Gets the resources from the cache and writes them in the combo box.
	 * 
	 * @param appID
	 *            The appID of the current application.
	 * 
	 * @param userID
	 *            The userID of the current user.
	 */
	public static void setResources(String appID, String userID) {
		String[] resources;
		resources = MainClass.getRecources(appID, userID);
		JTextArea taRes = DemoApp2.getTaResources();
		String s = "";
		for (int i = 0; i < resources.length; i++) {
			s = s + resources[i] + "\n";
		}
		taRes.setText(s);
	}

	/**
	 * Gets the permissions from the cache and writes them in the textfield.
	 * 
	 * @param appID
	 *            The appID of the current application.
	 * 
	 * @param userID
	 *            The userID of the current user.
	 */
	public static void setPermissions(String appID, String userID) {
		String[] permissions;
		permissions = MainClass.getPermission(appID, userID);

		JTextField tfPermissions = DemoApp2.getTfPermissions();
		JTextField tfLevel = DemoApp2.getTfLevel();
		tfPermissions.setText(permissions[0]);
		tfLevel.setText(permissions[1]);

		setButtons(permissions[0]);
	}

	/**
	 * Gets the role from the cache and writes them in the textfield.
	 * 
	 * @param appID
	 *            The appID of the current application.
	 * 
	 * @param userID
	 *            The userID of the current user.
	 */
	public static void setRole(String appID, String userID) {
		String role = MainClass.getRole(appID, userID);
		DemoApp2.getTfRole().setText(role);
	}

	/**
	 * Sets the buttons enable or disable, related to the permission which is
	 * set.
	 * 
	 * @param permission
	 *            The highest permission.
	 */
	private static void setButtons(String permission) {
		switch (permission) {
		case "Read":
			DemoApp2.getbRead().setEnabled(true);
			break;
		case "Create":
			DemoApp2.getbRead().setEnabled(true);
			DemoApp2.getbWrite().setEnabled(true);
			break;
		case "Update":
			DemoApp2.getbRead().setEnabled(true);
			DemoApp2.getbWrite().setEnabled(true);
			DemoApp2.getbUpdate().setEnabled(true);
			break;
		case "Delete":
			DemoApp2.getbRead().setEnabled(true);
			DemoApp2.getbWrite().setEnabled(true);
			DemoApp2.getbUpdate().setEnabled(true);
			DemoApp2.getbDelete().setEnabled(true);
			break;
		default:
			DemoApp2.getbRead().setEnabled(false);
			DemoApp2.getbWrite().setEnabled(false);
			DemoApp2.getbUpdate().setEnabled(false);
			DemoApp2.getbDelete().setEnabled(false);
		}
	}

	/**
	 * This method is called, when the button logout is pressed.
	 * 
	 * @param appID
	 *            The appID of the current application.
	 * 
	 * @param userID
	 *            The userID of the current user.
	 */
	public static void Logout(String appID, String userID) {
		MainClass.deleteData(appID, userID);
		DemoApp2.setDefault();
	}
}
