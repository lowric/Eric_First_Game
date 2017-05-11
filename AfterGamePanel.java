import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AfterGamePanel extends JPanel
{
	private JTextArea textArea;
	private JLabel label;
	private String[] messages;
	private String userName;
	private MainFrame myMainFrame;

	public AfterGamePanel(MainFrame myMainFrame)
	{
		this.myMainFrame = myMainFrame;

		messages = new String[3];
		textArea = new JTextArea();
		textArea.setEditable(true);
		textArea.setVisible(true);
		label = new JLabel();
		label.setName("Name : ");
		label.add(textArea);
		label.setVisible(true);

	}

	// return the user name
	public String getUserName()
	{
		userName = textArea.getText();
		return userName;
	}

	// return the main frame
	public MainFrame getMainframe()
	{
		return myMainFrame;
	}
}
