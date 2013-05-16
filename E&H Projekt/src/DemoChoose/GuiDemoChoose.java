package DemoChoose;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;

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
public class GuiDemoChoose extends javax.swing.JFrame {
	private JButton jButtonDemo1;
	private JButton jButtonDemo2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GuiDemoChoose inst = new GuiDemoChoose();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public GuiDemoChoose() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			this.setTitle("Demo auswählen");
			this.setResizable(false);
			{
				jButtonDemo1 = new JButton();
				getContentPane().add(jButtonDemo1, new AnchorConstraint(110, 957, 426, 50, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButtonDemo1.setText("Application 1 starten");
				jButtonDemo1.setPreferredSize(new java.awt.Dimension(223, 30));
				jButtonDemo1.setFont(new java.awt.Font("Segoe UI",0,14));
			}
			{
				jButtonDemo2 = new JButton();
				getContentPane().add(jButtonDemo2, new AnchorConstraint(542, 957, 857, 50, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButtonDemo2.setText("Application 2 starten");
				jButtonDemo2.setFont(new java.awt.Font("Segoe UI",0,14));
				jButtonDemo2.setPreferredSize(new java.awt.Dimension(223, 30));
			}
			pack();
			this.setSize(262, 134);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
