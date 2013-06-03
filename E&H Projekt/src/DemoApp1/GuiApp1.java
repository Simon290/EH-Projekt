package DemoApp1;

/*
 * imports
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Test.GuiTest;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
@SuppressWarnings("serial")
public class GuiApp1 extends javax.swing.JFrame {

	private static JButton bLogin;
	private static JTextField tfUserName;
	private static JButton bDelete;
	private JLabel lResources;
	private JLabel lPassword;
	private static JButton bUpdateData;
	private JLabel lLevel;
	private JLabel lPermission;
	private JLabel lRolle;
	private static JButton bLogout;
	private JLabel lUserID;
	private JSeparator jSeparator2;
	private static JButton bUpdate;
	private static JButton bWrite;
	private static JButton bRead;
	static private JTextField tfRole;
	static private JTextField tfLevel;
	private static JComboBox<String> cbRecources;
	private static JTextField tfPermissions;
	private static JTextField tfUserPassword;
	private JSeparator jSeparator1;

	static String appID = "1";

	/**
	 * Constructor initializes the Gui of App 1
	 */
	public GuiApp1() {
		super();
		initGUI();
	}

	/**
	 * Method initializes the Gui, sets all Buttons and creates the event Handlers.
	 */
	private void initGUI() {
		try {
			this.setTitle("Application 1");
			this.setResizable(false);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setFocusableWindowState(true);
			{
				bLogin = new JButton();
				getContentPane().add(bLogin);
				bLogin.setText("Login");
				bLogin.setBounds(242, 12, 100, 23);
				bLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Actions.btnLogin();
					}
				});
			}
			{
				tfUserName = new JTextField();
				getContentPane().add(getTfUserName());
				tfUserName.setBounds(12, 30, 82, 23);
			}
			{
				tfUserPassword = new JPasswordField();
				getContentPane().add(getTfUserPassword());
				tfUserPassword.setBounds(124, 30, 100, 23);
				tfUserPassword.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Actions.btnLogin();
					}
				});
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(12, 69, 355, 10);
			}
			{
				tfPermissions = new JTextField();
				getContentPane().add(getTfPermissions());
				tfPermissions.setText("Permissions");
				tfPermissions.setBounds(124, 100, 100, 21);
				tfPermissions.setEditable(false);
			}
			{
				ComboBoxModel<String> cbRecourcesModel = new DefaultComboBoxModel<String>(
						new String[] {});
				cbRecourcesModel.setSelectedItem("");
				cbRecources = new JComboBox<String>();
				getContentPane().add(cbRecources);
				cbRecources.setModel(cbRecourcesModel);
				cbRecources.setBounds(12, 159, 125, 21);
			}
			{
				tfLevel = new JTextField();
				getContentPane().add(tfLevel);
				tfLevel.setText("Level");
				tfLevel.setEditable(false);
				tfLevel.setBounds(236, 100, 42, 21);
				tfLevel.setSize(100, 21);
			}
			{
				tfRole = new JTextField();
				getContentPane().add(tfRole);
				tfRole.setText("Rolle");
				tfRole.setEditable(false);
				tfRole.setBounds(12, 99, 89, 22);
				tfRole.setSize(100, 22);
			}
			{
				bRead = new JButton();
				getContentPane().add(bRead);
				bRead.setText("Read");
				bRead.setBounds(149, 158, 100, 23);
				bRead.setEnabled(false);
			}
			{
				bWrite = new JButton();
				getContentPane().add(bWrite);
				bWrite.setText("Write");
				bWrite.setBounds(149, 187, 100, 23);
				bWrite.setEnabled(false);
			}
			{
				bUpdate = new JButton();
				getContentPane().add(bUpdate);
				bUpdate.setText("Update");
				bUpdate.setBounds(260, 158, 100, 23);
				bUpdate.setEnabled(false);		
			}
			{
				bDelete = new JButton();
				getContentPane().add(bDelete);
				bDelete.setText("Delete");
				bDelete.setBounds(260, 187, 100, 23);
				bDelete.setEnabled(false);
			}
			{
				lResources = new JLabel();
				getContentPane().add(lResources);
				lResources.setText("Rescources:");
				lResources.setBounds(12, 137, 125, 16);
			}
			{
				jSeparator2 = new JSeparator();
				getContentPane().add(jSeparator2);
				jSeparator2.setBounds(12, 127, 356, 10);
			}
			{
				lUserID = new JLabel();
				getContentPane().add(lUserID);
				lUserID.setText("UserID");
				lUserID.setBounds(12, 8, 100, 16);
			}
			{
				lPassword = new JLabel();
				getContentPane().add(lPassword);
				lPassword.setText("Password");
				lPassword.setBounds(124, 8, 100, 16);
			}
			{
				bLogout = new JButton();
				getContentPane().add(bLogout);
				bLogout.setText("Logout");
				bLogout.setBounds(242, 40, 86, 23);
				bLogout.setSize(100, 23);
				bLogout.setEnabled(false);
				bLogout.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Actions.btnLogout();
					}
				});
			}
			{
				lRolle = new JLabel();
				getContentPane().add(lRolle);
				lRolle.setText("Rolle:");
				lRolle.setBounds(12, 77, 100, 16);
			}
			{
				lPermission = new JLabel();
				getContentPane().add(lPermission);
				lPermission.setText("Permission");
				lPermission.setBounds(124, 78, 100, 16);
			}
			{
				lLevel = new JLabel();
				getContentPane().add(lLevel);
				lLevel.setText("Level:");
				lLevel.setBounds(236, 78, 100, 16);
			}
			{
				bUpdateData = new JButton();
				getContentPane().add(bUpdateData);
				bUpdateData.setText("UpdateData");
				bUpdateData.setEnabled(false);
				bUpdateData.setBounds(12, 187, 100, 23);
				bUpdateData.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Actions.btnUpdate();
					}
				});
			}
			this.setFocusCycleRoot(false);
			pack();
			this.setSize(384, 261);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Check weather the Login is done
	 *    
	 * @return returns weather the login is done
	 */
	public static JButton getbLogin() {
		return bLogin;
	}

	/**
	 * Get the Username from Textfield
	 *    
	 * @return returns Username
	 */
	public static JTextField getTfUserName() {
		return tfUserName;
	}

	/**
	 * Get the Password from Textfield
	 *    
	 * @return returns Password
	 */
	public static JTextField getTfUserPassword() {
		return tfUserPassword;
	}

	/**
	 * Get the Textfield Permissions
	 *     
	 * @return returns Textfield Permissions
	 */
	public static JTextField getTfPermissions() {
		return tfPermissions;
	}

	/**
	 * Get the Textfield Role
	 *     
	 * @return returns Textfield Role
	 */
	public static JTextField getTfRole() {
		return tfRole;
	}

	/**
	 * Get the ComboBox Resources
	 *     
	 * @return returns ComboBox Resources
	 */
	public static JComboBox<String> getCbResources() {
		return cbRecources;
	}

	/**
	 * Get the JButton Read
	 *     
	 * @return returns JButton Read
	 */
	public static JButton getbRead() {
		return bRead;
	}

	/**
	 * Get the JButton Write
	 *     
	 * @return returns JButton Write
	 */
	public static JButton getbWrite() {
		return bWrite;
	}

	/**
	 * Get the JButton Update
	 *     
	 * @return returns JButton Update
	 */
	public static JButton getbUpdate() {
		return bUpdate;
	}

	/**
	 * Get the JButton Delete
	 *     
	 * @return returns JButton Delete
	 */
	public static JButton getbDelete() {
		return bDelete;
	}

	/**
	 * Get the JButton Logout
	 *     
	 * @return returns JButton Logout
	 */
	public static JButton getbLogout() {
		return bLogout;
	}
	
	/**
	 * Get the JButton UpdateData
	 *     
	 * @return returns JButton UpdateData
	 */
	public static JButton getbUpdateData() {
		return bUpdateData;
	}

	/**
	 * Get the TextField Level
	 *     
	 * @return returns textField Level
	 */
	public static JTextField getTfLevel() {
		return tfLevel;
	}
	
	/**
	 * Sets all Components in Gui back to the Default Values
	 */
	public static void setDefault() {
		bRead.setEnabled(false);
		bWrite.setEnabled(false);
		bUpdate.setEnabled(false);
		bDelete.setEnabled(false);
		bUpdateData.setEnabled(false);
		tfPermissions.setText("Permissions");
		tfRole.setText("Rolle");
		tfLevel.setText("Level");
		tfUserName.setText("");
		tfUserPassword.setText("");
		bLogin.setEnabled(true);
		bLogout.setEnabled(false);
		cbRecources.removeAllItems();
		tfUserName.setEditable(true);
		tfUserPassword.setEditable(true);
		GuiTest.getBEditCache().setEnabled(false);
	}
	
	
	public static class Actions {
		/**
		 * Action listener for Login Button
		 */
		public static void btnLogin() {
			String userName = tfUserName.getText();
			String password = tfUserPassword.getText();
			GuiApp1Code.Login(appID, userName, password);
		}

		/**
		 * Action Listener for Logout Button
		 */
		public static void btnLogout() {
			String userName = tfUserName.getText();
			GuiApp1Code.Logout(appID, userName);
		}
		
		/**
		 * Action Listener for Logout Button
		 */
		public static void btnUpdate() {
			String userName = tfUserName.getText();
			GuiApp1Code.update(appID, userName);
		}
	}

}