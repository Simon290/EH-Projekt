package DemoApp1;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import RightAllocation.Main;

public class GuiApp1Code {

	static GuiApp1 gui;

	public GuiApp1Code(GuiApp1 gui) {
		this.gui = gui;
	}

	public static void Login(String appID, String userName, String password) {
		System.out.println("Login wird ausgeführt");

		boolean b;
		b = Main.login(appID, userName, password);
		if (b) {
			setPermissions(appID, userName);
			setResources(appID, userName);
			JOptionPane.showMessageDialog(null, "Login war erfolgreich");
		} else {
			JOptionPane.showMessageDialog(null, "Login fehlgeschlagen");
		}

	}

	public static void setResources(String appID, String userID) {
		// set Resources
		String[] resources;
		resources = Main.getRecources(appID, userID);
		JComboBox<String> cbResources = GuiApp1.getCbResources();

		cbResources.removeAllItems();
		for (int i = 0; i < resources.length; i++) {
			cbResources.addItem(resources[i]);
		}
	}

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
		}
	}
}