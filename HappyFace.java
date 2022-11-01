package HappyFace;
import java.awt.*;
import java.awt.Graphics2D;

public class HappyFace {
	private int x;
	private int y;
	
	public HappyFace(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.drawOval(x, y, 30, 30);
		g.fillOval(x, y, 30, 30);
		g.setColor(Color.BLACK);
		g.drawOval(x+10, y+10, 5, 5);
		g.fillOval(x+10, y+10, 5, 5);
		g.drawOval(x+20, y+10, 5, 5);
		g.fillOval(x+20, y+10, 5, 5);
		g.drawArc(x+10, y+10, 15, 15, 180, 180);
		g.fillArc(x+10, y+10, 15, 15, 180, 180);
	}
	
}
