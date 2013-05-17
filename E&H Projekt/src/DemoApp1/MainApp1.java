package DemoApp1;

import javax.swing.JTextArea;


public class MainApp1 {

	static GuiApp1 gui;

	public MainApp1(GuiApp1 gui)
	{
		this.gui = gui;
	}

	public static void TestMethod()
	{
		JTextArea taPermissions = gui.getTaPermissions();
		taPermissions.setText("Hi");
	}

}