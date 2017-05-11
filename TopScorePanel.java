import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class TopScorePanel extends JPanel
{

	private JButton goBack;
	private JPanel bottomPanel;
	private JPanel centerPanel;
	private MainFrame myMainFrame;

	public TopScorePanel(MainFrame myMainFrame)
	{
		this.myMainFrame = myMainFrame;

		//creates the bottomPanel
		bottomPanel = new JPanel(new FlowLayout());

		//creates the bottomPanel
		centerPanel = new JPanel(new GridLayout(5,3));

		// creates and costumises the GO BACK button
		goBack = new JButton("GO BACK");
		goBack.setBackground(new java.awt.Color(0, 0, 0));
	    goBack.setFont(new java.awt.Font("Broadway", 1, 15));
	    goBack.setForeground(new java.awt.Color(170, 100, 1));

	    // set the layout of the Top score panel
	    this.setLayout(new BorderLayout());

        // creates the labels and add them to the top score pane
        JLabel[] labels = new JLabel[5];
        JLabel[] names = new JLabel[5];
        JLabel[] scores = new JLabel[5];

	    for (int i = 0; i < labels.length; i++)
	    {
	    	String s1 ="  " + (i+1) + ". ";
	    	String s2 ="user name... ";
	    	String s3 ="  Score.. ";
	    	labels[i] = new JLabel(s1);
	    	names[i] = new JLabel(s2);
	    	scores[i] = new JLabel(s3);

	    	centerPanel.add(labels[i]);
	    	centerPanel.add(names[i]);
	    	centerPanel.add(scores[i]);
	    }

	   /* for (int i = 0; i < names.length; i++)
	    {
	    	String s ="  user name... ";
	    	names[i] = new JLabel(s);

	    	centerPanel.add(names[i]);
	    }

	    for (int i = 0; i < scores.length; i++)
	    {
	    	String s ="  Score.. ";
	    	scores[i] = new JLabel(s);

	    	centerPanel.add(scores[i]);
	    }*/

	    //adds the button GO BACK to the bottomPanel
	    bottomPanel.add(goBack);

	    //adds the bottomPanel to the top score panel
	    this.add(centerPanel);
	    this.add(BorderLayout.SOUTH,bottomPanel);

	    //registers the GO BACK button with an ActionListener
	    goBack.addActionListener(new GoActionListener());

	}

	//returns the main frame
	public MainFrame getMainFrame()
	{
		return myMainFrame;
	}

    // Describes the action performed when the user clicks on the button GO BACK
	class GoActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			getMainFrame().getIPanel().setVisible(false);
			getMainFrame().getSPanel().setVisible(false);
			getMainFrame().getTPanel().setVisible(false);
			//getMainFrame().getGPanel().setVisible(false);

			getMainFrame().getContainer().add(BorderLayout.CENTER,getMainFrame().getMPanel());
			getMainFrame().getMPanel().setVisible(true);
		}
	}


}
