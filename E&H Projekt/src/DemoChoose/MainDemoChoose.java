package DemoChoose;

import javax.swing.SwingUtilities;

import Test.GuiTest;

import DemoApp1.GuiApp1;
import DemoApp2.GuiApp2;

public class MainDemoChoose {

	/**
	 * Starts the test Gui, and starts the Demo Application, if a Button is
	 * pressed
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GuiDemoChoose inst = new GuiDemoChoose();
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
	 * Starts the Demo App 1 in the middle of the screen
	 */
	static void startDemo1() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GuiApp1 inst = new GuiApp1();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	/**
	 * Starts the Demo App 2 in the middle of the screen
	 */
	static void startDemo2() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GuiApp2 inst = new GuiApp2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

}
