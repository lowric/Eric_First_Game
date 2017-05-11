
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class InstructionsPanel extends JPanel
{
	private JButton goBack;
	private JPanel bottomPanel;
	private JTextArea instructionsArea;
	private String instructions;
	private MainFrame myMainFrame;

	// constructor
	public InstructionsPanel(MainFrame myMainFrame)
	{
		this.myMainFrame = myMainFrame;

		// creates a new button "go back"
		goBack = new JButton("GO BACK");
		goBack.setBackground(new java.awt.Color(0, 0, 0));
	    goBack.setFont(new java.awt.Font("Broadway", 1, 15));
	    goBack.setForeground(new java.awt.Color(170, 100, 1));

		//initialises instructions
		instructions = "This is the instructions!!!!!";

		// creates a text area for instructions
		instructionsArea = new JTextArea(instructions);

		// creates the bottom panel
		bottomPanel = new JPanel(new FlowLayout());

		// adds goback button to the bottom panel
		bottomPanel.add(goBack);

		// sets the layout of the instructions panel
		this.setLayout(new BorderLayout());

		//adds the bottom panel to the instructions panel
		this.add(BorderLayout.SOUTH,bottomPanel);
		this.add(BorderLayout.CENTER, instructionsArea);

		// adds an actionListener to the button goBack
		goBack.addActionListener(new goBackActionListener());


	}

	public MainFrame getMainFrame()
	{
		return myMainFrame;
	}

	// INNER CLASS

	public class goBackActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			getMainFrame().getIPanel().setVisible(false);
			getMainFrame().getSPanel().setVisible(false);


			getMainFrame().getContainer().add(BorderLayout.CENTER,getMainFrame().getMPanel());
			getMainFrame().getMPanel().setVisible(true);
		}
	}
}
