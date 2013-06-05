package DemoApp2;

/*
 * imports
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
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
public class GuiApp2 extends javax.swing.JFrame {

	private static JButton bLogin;
	private static JTextField tfUserName;
	private static JButton bDelete;
	private JLabel lResources;
	private JLabel lPassword;
	private static JTextArea taRecources;
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
	private static JTextField tfPermissions;
	private static JTextField tfUserPassword;
	private JSeparator jSeparator1;

	static String appID = "2";

	/**
	 * Constructor initializes the Gui of App 2
	 */
	public GuiApp2() {
		super();
		initGUI();
	}

	/**
	 * Method initializes the Gui, sets all Buttons and creates the event
	 * Handlers.
	 */
	private void initGUI() {
		try {
			this.setTitle("Application 2");
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
				bLogin.setBounds(12, 125, 100, 23);
				bLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Actions.btnLogin();
					}
				});
			}
			{
				tfUserName = new JTextField();
				getContentPane().add(getTfUserName());
				tfUserName.setBounds(12, 30, 100, 23);
			}
			{
				tfUserPassword = new JPasswordField();
				getContentPane().add(getTfUserPassword());
				tfUserPassword.setBounds(12, 81, 100, 23);
				tfUserPassword.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Actions.btnLogin();
					}
				});
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(123, 6, 10, 236);
				jSeparator1.setOrientation(SwingConstants.VERTICAL);
			}
			{
				tfPermissions = new JTextField();
				getContentPane().add(getTfPermissions());
				tfPermissions.setText("Permissions");
				tfPermissions.setBounds(135, 82, 100, 21);
				tfPermissions.setEditable(false);
			}
			{
				tfLevel = new JTextField();
				getContentPane().add(tfLevel);
				tfLevel.setText("Level");
				tfLevel.setEditable(false);
				tfLevel.setBounds(133, 131, 102, 21);
			}
			{
				tfRole = new JTextField();
				getContentPane().add(tfRole);
				tfRole.setText("Rolle");
				tfRole.setEditable(false);
				tfRole.setBounds(135, 30, 100, 22);
			}
			{
				bRead = new JButton();
				getContentPane().add(bRead);
				bRead.setText("Read");
				bRead.setBounds(280, 30, 100, 23);
				bRead.setEnabled(false);
			}
			{
				bWrite = new JButton();
				getContentPane().add(bWrite);
				bWrite.setText("Write");
				bWrite.setBounds(280, 81, 100, 23);
				bWrite.setEnabled(false);
			}
			{
				bUpdate = new JButton();
				getContentPane().add(bUpdate);
				bUpdate.setText("Update");
				bUpdate.setBounds(280, 130, 100, 23);
				bUpdate.setEnabled(false);
			}
			{
				bDelete = new JButton();
				getContentPane().add(bDelete);
				bDelete.setText("Delete");
				bDelete.setBounds(280, 180, 100, 23);
				bDelete.setEnabled(false);
			}
			{
				lResources = new JLabel();
				getContentPane().add(lResources);
				lResources.setText("Resources");
				lResources.setBounds(133, 158, 103, 16);
			}
			{
				jSeparator2 = new JSeparator();
				getContentPane().add(jSeparator2);
				jSeparator2.setBounds(264, 6, 10, 236);
				jSeparator2.setOrientation(SwingConstants.VERTICAL);
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
				lPassword.setBounds(12, 59, 100, 16);
			}
			{
				bLogout = new JButton();
				getContentPane().add(bLogout);
				bLogout.setText("Logout");
				bLogout.setBounds(12, 155, 100, 23);
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
				lRolle.setBounds(135, 8, 100, 16);
			}
			{
				lPermission = new JLabel();
				getContentPane().add(lPermission);
				lPermission.setText("Permission");
				lPermission.setBounds(135, 59, 100, 16);
			}
			{
				lLevel = new JLabel();
				getContentPane().add(lLevel);
				lLevel.setText("Level");
				lLevel.setBounds(133, 109, 100, 16);
			}
			{
				bUpdateData = new JButton();
				getContentPane().add(bUpdateData);
				bUpdateData.setText("UpdateData");
				bUpdateData.setEnabled(false);
				bUpdateData.setBounds(12, 212, 100, 23);
				bUpdateData.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Actions.btnUpdate();
					}
				});
			}
			{
				taRecources = new JTextArea();
				taRecources.setEditable(false);
				JScrollPane sp = new JScrollPane(taRecources);
				sp.setBounds(133, 180, 100, 55);
				sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				getContentPane().add(sp);
			}
			this.setFocusCycleRoot(false);
			pack();
			this.setSize(402, 281);
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
	public static JTextArea getTaResources() {
		return taRecources;
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
		tfRole.setText("Role");
		tfLevel.setText("Level");
		tfUserName.setText("");
		tfUserPassword.setText("");
		bLogin.setEnabled(true);
		bLogout.setEnabled(false);
		taRecources.setText("");
		tfUserName.setEditable(true);
		tfUserPassword.setEditable(true);
		GuiTest.getJBAddRes2().setEnabled(false);

	}

	public static class Actions {
		/**
		 * Action listener for Login Button
		 */
		public static void btnLogin() {
			String userName = tfUserName.getText();
			String password = tfUserPassword.getText();
			GuiApp2Code.Login(appID, userName, password);
		}

		/**
		 * Action Listener for Logout Button
		 */
		public static void btnLogout() {
			String userName = tfUserName.getText();
			GuiApp2Code.Logout(appID, userName);
		}

		/**
		 * Action Listener for Logout Button
		 */
		public static void btnUpdate() {
			String userName = tfUserName.getText();
			GuiApp2Code.update(appID, userName);
		}
	}

}