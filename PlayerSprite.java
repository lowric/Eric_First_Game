// This class represent the characters displayed on the game scene
// described by their position (x,y) and  an array of images to animate them.

import javax.swing.*;
import java.awt.*;

public class PlayerSprite
{
	private Image [] images;
	private int x, y;

	// constructor that take as parameters two integers to initialise the position
	// and creates an array of images
	public PlayerSprite(int x, int y)
	{
		this.x = x;
		this.y = y;

		images = new Image[3];
	}

	// setimage method takes as parameters three string that represent the name of the
	// image files, get those images and store them in the Sprite array of images
	public void setImage(String s1, String s2, String s3)
	{
		ImageIcon imageicon1 = new ImageIcon(getClass().getResource(s1));
		ImageIcon imageicon2 = new ImageIcon(getClass().getResource(s2));
		ImageIcon imageicon3 = new ImageIcon(getClass().getResource(s3));

		images[0] = imageicon1.getImage();
		images[1] = imageicon2.getImage();
		images[2] = imageicon3.getImage();
	}

	// getX() returns the x coordinate of the Sprite
	public int getX()
	{
		return x;
	}

	// getY() returns the y coordinate of the Sprite
	public int getY()
	{
		return y;
	}

	// getImage() takes an integer (i) as parameter and returns the image at (i)
	// position in the array of images
	public Image getImage(int i)
	{
		return images[i];
	}
}
