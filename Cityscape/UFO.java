import java.awt.*;

public class UFO {
	private int x = 20;
	private int y = 20;
	private int xa = 1; // Horizontal speed
	private int ya = 1; // Vertical speed
	private Cityscape ua;
	
	private static final int DIAMETER = 50;

	public UFO(Cityscape ua, int x, int y, int xa, int ya) {
		this.ua = ua;
		this.x = x;
		this.y = y;
		this.xa = xa;
		this.ya = ya;
	}

	public void move() {
		if ((x + xa < 0)  || (x + xa > ua.getWidth() - DIAMETER)) // If the ball exceeds the left
			xa *= -1;
		if ((y + ya < 0) || (y + ya > ua.getHeight() - DIAMETER - Math.round(640/3)*2)) // If the ball exceeds the top
			ya *= -1;
		
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
		g2d.setColor(new Color(255, 255, 0, 50));
		g2d.fillPolygon(new int[] {x+45, x, x+100}, new int[] {y+35, y+80, y+80}, 3);
		g2d.setColor(Color.GREEN);
		g2d.fillOval(x, y, DIAMETER+50, DIAMETER);
		g2d.setColor(Color.BLUE);
		g2d.fillOval(x+20, y-10, 60, 40);
		g2d.fillOval(x+10, y+20, 10, 10);
		g2d.fillOval(x+80, y+20, 10, 10);
		g2d.fillOval(x+45, y+35, 10, 10);
	}
}
