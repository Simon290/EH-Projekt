package DemoChoose;

import javax.swing.SwingUtilities;

import DemoApp1.GuiApp1;
import DemoApp2.DemoFrame2;

public class MainDemoChoose {

	/**
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
	}

	static void startDemo1() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GuiApp1 inst = new GuiApp1();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	static void startDemo2() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DemoFrame2 inst = new DemoFrame2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

}
