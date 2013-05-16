package DemoChoose;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
public class GuiDemoChoose extends javax.swing.JFrame {
	private JButton jButtonDemo1;
	private JButton jButtonDemo2;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	
	public GuiDemoChoose() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Demo auswählen");
			this.setResizable(false);
			{
				jButtonDemo1 = new JButton();
				getContentPane().add(jButtonDemo1);
				jButtonDemo1.setText("Application 1 starten");
				jButtonDemo1.setBounds(12, 12, 248, 30);
				jButtonDemo1.setFont(new java.awt.Font("Segoe UI", 0, 16));
				ActionListener alBtn1 = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MainDemoChoose.startDemo1();
					}
				};
				jButtonDemo1.addActionListener(alBtn1);
			}
			{
				jButtonDemo2 = new JButton();
				getContentPane().add(jButtonDemo2);
				jButtonDemo2.setText("Application 2 starten");
				jButtonDemo2.setBounds(12, 53, 248, 30);
				jButtonDemo2.setFont(new java.awt.Font("Segoe UI", 0, 16));
				ActionListener alBtn2 = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MainDemoChoose.startDemo2();
					}
				};
				jButtonDemo2.addActionListener(alBtn2);
			}
			pack();
			this.setSize(277, 134);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
