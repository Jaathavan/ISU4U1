import java.awt.*;

public class UFO {
	private int x = 20;
	private int y = 20;
	private int xa = 1; // Horizontal speed
	private int ya = 1; // Vertical speed
	private Cityscape ua;

	public UFO(Cityscape ua) {
		this.ua = ua;
	}

	public void move() {
		if (x + xa < 0) // If the ball exceeds the left
			xa = 1; // go right
		if (x + xa > ua.getWidth() - 50) // If the ball exceeds the right
			xa = -1; // go left
		if (y + ya < 0) // If the ball exceeds the top
			ya = 1; // go down
		if (y + ya > ua.getHeight() - 50) // If the ball exceeds the bottom
			ya = -1; // go up
			x = x + xa; // Adjust the x and y coordinates
			y = y + ya; // by the appropriate speeds

	}

	public void paint(Graphics2D g2d) {
		g2d.setColor(Color.GREEN);
		g2d.fillOval(x, y, 100, 50);
	}
}
