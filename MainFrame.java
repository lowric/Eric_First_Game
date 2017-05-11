import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;


class MainFrame extends JFrame
{
	private MainMenuPanel mainMenuPanel;
	private SetUpMenuPanel setUpMenu;
	private InstructionsPanel instructionPanel;
	private TopScorePanel topScorePanel;
	private GamePanel gamePanel;
	private AfterGamePanel afterGamePanel;
	private Container container;

	public MainFrame()
	{
	   setTitle("Basketball Game");

	   setResizable(false);

	   container = this.getContentPane();
	   container.setLayout(new BorderLayout());

       // creates all the panels
	   mainMenuPanel = new MainMenuPanel(this);
	   setUpMenu = new SetUpMenuPanel(this);
	   instructionPanel = new InstructionsPanel(this);
	   topScorePanel = new TopScorePanel(this);
	   gamePanel = new GamePanel(this);
	   afterGamePanel = new AfterGamePanel(this);

	   this.add(mainMenuPanel);
	   //this.add(setUpMenu);
	   //this.add(instructionPanel);

	   //container.setComponentZOrder(mainMenuPanel,0);
	   //container.setComponentZOrder(setUpMenu,1);
	   //container.setComponentZOrder(instructionPanel,2);

	   container.add(BorderLayout.CENTER, mainMenuPanel);



	   setSize(500, 400);
	   setLocation(100, 100);

	   this.addWindowListener(new WindowCloser());
	}

    // return the container
	public Container getContainer()
	{
		return container;
	}

    //return the main menu panel
	public MainMenuPanel getMPanel()
	{
		return mainMenuPanel;
	}

	//return the setup menu panel
	public SetUpMenuPanel getSPanel()
	{
		return setUpMenu;
	}

	//return the instructions panel
	public InstructionsPanel getIPanel()
	{
		return instructionPanel;
	}

	// returns the top score menu panel
	public TopScorePanel getTPanel()
	{
		return topScorePanel;
	}

	// returns the game panel
	public GamePanel getGPanel()
	{
		return gamePanel;
	}

	// returns the after game panel
	public AfterGamePanel getAPanel()
	{
		return afterGamePanel;
	}


	 //  Helper method that hides the window and disposes of its resources.  Finally, we exit.

	public void exit()
	{

		setVisible(false);
		dispose();
		System.exit(0);

	}

	class WindowCloser extends WindowAdapter {

		/**
		 *  let's call our exit() method defined above
		 */
		public void windowClosing(WindowEvent e) {

			exit();
		}
	}

}
