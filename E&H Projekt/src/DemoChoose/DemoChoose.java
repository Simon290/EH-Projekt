/**
 * @author Pascal Grunau, Simon Riedinger, Sarah Weinbecker, Anika Rist. Sebastian Abb
 * @version 1.0
 */

package DemoChoose;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.WindowConstants;

/**
 * Gui to start one of the two demo applications.
 */
@SuppressWarnings("serial")
public class DemoChoose extends javax.swing.JFrame {
	private JButton jButtonDemo1;
	private JButton jButtonDemo2;

	/**
	 * Constructor initializes the gui.
	 */
	public DemoChoose() {
		super();
		initGUI();
	}

	/**
	 * Method initializes the gui, sets the Buttons and creates the Event
	 * Handlers
	 */
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
						DemoChooseFunctions.startDemo1();
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
						DemoChooseFunctions.startDemo2();
					}
				};
				jButtonDemo2.addActionListener(alBtn2);
			}
			pack();
			this.setSize(277, 134);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
