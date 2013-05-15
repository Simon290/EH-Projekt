package DemoApp1;

import javax.swing.JTextArea;

public class GuiApp1Code {

	static GuiApp1 gui;
	
	public GuiApp1Code(GuiApp1 gui)
	{
		this.gui = gui;
	}
	
	public static void TestMethod()
	{
		JTextArea taPermissions = gui.getTaPermissions();
		taPermissions.setText("Hi");
	}
}
