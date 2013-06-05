package DemoApp2;


import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Database.DBConnection;
import DemoApp1.GuiApp1;
import RightAllocation.Main;
import Test.GuiTest;

public class GuiApp2Code {

	/**
	 * This Method is called, when the Login Button is pressed. 
	 * 
	 * @param appID
	 *            The AppID of the current Application
	 * 
	 * @param userID
	 *            the UserId of the Current User
	 * 
	 * @param password
	 *            the Password of the current User
	 */
	public static void Login(String appID, String userID, String password) {
		if (DBConnection.checkDBConnection()) {
			if (Main.checkPassword(appID, userID, password)) {
				JOptionPane.showMessageDialog(null, "Login erfolgreich!", "", JOptionPane.INFORMATION_MESSAGE);
				GuiApp2.getbLogin().setEnabled(false);
				GuiApp2.getbLogout().setEnabled(true);
				GuiApp2.getTfUserName().setEditable(false);
				GuiApp2.getTfUserPassword().setEditable(false);
				Main.loadData(appID, userID);
				if (Main.hasRole(appID, userID)) {
					setRole(appID, userID);
					setPermissions(appID, userID);
					if (Main.hasResources(appID, userID)) {						
						setResources(appID, userID);
						GuiApp2.getbUpdateData().setEnabled(true);
						GuiTest.getJBAddRes1().setEnabled(true);
					} 					
				}
			} 
		} 
	}

	/**
	 * Gets the Resources from Cache and updates the GUI.
	 * 
	 * @param appID
	 *            The AppID of the current Application
	 * 
	 * @param userID
	 *            the UserId of the Current User
	 */
	public static void update(String appID, String userID) {
		setResources(appID, userID);
	}

	/**
	 * Gets the Resources from Cache and writes them in the Combo Box.
	 * 
	 * @param appID
	 *            The AppID of the current Application
	 * 
	 * @param userID
	 *            the UserId of the Current User
	 */
	public static void setResources(String appID, String userID) {
		String[] resources;
		resources = Main.getRecources(appID, userID);
		JTextArea taRes = GuiApp2.getTaResources();
		String s = "";
		for (int i = 0; i < resources.length; i++) {
			s = s + resources[i] + "\n";			
		}
		taRes.setText(s);
	}

	/**
	 * Gets the Permissions from Cache and writes them in the textfield.
	 * 
	 * @param appID
	 *            The AppID of the current Application
	 * 
	 * @param userID
	 *            the UserId of the Current User
	 */
	public static void setPermissions(String appID, String userID) {
		String[] permissions;
		permissions = Main.getPermission(appID, userID);

		JTextField tfPermissions = GuiApp2.getTfPermissions();
		JTextField tfLevel = GuiApp2.getTfLevel();
		tfPermissions.setText(permissions[0]);
		tfLevel.setText(permissions[1]);

		setButtons(permissions[0]);
	}

	/**
	 * Gets the Role from Cache and writes them in the textfield.
	 * 
	 * @param appID
	 *            The AppID of the current Application
	 * 
	 * @param userID
	 *            the UserId of the Current User
	 */
	public static void setRole(String appID, String userID) {
		String role = Main.getRole(appID, userID);
		GuiApp2.getTfRole().setText(role);
	}

	/**
	 * Sets the Buttons enable or disable, related to the Permission which is
	 * set.
	 * 
	 * @param permission
	 *            The highest Permission
	 */
	private static void setButtons(String permission) {
		switch (permission) {
		case "Read":
			GuiApp2.getbRead().setEnabled(true);
			break;
		case "Create":
			GuiApp2.getbRead().setEnabled(true);
			GuiApp2.getbWrite().setEnabled(true);
			break;
		case "Update":
			GuiApp2.getbRead().setEnabled(true);
			GuiApp2.getbWrite().setEnabled(true);
			GuiApp2.getbUpdate().setEnabled(true);
			break;
		case "Delete":
			GuiApp2.getbRead().setEnabled(true);
			GuiApp2.getbWrite().setEnabled(true);
			GuiApp2.getbUpdate().setEnabled(true);
			GuiApp2.getbDelete().setEnabled(true);
			break;
		default:
			GuiApp2.getbRead().setEnabled(false);
			GuiApp2.getbWrite().setEnabled(false);
			GuiApp2.getbUpdate().setEnabled(false);
			GuiApp2.getbDelete().setEnabled(false);
		}
	}

	/**
	 * This Method is called, when the Button Logout is pressed.
	 * 
	 * @param appID
	 *            The AppID of the current Application
	 * 
	 * @param userID
	 *            the UserId of the Current User
	 */
	public static void Logout(String appID, String userID) {
		Main.deleteData(appID, userID);
		GuiApp2.setDefault();
	}
}
