/**
 * @author Pascal Grunau, Simon Riedinger, Sarah Weinbecker, Anika Rist, Sebastian Abb
 * @version 1.0
 */

package Test;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import Database.DBConnection;
import DemoApp1.DemoApp1;
import DemoApp2.DemoApp2;
import RightAllocation.MainClass;

@SuppressWarnings("serial")
public class GuiTest extends javax.swing.JFrame {
	private JButton jButtonShowCache;
	private JButton jButtonDB;
	private static JLabel jLabelDBStatus;
	public static boolean toggle;
	private static JTextField jTfAddRes;
	private static JButton jBAddRes2;
	private static JButton jBAddRes1;

	public GuiTest() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(251, 254);
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
				jButtonDB.setBounds(12, 153, 216, 23);
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
				jLabelDBStatus.setBounds(12, 187, 215, 16);
				jLabelDBStatus.setHorizontalAlignment(SwingConstants.CENTER);
				jLabelDBStatus.setHorizontalTextPosition(SwingConstants.CENTER);
				jLabelDBStatus.setForeground(new java.awt.Color(0, 128, 0));
				jLabelDBStatus.setFont(new java.awt.Font("Segoe UI", 1, 14));
			}
			{
				jBAddRes1 = new JButton();
				getContentPane().add(jBAddRes1);
				jBAddRes1.setText("Add resource app1");
				jBAddRes1.setBounds(12, 85, 216, 23);
				jBAddRes1.setEnabled(false);
				jBAddRes1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						addResource("1");
					}
				});
			}
			{
				jBAddRes2 = new JButton();
				getContentPane().add(jBAddRes2);
				jBAddRes2.setText("Add resource app2");
				jBAddRes2.setBounds(12, 119, 216, 23);
				jBAddRes2.setEnabled(false);
				jBAddRes2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						addResource("2");
					}
				});
			}
			{
				jTfAddRes = new JTextField();
				getContentPane().add(getJTfAddRes());
				jTfAddRes.setBounds(12, 50, 216, 23);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static JButton getJBAddRes1() {
		return jBAddRes1;
	}

	public static JButton getJBAddRes2() {
		return jBAddRes2;
	}

	public static JTextField getJTfAddRes() {
		return jTfAddRes;
	}

	public static void showCache() {
		int n = MainClass.m.size();
		String[] keys = new String[n];
		MainClass.m.keySet().toArray(keys);
		String sCache;

		sCache = "Anzahl Cacheobjekte: " + n + "\n\n";

		for (int i = 0; i < keys.length; i++) {

			sCache = sCache + "Key: " + keys[i] + "\n\n";

			String spaceUI = "                  ";
			String userinfo = "";
			for (int ui = 0; ui < MainClass.m.get(keys[i]).getUserInfo().length; ui++) {
				userinfo = userinfo + MainClass.m.get(keys[i]).getUserInfo()[ui]
						+ "\n" + spaceUI;
			}
			sCache = sCache + "Userinfo: " + userinfo + "\n";

			String spaceAI = "                ";
			String appinfo = "";
			for (int ai = 0; ai < MainClass.m.get(keys[i]).getAppInfo().length; ai++) {
				appinfo = appinfo + MainClass.m.get(keys[i]).getAppInfo()[ai] + "\n"
						+ spaceAI;
			}
			sCache = sCache + "Appinfo: " + appinfo + "\n";

			sCache = sCache + "Rolle: " + MainClass.m.get(keys[i]).getRole()
					+ "\n\n";

			sCache = sCache + "Recht: "
					+ MainClass.m.get(keys[i]).getPermissions()[0] + "\n\n";

			String spaceRE = "                         ";
			String resources = "";
			for (int re = 0; re < MainClass.m.get(keys[i]).getResources().length; re++) {
				resources = resources + MainClass.m.get(keys[i]).getResources()[re]
						+ "\n" + spaceRE;
			}
			sCache = sCache + "Ressourcen: " + resources + "\n";

			sCache = sCache + "Timestamp: "
					+ MainClass.m.get(keys[i]).getTimeStamp() + "\n\n";

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

	public static void toggleConnection() {
		if (toggle != true) {
			toggle = true;
			DBConnection.setPath("WrongPath");
			jLabelDBStatus.setText("DB Status: disconnected");
			jLabelDBStatus.setForeground(new java.awt.Color(255, 0, 0));
		} else {
			toggle = false;
			DBConnection.setPath(System.getProperty("user.dir"));
			jLabelDBStatus.setText("DB Status: connected");
			jLabelDBStatus.setForeground(new java.awt.Color(0, 128, 0));
		}

	}

	public static void addResource(String appID) {
		switch (appID) {
		case "1":
			MainClass.addOneResource("1", DemoApp1.getTfUserName().getText());
			JOptionPane.showMessageDialog(null, "Ressource wurde hinzugefügt!",
					"Neue Ressource", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "2":
			MainClass.addOneResource("2", DemoApp2.getTfUserName().getText());
			JOptionPane.showMessageDialog(null, "Ressource wurde hinzugefügt!",
					"Neue Ressource", JOptionPane.INFORMATION_MESSAGE);
			break;
		}

	}

}
