package DemoApp1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;



/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class GuiApp1 extends javax.swing.JFrame {

	private JButton bLogin;
	private JTextField tfUserName;
	private AbstractAction OnLoginClicked;
	private JTextArea taPermissions;
	private JLabel jLabel1;
	private JSeparator jSeparator1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GuiApp1 inst = new GuiApp1();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public GuiApp1() {
		super();
		GuiApp1Code guiCode = new GuiApp1Code(this);
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setFocusableWindowState(false);
			{
				bLogin = new JButton();
				getContentPane().add(bLogin);
				bLogin.setText("Login");
				bLogin.setBounds(287, 12, 86, 23);
				bLogin.setAction(getOnLoginClicked());
			}
			{
				tfUserName = new JTextField();
				getContentPane().add(getTfUserName());
				tfUserName.setText("UserName");
				tfUserName.setBounds(12, 12, 196, 23);
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(12, 62, 355, 10);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Permissions");
				jLabel1.setBounds(12, 48, 146, 16);
			}
			this.setFocusCycleRoot(false);
			{
				taPermissions = new JTextArea();
				getContentPane().add(getTaPermissions());
				taPermissions.setBounds(12, 70, 355, 140);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
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
		this.tfUserName = tfUserName;
	}

	public void setTaPermissions(JTextArea taPermissions) {
		this.taPermissions = taPermissions;
	}

	public JTextField getTfUserName() {
		return tfUserName;
	}

	public JTextArea getTaPermissions() {
		return taPermissions;
	}

	private AbstractAction getOnLoginClicked() {
		if(OnLoginClicked == null) {
			OnLoginClicked = new AbstractAction("Login", null) {
				public void actionPerformed(ActionEvent evt) {
					GuiApp1Code.TestMethod();
				}
			};
		}
		return OnLoginClicked;
	}

}