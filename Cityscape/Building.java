import java.awt.*;

public class Building {
	private int x,y,w,h;
	
	public Building (int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	
	public void paint(Graphics2D g) {
		//building
		g.setColor(Color.GRAY);
		g.fillRect(x, y, w, h);
		
		g.setColor(Color.BLACK);
		//g.fillRect(x+10, y + 10, 30, 30);
		
		for (int i=x+10; i+30 < w+getX(); i+=40) {
			for (int j=y; j+30 < h+getY()*2/3; j+=40) {
				int n = (int) (Math.random()*2);
				if (n == 1) g.setColor(Color.YELLOW);
				g.fillRect(i, j + 10, 30, 30);
				g.setColor(Color.BLACK);
				int x = (int) (Math.random()*2);
				if (x == 1) g.setColor(Color.YELLOW);
				g.fillRect(i, j + 10, 30, 30);
			}
		}
		
		//g.fillRect(5+10+10+30, Math.round(640/3) + 10, 30, 30);
	}
}
