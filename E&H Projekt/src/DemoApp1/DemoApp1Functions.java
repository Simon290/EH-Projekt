/**
 * @author Pascal Grunau, Simon Riedinger, Sarah Weinbecker, Anika Rist. Sebastian Abb
 * @version 1.0
 */

package DemoApp1;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Database.DBConnection;
import RightAllocation.MainClass;
import Test.GuiTest;

/**
 * Functions for demo application 2.
 */
public class DemoApp1Functions {

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
				DemoApp1.getbLogin().setEnabled(false);
				DemoApp1.getbLogout().setEnabled(true);
				DemoApp1.getTfUserName().setEditable(false);
				DemoApp1.getTfUserPassword().setEditable(false);
				MainClass.loadData(appID, userID);
				if (MainClass.hasRole(appID, userID)) {
					setRole(appID, userID);
					setPermissions(appID, userID);
					if (MainClass.hasResources(appID, userID)) {
						setResources(appID, userID);
						DemoApp1.getbUpdateData().setEnabled(true);
						GuiTest.getJBAddRes1().setEnabled(true);
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

		JComboBox<String> cbResources = DemoApp1.getCbResources();

		cbResources.removeAllItems();
		for (int i = 0; i < resources.length; i++) {
			cbResources.addItem(resources[i]);
		}
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

		JTextField tfPermissions = DemoApp1.getTfPermissions();
		JTextField tfLevel = DemoApp1.getTfLevel();
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
		DemoApp1.getTfRole().setText(role);
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
			DemoApp1.getbRead().setEnabled(true);
			break;
		case "Create":
			DemoApp1.getbRead().setEnabled(true);
			DemoApp1.getbWrite().setEnabled(true);
			break;
		case "Update":
			DemoApp1.getbRead().setEnabled(true);
			DemoApp1.getbWrite().setEnabled(true);
			DemoApp1.getbUpdate().setEnabled(true);
			break;
		case "Delete":
			DemoApp1.getbRead().setEnabled(true);
			DemoApp1.getbWrite().setEnabled(true);
			DemoApp1.getbUpdate().setEnabled(true);
			DemoApp1.getbDelete().setEnabled(true);
			break;
		default:
			DemoApp1.getbRead().setEnabled(false);
			DemoApp1.getbWrite().setEnabled(false);
			DemoApp1.getbUpdate().setEnabled(false);
			DemoApp1.getbDelete().setEnabled(false);
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
		DemoApp1.setDefault();
	}
}