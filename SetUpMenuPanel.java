
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.html.ImageView;


public class SetUpMenuPanel extends JPanel implements ActionListener
{
	private JButton startGame;
	private JButton goBack;
	private JButton playMode2;
	private JRadioButton onePlay, twoPlay;
	private ButtonGroup buttonGrp;
	private MainFrame myMainFrame;
	private JPanel bottomPanel;
	private JPanel centerPanel;
	private JPanel topPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JLabel playerLabel;

	public SetUpMenuPanel(MainFrame myMainFrame)
	{
		this.myMainFrame = myMainFrame;

		//gets the image of the players that the user will be able to choose
	//	ImageIcon player1 = new ImageIcon(getClass().getResource("Bgrd1.jpg"));
	//	ImageIcon player2 = new ImageIcon(getClass().getResource("Bgrd1.jpg"));

        // creates a label for the players images
		playerLabel = new JLabel();

		// create to radio buttons
		onePlay = new JRadioButton("player 1");
		onePlay.setSelected(true);
		twoPlay = new JRadioButton("player 2");
		// set the text so that it can be retrieved later
		onePlay.setActionCommand("Bgrd1.jpg");
		twoPlay.setActionCommand("duke_404.gif");
		// set the image on the label to be one player
		playerLabel.setIcon(new ImageIcon("Bgrd1.jpg"));

		// register an action listener on the buttons
		onePlay.addActionListener(this);
		twoPlay.addActionListener(this);

		// create a button group
		buttonGrp = new ButtonGroup();
		// add the radio buttons to the group
		buttonGrp.add(onePlay);
		buttonGrp.add(twoPlay);


        // set the label size
		playerLabel.setSize(50, 35);

		// creates the panels
		bottomPanel = new JPanel();
		centerPanel = new JPanel();
		leftPanel = new JPanel();
		rightPanel = new JPanel();

		// cerates and customizes the button START
		startGame = new JButton("START");
		startGame.setBackground(new java.awt.Color(0, 0, 0));
		startGame.setFont(new java.awt.Font("Broadway", 1, 15));
		startGame.setForeground(new java.awt.Color(170, 100, 1));

		// cerates and customizes the button START
		goBack = new JButton("GO Back");
		goBack.setBackground(new java.awt.Color(0, 0, 0));
		goBack.setFont(new java.awt.Font("Broadway", 1, 15));
		goBack.setForeground(new java.awt.Color(170, 100, 1));

		// cerates and customizes the button playMode2
		playMode2 = new JButton("Two Players");
		playMode2.setBackground(new java.awt.Color(0, 0, 0));
		playMode2.setFont(new java.awt.Font("Broadway", 1, 15));
		playMode2.setForeground(new java.awt.Color(170, 100, 1));

		// set the layout of the panels
		bottomPanel.setLayout(new FlowLayout());
		centerPanel.setLayout(new FlowLayout());
		leftPanel.setLayout(new FlowLayout());
		rightPanel.setLayout(new FlowLayout());

		// create a panel to hold the radio buttons
	    topPanel = new JPanel();
	    topPanel.add(onePlay);
	    topPanel.add(twoPlay);

		// add the START and go back buttons to the bottom panel
		bottomPanel.add(startGame);
		bottomPanel.add(goBack);
		bottomPanel.add(playMode2);

		// add the label to the center panel
		centerPanel.add(playerLabel);

		// set the layout of the setup menu panel
		this.setLayout(new BorderLayout());

		// adds the panels to the setup menu panel
		this.add(BorderLayout.SOUTH,bottomPanel);
		this.add(BorderLayout.NORTH,topPanel);
		this.add(BorderLayout.CENTER,centerPanel);
		this.add(BorderLayout.EAST,rightPanel);
		this.add(BorderLayout.WEST,leftPanel);

		//this.setBackground(Color.WHITE);

		startGame.addActionListener( new StartActionListener());

		goBack.addActionListener( new GoActionListener());

		playMode2.addActionListener(new ModeActionListener());

	}

	// load and display the image corresponding to one or two players
	public void actionPerformed(ActionEvent e) {
       // playerLabel.setIcon(new ImageIcon(e.getActionCommand() + ".jpg"));
        playerLabel.setIcon(new ImageIcon(e.getActionCommand()));
    }



	// returns the main frame the main menu panel is displyed in
	public MainFrame getMainFrame()
	{
		return myMainFrame;
	}

	// INNER CLASS

    // describes the action performed when the user presses on the START button
	public class StartActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			myMainFrame.getSPanel().setVisible(false);

			getMainFrame().setSize(800,600);

			myMainFrame.getContainer().add(BorderLayout.CENTER,myMainFrame.getGPanel());
			myMainFrame.getGPanel().setVisible(true);
		}
	}

    // Describes the action performed when the user presses on the go back button
	public class GoActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			myMainFrame.getSPanel().setVisible(false);

			myMainFrame.getContainer().add(BorderLayout.CENTER,myMainFrame.getMPanel());
			myMainFrame.getMPanel().setVisible(true);
		}
	}

    // Describes the action performed when the user presses on the two players button
	public class ModeActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int i = 0;
		}
	}
}
