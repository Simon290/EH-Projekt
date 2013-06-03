package Test;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.text.Caret;

import Database.DBConnection;
import RightAllocation.Main;

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
public class GuiTest extends javax.swing.JFrame {
	private JButton jButtonShowCache;
	private JButton jButtonDB;
	private static JLabel jLabelDBStatus;
	
	public static boolean toggle;

	public GuiTest() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(245, 157);
			this.setLocation(new java.awt.Point(0, 0));
			getContentPane().setLayout(null);
			this.setTitle("Test");
			this.setResizable(false);
			{
				jButtonShowCache = new JButton();
				getContentPane().add(jButtonShowCache);
				jButtonShowCache.setText("Print Cache");
				jButtonShowCache.setBounds(12, 12, 216, 23);
				jButtonShowCache.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						showCache();
					}
				});
			}
			{
				jButtonDB = new JButton();
				getContentPane().add(jButtonDB);
				jButtonDB.setText("DB disconnect/connect");
				jButtonDB.setBounds(12, 46, 216, 23);
				jButtonDB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						toggleConnection();
					}
				});
			}
			{
				jLabelDBStatus = new JLabel();
				getContentPane().add(jLabelDBStatus);
				jLabelDBStatus.setText("DB Status: connectet");
				jLabelDBStatus.setBounds(12, 80, 215, 16);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showCache() {
		int n = Main.m.size();
		String[] keys = new String[n];
		Main.m.keySet().toArray(keys);
		String sCache;

		sCache = "Anzahl Cacheobjekte: " + n + "\n\n";

		for (int i = 0; i < keys.length; i++) {
			JButton jButtonDB;
			JLabel jLabelDBStatus;
			sCache = sCache + "Key: " + keys[i] + "\n\n";

			String spaceUI = "                  ";
			String userinfo = "";
			for (int ui = 0; ui < Main.m.get(keys[i]).getUserInfo().length; ui++) {
				userinfo = userinfo + Main.m.get(keys[i]).getUserInfo()[ui]
						+ "\n" + spaceUI;
			}
			sCache = sCache + "Userinfo: " + userinfo + "\n";

			String spaceAI = "                ";
			String appinfo = "";
			for (int ai = 0; ai < Main.m.get(keys[i]).getAppInfo().length; ai++) {
				appinfo = appinfo + Main.m.get(keys[i]).getAppInfo()[ai] + "\n"
						+ spaceAI;
			}
			sCache = sCache + "Appinfo: " + appinfo + "\n";

			sCache = sCache + "Rolle: " + Main.m.get(keys[i]).getRole() + "\n";

			sCache = sCache + "Recht: "
					+ Main.m.get(keys[i]).getPermissions()[0] + "\n";

			String spaceRE = "                ";
			String resources = "";
			for (int re = 0; re < Main.m.get(keys[i]).getResources().length; re++) {
				resources = resources + Main.m.get(keys[i]).getResources()[re]
						+ "\n" + spaceRE;
			}
			sCache = sCache + "Ressourcen: " + resources + "\n";

			sCache = sCache + "Timestamp: "
					+ Main.m.get(keys[i]).getTimeStamp() + "\n\n";

		}
		JTextArea textBox = new JTextArea(sCache);
		textBox.setBorder(null);
		textBox.setEditable(false);
		textBox.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textBox);
		scrollPane.setPreferredSize(new Dimension(300, 200));
		JOptionPane.showMessageDialog(null, scrollPane, "Cache",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void toggleConnection(){
		if(toggle != true){
			toggle = true;
			DBConnection.setPath("WrongPath");
			jLabelDBStatus.setText("DB Status: disconnectet");
		} else{
			toggle = false;
			DBConnection.setPath(System.getProperty("user.dir"));
			jLabelDBStatus.setText("DB Status: connectet");
		}
		
		
		
		
	}
		
}
