/**
 * @author Pascal Grunau, Simon Riedinger, Sarah Weinbecker, Anika Rist. Sebastian Abb
 * @version 1.0
 */

package DemoChoose;

import javax.swing.SwingUtilities;

import Test.GuiTest;

import Database.DBConnection;
import DemoApp1.DemoApp1;
import DemoApp2.DemoApp2;

/**
 * Functions for the demochoose-gui.
 */
public class DemoChooseFunctions {

	public static boolean demo1;
	public static boolean demo2;

	/**
	 * Starts the test gui, and starts the demo application, if the Button was
	 * pressed
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DBConnection.firstInit();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DemoChoose inst = new DemoChoose();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GuiTest inst = new GuiTest();
				inst.setVisible(true);
			}
		});
	}

	/**
	 * Starts the demo application 1.
	 */
	static void startDemo1() {
		if (demo1 != true) {
			demo1 = true;
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					DemoApp1 inst = new DemoApp1();
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
				}
			});
			DemoChoose.getBtnDemo1().setEnabled(false);
		} 
	}

	/**
	 * Starts the demo application 2.
	 */
	static void startDemo2() {
		if (demo2 != true) {
			demo2 = true;
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					DemoApp2 inst = new DemoApp2();
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
				}
			});
			DemoChoose.getBtnDemo2().setEnabled(false);
		} 
	}

}
