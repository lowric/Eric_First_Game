import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements KeyListener, ActionListener
{
	private Image player1;
	private Timer timer;
	//private Image player2;
	private Image gameBackground;
	private Image ball;
	private PlayerSprite[] player1Sprite;
	private PlayerSprite[] player2Sprite;
	private String[] imagesFile;
	private int x,y;
	private MainFrame myMainFrame; // ???

	public GamePanel(MainFrame myMainFrame)
	{
		this.myMainFrame = myMainFrame;

		x = 0;
		y = 0;

		imagesFile = new String[3];

		imagesFile[0] = "Bgrd1.jpg";
		imagesFile[1] = "ball_basketball.png";
		imagesFile[2] = "background.png";

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);



	}

/*	public void displayTime(Graphics2D g, String s)
	{
		super.paint(g);
		Graphics2D g1 = (Graphics2D) g;

		g1.drawString(s,400,200);

	}

	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g1 = (Graphics2D) g;

		g1.drawImage(ball, x, y, 12, 12, this);
	}*/

	public void paintComponent(Graphics g)
	{
		//create image icon to get image
		ImageIcon imageicon1 = new ImageIcon(getClass().getResource(imagesFile[0]));
		ImageIcon imageicon2 = new ImageIcon(getClass().getResource(imagesFile[1]));
		ImageIcon imageicon3 = new ImageIcon(getClass().getResource(imagesFile[2]));
		player1 = imageicon1.getImage();
		ball = imageicon2.getImage();
		gameBackground = imageicon3.getImage();

		//Draw image on the panel
		super.paintComponent(g);

		if (gameBackground != null)
		{
			Graphics2D g1 = (Graphics2D) g;
            g1.drawImage(gameBackground, 0, 0, getWidth(), getHeight(),myMainFrame);
		}

			if (player1 != null)
		{
			Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(player1, 5, 10, 50, 100,myMainFrame);
		}

		/*	if (ball != null )
		{
			Graphics2D g3 = (Graphics2D) g;
			g3.drawImage(ball, x, y, 12, 12,myMainFrame);
		}*/

		imageicon2.paintIcon(this,g,x,y);



	}

	public void startAnimation()
	{
		if(timer == null)
			{
				timer = new Timer(1, this);
				timer.start();
			} else{
				if (timer != null) timer.restart();
			}

	}

	public void move()
	{
		   x = x + 10;
		   y = y + 20;
	}

	public void stopAnimation()
	{
		timer.stop();
		timer = null;
	}

	public void actionPerformed(ActionEvent e)
	{
		   move();
		   repaint();
	}

	public void keyPressed(KeyEvent e)
	{
			int i = e.getKeyCode();

		if (i == KeyEvent.VK_SPACE)
		{
			startAnimation();

		}
	}

	public void keyReleased(KeyEvent e)
	{

	}

	public void keyTyped(KeyEvent e)
	{

	}

}
