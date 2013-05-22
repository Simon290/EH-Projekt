package DemoApp1;

import java.awt.Dialog;
import java.io.ObjectInputStream.GetField;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import RightAllocation.Main;

public class GuiApp1Code {

	static GuiApp1 gui;

	public GuiApp1Code(GuiApp1 gui) {
		this.gui = gui;
	}

	public static void Login(String userName, String password) {
		System.out.println("Login wird ausgeführt");

		boolean b;
		b = Main.login("1", userName, password);
		if (b) {
			JOptionPane.showMessageDialog(null, "Login war erfolgreich");
		} else {
			JOptionPane.showMessageDialog(null, "Login fehlgeschlagen");
		}


		setPermissions("1", userName);
		setResources("1" , userName);
	}

	public static void setResources(String appID, String userID) {
		// set Resources
		String[] resources;
		resources = Main.getRecources(appID, userID);
		JComboBox cbResources = GuiApp1.getCbResources();
		
		cbResources.removeAllItems();
		for (int i = 0; i < resources.length; i++) {
			cbResources.addItem(resources[i]);
		}
	}
	public static void setPermissions(String appID, String userID){
		// set Permissions
		String[] permissions;
		permissions = Main.getPermission(appID, userID);

		JTextArea taPermissions = GuiApp1.getTaPermissions();

		
		String permissionString = "";
		for (int i = 0; i < permissions.length; i++) {
			permissionString = permissionString + permissions[i];
		}
		taPermissions.setText(permissionString);
	}
}