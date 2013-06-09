/**
 * @author Pascal Grunau, Simon Riedinger, Sarah Weinbecker, Anika Rist. Sebastian Abb
 * @version 1.0
 */

package DemoApp1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
 * Gui Demo application 1.
 */
@SuppressWarnings("serial")
public class DemoApp1 extends javax.swing.JFrame {

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
	 * Constructor initializes the gui of application 2.
	 */
	public DemoApp1() {
		super();
		initGUI();
	}

	/**
	 * Method initializes the gui, sets all buttons and creates the Event
	 * Handlers.
	 */
	private void initGUI() {
		try {
			this.setTitle("Application 1");
			this.setResizable(false);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					Actions.btnLogout();
				}
			});
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
				lResources.setText("Resources");
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
				lRolle.setText("Role");
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
				lLevel.setText("Level");
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
	 * Gets the button-object from the login button.
	 * 
	 * @return Returns the button.
	 */
	public static JButton getbLogin() {
		return bLogin;
	}

	/**
	 * Gets the textfield-object from the username textfield.
	 * 
	 * @return Returns the textfield.
	 */
	public static JTextField getTfUserName() {
		return tfUserName;
	}

	/**
	 * Gets the textfield-object from the userpassword textfield.
	 * 
	 * @return Returns the textfield.
	 */
	public static JTextField getTfUserPassword() {
		return tfUserPassword;
	}

	/**
	 * Gets the textfield-object from the permmission textfield.
	 * 
	 * @return Returns the textfield.
	 */
	public static JTextField getTfPermissions() {
		return tfPermissions;
	}

	/**
	 * Gets the textfield-object from the role textfield.
	 * 
	 * @return Returns the textfield.
	 */
	public static JTextField getTfRole() {
		return tfRole;
	}

	/**
	 * Get the comboBox-object Resources.
	 * 
	 * @return Returns the ComboBox. 
	 */
	public static JComboBox<String> getCbResources() {
		return cbRecources;
	}

	/**
	 * Gets the button-object from the read button.
	 * 
	 * @return Returns the button.
	 */
	public static JButton getbRead() {
		return bRead;
	}

	/**
	 * Gets the button-object from the write button.
	 * 
	 * @return Returns the button.
	 */
	public static JButton getbWrite() {
		return bWrite;
	}

	/**
	 * Gets the button-object from the update button.
	 * 
	 * @return Returns the button.
	 */
	public static JButton getbUpdate() {
		return bUpdate;
	}

	/**
	 * Gets the button-object from the delete button.
	 * 
	 * @return Returns the button.
	 */
	public static JButton getbDelete() {
		return bDelete;
	}

	/**
	 * Gets the button-object from the logout button.
	 * 
	 * @return Returns the button.
	 */
	public static JButton getbLogout() {
		return bLogout;
	}

	/**
	 * Gets the button-object from the updateData button.
	 * 
	 * @return Returns the button.
	 */
	public static JButton getbUpdateData() {
		return bUpdateData;
	}

	/**
	 * Gets the textfield-object from the level textfield.
	 * 
	 * @return Returns the textfield.
	 */
	public static JTextField getTfLevel() {
		return tfLevel;
	}

	/**
	 * Sets all Components in gui back to the default values.
	 */
	public static void setDefault() {
		bRead.setEnabled(false);
		bWrite.setEnabled(false);
		bUpdate.setEnabled(false);
		bDelete.setEnabled(false);
		bUpdateData.setEnabled(false);
		tfPermissions.setText("Permissions");
		tfRole.setText("Role");
		tfLevel.setText("Level");
		tfUserName.setText("");
		tfUserPassword.setText("");
		bLogin.setEnabled(true);
		bLogout.setEnabled(false);
		cbRecources.removeAllItems();
		tfUserName.setEditable(true);
		tfUserPassword.setEditable(true);
		GuiTest.getJBAddRes1().setEnabled(false);
	}

	/**
	 * Contains the functions for the buttons.
	 */
	public static class Actions {
		/**
		 * Action for login button.
		 */
		public static void btnLogin() {
			String userName = tfUserName.getText();
			String password = tfUserPassword.getText();
			DemoApp1Functions.Login(appID, userName, password);
		}

		/**
		 * Action for logout button.
		 */
		public static void btnLogout() {
			String userName = tfUserName.getText();
			DemoApp1Functions.Logout(appID, userName);
		}

		/**
		 * Action for updateData button.
		 */
		public static void btnUpdate() {
			String userName = tfUserName.getText();
			DemoApp1Functions.update(appID, userName);
		}
	}

}