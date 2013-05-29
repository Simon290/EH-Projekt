package DemoApp1;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import RightAllocation.Main;

public class GuiApp1Code {

	/**
	 * This Method is called, when the Login Button is pressed
	 *     
	 * @param appID
	 * 		The AppID of the current Application
	 * 
	 * @param userID
	 * 		the UserId of the Current User
	 * 
	 * @param password
	 * 		the Password of the current User
	 */
	public static void Login(String appID, String userID, String password) {

		if (Main.checkPassword(appID, userID, password)) {
			System.out.println("Login erfolgreich");
			if(Main.hasRole(appID, userID)){				
				System.out.println("Role vorhanden");
				if(Main.hasResources(appID, userID)){
					System.out.println("Ressourcen vorhanden");
					Main.loadData(appID, userID);
					setRole(appID, userID);
					setPermissions(appID, userID);
					setResources(appID, userID);
					JOptionPane.showMessageDialog(null, "Login war erfolgreich");
					GuiApp1.getbLogin().setEnabled(false);
					GuiApp1.getbLogout().setEnabled(true);
					GuiApp1.getTfUserName().setEditable(false);
					GuiApp1.getTfUserPassword().setEditable(false);
				}
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Login fehlgeschlagen");
		}
	}

	/**
	 * Gets the Resources from Cache and writes them in the Combo Box
	 *     
	 * @param appID
	 * 		The AppID of the current Application
	 * 
	 * @param userID
	 * 		the UserId of the Current User
	 */
	public static void setResources(String appID, String userID) {
		String[] resources;
		resources = Main.getRecources(appID, userID);
		JComboBox<String> cbResources = GuiApp1.getCbResources();

		cbResources.removeAllItems();
		for (int i = 0; i < resources.length; i++) {
			cbResources.addItem(resources[i]);
		}
	}

	/**
	 * Gets the Permissions from Cache and writes them in the Textfield
	 *     
	 * @param appID
	 * 		The AppID of the current Application
	 * 
	 * @param userID
	 * 		the UserId of the Current User
	 */
	public static void setPermissions(String appID, String userID) {
		// set Permissions
		String[] permissions;
		permissions = Main.getPermission(appID, userID);

		JTextField tfPermissions = GuiApp1.getTfPermissions();
		JTextField tfLevel = GuiApp1.getTfLevel();

		tfPermissions.setText(permissions[0]);
		tfLevel.setText(permissions[1]);

		setButtons(permissions[0]);
	}

	/**
	 * Gets the Role from Cache and writes them in the Textfield
	 *     
	 * @param appID
	 * 		The AppID of the current Application
	 * 
	 * @param userID
	 * 		the UserId of the Current User
	 */
	public static void setRole(String appID, String userID) {
		String role = Main.getRole(appID, userID);
		GuiApp1.getTfRole().setText(role);
	}

	/**
	 * Sets the Buttons enable or disable, related to the Permission which is set.
	 *     
	 * @param permission
	 * 		The highest Permission
	 */
	private static void setButtons(String permission) {
		switch (permission) {
		case "Read":
			GuiApp1.getbRead().setEnabled(true);
			break;
		case "Create":
			GuiApp1.getbRead().setEnabled(true);
			GuiApp1.getbWrite().setEnabled(true);
			break;
		case "Update":
			GuiApp1.getbRead().setEnabled(true);
			GuiApp1.getbWrite().setEnabled(true);
			GuiApp1.getbUpdate().setEnabled(true);
			break;
		case "Delete":
			GuiApp1.getbRead().setEnabled(true);
			GuiApp1.getbWrite().setEnabled(true);
			GuiApp1.getbUpdate().setEnabled(true);
			GuiApp1.getbDelete().setEnabled(true);
			break;
		default:
			GuiApp1.getbRead().setEnabled(false);
			GuiApp1.getbWrite().setEnabled(false);
			GuiApp1.getbUpdate().setEnabled(false);
			GuiApp1.getbDelete().setEnabled(false);
		}
	}

	/**
	 * This Method is called, when the Button Logout is pressed
	 *     
	 * @param appID
	 * 		The AppID of the current Application
	 * 
	 * @param userID
	 * 		the UserId of the Current User
	 */
	public static void Logout(String appID, String userID) {
		Main.deleteData(appID, userID);
		GuiApp1.setDefault();
	}
}