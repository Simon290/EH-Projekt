package DemoApp1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class GuiApp1 extends javax.swing.JFrame {

	private JButton bLogin;
	private JTextField tfUserName;
	private JButton bUpdatePage;
	private JButton bDelete;
	private JLabel lResources;
	private JLabel lPassword;
	private JLabel lLevel;
	private JLabel lPermission;
	private JLabel lRolle;
	private JButton bLogout;
	private JLabel lUserID;
	private JSeparator jSeparator2;
	private JButton bUpdate;
	private JButton Write;
	private JButton bRead;
	static private JTextArea jTextArea2;
	static private JTextArea jTextArea1;
	private static JComboBox cbRecources;
	private static JTextArea taPermissions;
	private JTextField tfUserPassword;
	private JSeparator jSeparator1;

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public GuiApp1() {
		super();
		//MainApp1 guiCode = new MainApp1(this);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setTitle("Application 1");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setFocusableWindowState(true);
			{
				MyListener ml = new MyListener();
				bLogin = new JButton();
				getContentPane().add(bLogin);
				bLogin.setText("Login");
				bLogin.setBounds(201, 12, 86, 23);
				// bLogin.setAction(getOnLoginClicked());
				bLogin.addActionListener(ml);
			}
			{
				tfUserName = new JTextField();
				getContentPane().add(getTfUserName());
				tfUserName.setText("grupas");
				tfUserName.setBounds(12, 30, 82, 23);
			}
			{
				tfUserPassword = new JTextField();
				getContentPane().add(getTfUserPassword());
				tfUserPassword.setText("123");
				tfUserPassword.setBounds(106, 30, 61, 23);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(12, 69, 355, 10);
			}
			{
				this.tfUserName = tfUserName;
				getContentPane().add(tfUserName);
			}
			{
				taPermissions = new JTextArea();
				getContentPane().add(getTaPermissions());
				taPermissions.setText("Permissions");
				taPermissions.setBounds(118, 100, 70, 21);
				taPermissions.setWrapStyleWord(true);
				taPermissions.setEditable(false);
			}
			{
				ComboBoxModel cbRecourcesModel = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
				cbRecources = new JComboBox();
				getContentPane().add(cbRecources);
				cbRecources.setModel(cbRecourcesModel);
				cbRecources.setBounds(12, 159, 125, 21);
			}
			{
				jTextArea1 = new JTextArea();
				getContentPane().add(jTextArea1);
				jTextArea1.setWrapStyleWord(true);
				jTextArea1.setText("Level");
				jTextArea1.setEditable(false);
				jTextArea1.setBounds(200, 99, 42, 21);
			}
			{
				jTextArea2 = new JTextArea();
				getContentPane().add(jTextArea2);
				jTextArea2.setWrapStyleWord(true);
				jTextArea2.setText("Rolle");
				jTextArea2.setEditable(false);
				jTextArea2.setBounds(12, 99, 83, 22);
			}
			{
				bRead = new JButton();
				getContentPane().add(bRead);
				bRead.setText("Read");
				bRead.setBounds(9, 221, 91, 23);
			}
			{
				Write = new JButton();
				getContentPane().add(Write);
				Write.setText("bWrite");
				Write.setBounds(101, 221, 91, 23);
			}
			{
				bUpdate = new JButton();
				getContentPane().add(bUpdate);
				bUpdate.setText("Update");
				bUpdate.setBounds(191, 221, 91, 23);
			}
			{
				bDelete = new JButton();
				getContentPane().add(bDelete);
				bDelete.setText("Delete");
				bDelete.setBounds(282, 221, 91, 23);
			}
			{
				bUpdatePage = new JButton();
				getContentPane().add(bUpdatePage);
				bUpdatePage.setText("Update");
				bUpdatePage.setBounds(201, 40, 86, 23);
			}
			{
				lResources = new JLabel();
				getContentPane().add(lResources);
				lResources.setText("Rescources:");
				lResources.setBounds(12, 137, 70, 16);
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
				lUserID.setBounds(12, 8, 34, 16);
			}
			{
				lPassword = new JLabel();
				getContentPane().add(lPassword);
				lPassword.setText("Password");
				lPassword.setBounds(106, 8, 50, 16);
			}
			{
				bLogout = new JButton();
				getContentPane().add(bLogout);
				bLogout.setText("Logout");
				bLogout.setBounds(292, 12, 86, 23);
			}
			{
				lRolle = new JLabel();
				getContentPane().add(lRolle);
				lRolle.setText("Sie haben Rolle:");
				lRolle.setBounds(12, 77, 83, 16);
			}
			{
				lPermission = new JLabel();
				getContentPane().add(lPermission);
				lPermission.setText("Permission");
				lPermission.setBounds(118, 78, 58, 16);
			}
			{
				lLevel = new JLabel();
				getContentPane().add(lLevel);
				lLevel.setText("Level:");
				lLevel.setBounds(201, 78, 33, 16);
			}
			this.setFocusCycleRoot(false);
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	public JButton getbLogin() {
		return bLogin;
	}

	public void setbLogin(JButton bLogin) {
		this.bLogin = bLogin;
	}

	public void setTfUserName(JTextField tfUserName) {
	}

	public JTextField getTfUserName() {
		return tfUserName;
	}
	public JTextField getTfUserPassword() {
		return tfUserPassword;
	}
	
	public static JTextArea getTaPermissions() {
		return taPermissions;
	}
	
	public static JComboBox getCbResources() {
		return cbRecources;
	}

	class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Login Button gedrückt
			if (e.getSource() == bLogin) {
				String userName  = tfUserName.getText();
				String password = tfUserPassword.getText();
				GuiApp1Code.Login(userName,password);
			}
		}
	}

}