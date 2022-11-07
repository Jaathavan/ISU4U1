import java.awt.*;
import java.awt.event.*;

public class UFO {
	private int x = 20;
	private int y = 20;
	private int xa = 1; // Horizontal speed
	private int ya = 1; // Vertical speed
	private Cityscape ua;
	
	private static final int DIAMETER = 50;

	private boolean right = false, left = false;
	private Boolean up = false, down = false;

	public UFO(Cityscape ua, int x, int y, int xa, int ya) {
		this.ua = ua;
		this.x = x;
		this.y = y;
		this.xa = xa;
		this.ya = ya;
	}

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
		if ((x + xa < 0)  || (x + xa > ua.getWidth() - DIAMETER)) // If the ball exceeds the left
			xa *= -1;
		if ((y + ya < 0) || (y + ya > ua.getHeight() - DIAMETER - Math.round(640/3)*2)) // If the ball exceeds the top
			ya *= -1;
		
		x += xa;
		y += ya;
	}

	public void moveU() {
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

	public void collision(UFO u) {
		int dx = (x - u.x) + (xa - u.xa);
		int dy = (y - u.y) + (ya - u.ya);
		// if the balls collide...
		if (Math.sqrt(dx * dx + dy * dy) <= DIAMETER) {
			// switch velocities
			int tempxa = xa;
			int tempya = ya;
			xa = u.xa;
			ya = u.ya;
			u.xa = tempxa;
			u.ya = tempya;
		}
	}

	public void paint(Graphics2D g2d) {
		//modify to steal
		// g2d.setColor(new Color(255, 255, 0, 50));
		// g2d.fillPolygon(new int[] {x+45, x, x+100}, new int[] {y+35, y+80, y+80}, 3);
		g2d.setColor(Color.GREEN);
		g2d.fillOval(x, y, DIAMETER+50, DIAMETER);
		g2d.setColor(Color.BLUE);
		g2d.fillOval(x+20, y-10, 60, 40);
		g2d.fillOval(x+10, y+20, 10, 10);
		g2d.fillOval(x+80, y+20, 10, 10);
		g2d.fillOval(x+45, y+35, 10, 10);
	}
}
