import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


class MainMenuPanel extends JPanel
{
	private JButton playGame;
	private JButton instructions;
	private JButton topScore;
	private JButton exit;
	private JPanel bottomPanel;
	private MainFrame myMainFrame;
	private String bgImageFile;


	public MainMenuPanel(MainFrame aMainFrame)
	{
		bgImageFile = "Bgrd1.jpg";
		myMainFrame = aMainFrame;

		// creates the bottom panel
		bottomPanel = new JPanel();

        // creates and customize the buttons

		playGame = new JButton("PLAY");
		playGame.setBackground(new java.awt.Color(0, 0, 0)); //set the button color to black
		playGame.setFont(new java.awt.Font("Broadway", 1, 15)); // set the font to Broadway
		playGame.setForeground(new java.awt.Color(170, 100, 1)); // set the font color to brown

	    instructions = new JButton("INSTRUCTIONS");
	    instructions.setBackground(new java.awt.Color(0, 0, 0)); //set the button color to black
	    instructions.setFont(new java.awt.Font("Broadway", 1, 15)); // set the font to Broadway
	    instructions.setForeground(new java.awt.Color(170, 100, 1));// set the font color to brown

	    topScore = new JButton("TOP SCORES");
	    topScore.setBackground(new java.awt.Color(0, 0, 0)); //set the button color to black
	    topScore.setFont(new java.awt.Font("Broadway", 1, 15)); // set the font to Broadway
	    topScore.setForeground(new java.awt.Color(170, 100, 1)); // set the font color to brown

	    exit = new JButton("EXIT");
	    exit.setBackground(new java.awt.Color(0, 0, 0)); //set the button color to black
	    exit.setFont(new java.awt.Font("Broadway", 1, 15)); // set the font to Broadway
	    exit.setForeground(new java.awt.Color(170, 100, 1)); // set the font color to brown

	    //this.setBackground(Color.white);

	    // set the layout for the bottomPanel
		bottomPanel.setLayout(new GridLayout(4,1,0,2));

		// adds the buttons to the bottomPanel
		bottomPanel.add(playGame);
		bottomPanel.add(instructions);
		bottomPanel.add(topScore);
		bottomPanel.add(exit);

	    // set the layout for "this" MainMenuPanel
		this.setLayout(new FlowLayout());

		// add the bottom panel to the southern region of "this" MainMenuPanel
		this.add(bottomPanel);


		//  Registers the buttons with listeners

		playGame.addActionListener(new PlayGameActionListener());
		instructions.addActionListener(new InstructionActionListener());
		topScore.addActionListener(new TopScoreActionListener());
		exit.addActionListener(new ExitActionListener());
	}

	public void paintComponent(Graphics g)
	{
		/*create image icon to get image*/
		ImageIcon imageicon = new ImageIcon(getClass().getResource(bgImageFile));
		Image image = imageicon.getImage();

		/*Draw image on the panel*/
		super.paintComponent(g);

		if (image != null)
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}

    // returns the main frame the main menu panel is displyed in
	public MainFrame getMainFrame()
	{
		return myMainFrame;
	}

	// INNER classes

    // Describe the action performed when the user presses on the button PLAY
	public class PlayGameActionListener implements  ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			getMainFrame().getMPanel().setVisible(false);
			getMainFrame().getIPanel().setVisible(false);
			getMainFrame().getTPanel().setVisible(false);
			//getMainFrame().getGPanel().setVisible(false);
			getMainFrame().getSPanel().setVisible(true);


			getMainFrame().getContainer().add(BorderLayout.CENTER,getMainFrame().getSPanel());
		}
	}

    // Describe the action performed when the user presses on the button TOP SCORE
	public class TopScoreActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			getMainFrame().getMPanel().setVisible(false);
			getMainFrame().getIPanel().setVisible(false);
			getMainFrame().getSPanel().setVisible(false);
			//getMainFrame().getGPanel().setVisible(false);
			getMainFrame().getTPanel().setVisible(true);

			getMainFrame().getContainer().add(BorderLayout.CENTER,getMainFrame().getTPanel());
		}
	}

    // Describes the action performed when the user presses on the button INSTRUCTION
	public class InstructionActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)

		{
			getMainFrame().getMPanel().setVisible(false);
			getMainFrame().getSPanel().setVisible(false);
			getMainFrame().getTPanel().setVisible(false);
			//getMainFrame().getGPanel().setVisible(false);
			getMainFrame().getIPanel().setVisible(true);

			getMainFrame().getContainer().add(BorderLayout.CENTER,getMainFrame().getIPanel());
		}

	}

    // Describe the action performed when the user presses on the button EXIT
	public class ExitActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			myMainFrame.exit();
		}
	}
}
