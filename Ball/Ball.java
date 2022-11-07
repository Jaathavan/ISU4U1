import java.awt.*;
import java.awt.event.*;

public class Ball {
	private int x = 0;
	private int y = 0;
	private int xa = 0;
	private int ya = 0;
	// These are used to keep track of how the ball is moving, by doing it this
	// way the animation is smoother
	private boolean right = false, left = false;
	private Boolean up = false, down = false;

	// Because this is not an actual Key Listener, you don’t have to have all
	// three methods, you can for encapsulation reasons only include the one’s
	// you need.
	public void keyPressed(KeyEvent e) {
		// This checks to see which key was pressed, and then sets the appropriate
		// Boolean to true
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		// When the key is released, set the Boolean to false, and change
		// acceleration to 0
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
			xa = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
			xa = 0;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = false;
			ya = 0;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = false;
			ya = 0;
		}
	}

	public void move() {
		// Base your acceleration on the Booleans set by your keyPressed method
		if (right) {
			xa = 1;
		}
		if (left) {
			xa = -1;
		}
		if (down) {
			ya = 1;
		}
		if (up) {
			ya = -1;
		}
		x += xa;
		y += ya;
	}

	public void paint(Graphics2D g2d) {
		g2d.fillOval(x, y, 50, 50);
	}
}