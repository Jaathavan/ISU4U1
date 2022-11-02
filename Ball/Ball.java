package BallAnimation;

import java.awt.*;
import javax.swing.*;

public class Ball {
	private int x = 20;
	private int y = 20;
	private int xa = 1; // Horizontal speed
	private int ya = 1; // Vertical speed
	private BallAnimation ba;

	public Ball(BallAnimation ba) {
		this.ba = ba;
	}

	public void move() {
		if (x + xa < 0) // If the ball exceeds the left
			xa = 1; // go right
		if (x + xa > ba.getWidth() - 50) // If the ball exceeds the right
			xa = -1; // go left
		if (y + ya < 0) // If the ball exceeds the top
			ya = 1; // go down
		if (y + ya > ba.getHeight() - 50) // If the ball exceeds the bottom
			ya = -1; // go up
			x = x + xa; // Adjust the x and y coordinates
			y = y + ya; // by the appropriate speeds

	}

	public void paint(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.fillOval(x, y, 50, 50);
	}
}
