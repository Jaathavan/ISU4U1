import java.awt.*;

public class Building {
	private int x,y,w,h;
	private int[] lights;
	private int a;
	
	public Building (int x, int y, int w, int h, int[] lights) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		a = 0;
		this.lights = lights;
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
			for (int j=y; j+30 < h+getY()*5/6; j+=40) {
				int n = lights[a];
				if (n == 1) g.setColor(Color.YELLOW);
				g.fillRect(i, j + 10, 30, 30);
				a++;
				g.setColor(Color.BLACK);
			}
		}
		
		a=0;
		
		//g.fillRect(5+10+10+30, Math.round(640/3) + 10, 30, 30);
	}
}
