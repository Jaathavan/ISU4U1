import java.awt.*;
import javax.swing.*;

public class Cityscape extends JPanel {
	public int[] setLights(int w, int h) {
		int[] lights = new int[ (int)Math.floor(w/40)*(int)Math.floor(h/40)];
		for (int i=0; i < ((int)Math.floor(w/40)*(int)Math.floor(h/40)); i++) {
			lights[i] = (int) (Math.random()*2);
		}
		return lights;
	}
	private Building b = new Building(5, Math.round(640/3), 1020/5, Math.round(640/3)*2, setLights(1020/5, Math.round(640/3)*2));
	private Building b1 = new Building(15 + b.getW(), Math.round(640/3), Math.round(1020/8), Math.round(640*2/3), setLights(Math.round(1020/8), Math.round(640*2/3)));
	private Building b2 = new Building(15 + b1.getX() + b1.getW(), Math.round(640/3), Math.round(1020/4), Math.round(640*2/3), setLights(Math.round(1020/4), Math.round(640*2/3)));
	private Building b3 = new Building(15 + b2.getX() + b2.getW(), Math.round(640/3), Math.round(1020/10), Math.round(640*2/3), setLights(Math.round(1020/10), Math.round(640*2/3)));
	private Building b4 = new Building(15 + b3.getX() + b3.getW(), Math.round(640/3), Math.round(1020/7), Math.round(640*2/3), setLights(Math.round(1020/7), Math.round(640*2/3)));
	private Building b5 = new Building(15 + b4.getX() + b4.getW(), Math.round(640/3), Math.round(1020/12), Math.round(640*2/3), setLights(Math.round(1020/12), Math.round(640*2/3)));
	
	private Car c = new Car();


	UFO[] list = new UFO[4];

	public Cityscape() {
		//Randomly create each Ball in the list
		for (int i = 0; i< list.length; i++)
			list[i] = new UFO(this, i*50, i*50,
					(int)(10 * Math.random() - 5),
					(int)(10 * Math.random() - 5));
	}

	public void move() {
		c.move();
		// Check for collisions between each of the balls
		for (int i = 0; i < list.length; i++)
			for (int j = i + 1; j < list.length; j++)
				list[i].collision(list[j]);
		// Move each Ball in the list
		for (UFO b : list)
			b.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//bg colour of black
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1020, 640);

		b.paint(g2d);
		b1.paint(g2d);
		b2.paint(g2d);
		b3.paint(g2d);
		b4.paint(g2d);
		b5.paint(g2d);
		
		c.paint(g2d);

		for (UFO b : list)
			b.paint(g2d);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Cityscape");
		Cityscape ua = new Cityscape();
		frame.add(ua);
		frame.setSize(1020, 640);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		while (true) {
			ua.move();
			ua.repaint();
			Thread.sleep(10);
		}
	}
}
