package DemoApp2;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
public class DemoFrame2 extends javax.swing.JFrame {
	private JMenuBar jMenuBar;
	private JMenu jMenu1;
	private JMenuItem jMenuAbmelden;
	private JMenuItem jMenuAnmelden;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DemoFrame2 inst = new DemoFrame2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public DemoFrame2() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Application 2");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jMenuBar = new JMenuBar();
				setJMenuBar(jMenuBar);
				{
					jMenu1 = new JMenu();
					jMenuBar.add(jMenu1);
					jMenu1.setText("jMenu1");
					{
						jMenuAnmelden = new JMenuItem();
						jMenu1.add(jMenuAnmelden);
						jMenuAnmelden.setText("Anmelden");
					}
					{
						jMenuAbmelden = new JMenuItem();
						jMenu1.add(jMenuAbmelden);
						jMenuAbmelden.setText("Abmelden");
					}
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
