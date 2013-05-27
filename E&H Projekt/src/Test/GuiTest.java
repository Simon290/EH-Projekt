package Test;
import javax.swing.JButton;
import javax.swing.JTextPane;

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
public class GuiTest extends javax.swing.JFrame {
	private JButton jButtonShowCache;
	private JTextPane jTextPane1;

	public GuiTest() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			setSize(400, 300);
			this.setLocation(new java.awt.Point(0, 0));
			getContentPane().setLayout(null);
			this.setTitle("Test");
			{
				jButtonShowCache = new JButton();
				getContentPane().add(jButtonShowCache);
				jButtonShowCache.setText("Print Cache");
				jButtonShowCache.setBounds(12, 12, 361, 23);
			}
			{
				jTextPane1 = new JTextPane();
				getContentPane().add(jTextPane1);
				jTextPane1.setText("jTextPane1");
				jTextPane1.setBounds(12, 51, 360, 198);
			}
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	

}
