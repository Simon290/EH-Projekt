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
	private static JComboBox cbRecources;
	private static JTextArea taPermissions;
	private JTextField tfUserPassword;
	private JLabel jLabel1;
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
				bLogin.setBounds(287, 12, 86, 23);
				// bLogin.setAction(getOnLoginClicked());
				bLogin.addActionListener(ml);
			}
			{
				tfUserName = new JTextField();
				getContentPane().add(getTfUserName());
				tfUserName.setText("grupas");
				tfUserName.setBounds(12, 12, 124, 23);
			}
			{
				tfUserPassword = new JTextField();
				getContentPane().add(getTfUserPassword());
				tfUserPassword.setText("123");
				tfUserPassword.setBounds(142, 12, 100, 23);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(12, 62, 355, 10);
			}
			{
				this.tfUserName = tfUserName;
				getContentPane().add(tfUserName);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Permissions");
				jLabel1.setBounds(12, 48, 146, 16);
			}
			{
				taPermissions = new JTextArea();
				getContentPane().add(getTaPermissions());
				taPermissions.setText("hier kommen die Permissions rein");
				taPermissions.setBounds(12, 76, 360, 58);
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
				cbRecources.setBounds(12, 146, 76, 23);
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
			// Login Button gedr�ckt
			if (e.getSource() == bLogin) {
				String userName  = tfUserName.getText();
				String password = tfUserPassword.getText();
				GuiApp1Code.Login(userName,password);
			}
		}
	}

}