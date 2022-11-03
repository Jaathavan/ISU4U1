import java.awt.*;
import javax.swing.*;

public class Cityscape extends JPanel {

	//private Cityscape cs = new Cityscape();
	private Building b = new Building(5, Math.round(640/3), 1020/5, Math.round(640/3)*2);
	private Building b = new Building(5, Math.round(640/3), (1020/5), Math.round(640*2/3));
	private Building b1 = new Building(15 + b.getW(), Math.round(640/3), Math.round(1020/8), Math.round(640*2/3));
	private Building b2 = new Building(15 + b1.getX() + b1.getW(), Math.round(640/3), Math.round(1020/4), Math.round(640*2/3));
	private Building b3 = new Building(15 + b2.getX() + b2.getW(), Math.round(640/3), Math.round(1020/10), Math.round(640*2/3));
	private Building b4 = new Building(15 + b3.getX() + b3.getW(), Math.round(640/3), Math.round(1020/7), Math.round(640*2/3));
	private Building b5 = new Building(15 + b4.getX() + b4.getW(), Math.round(640/3), Math.round(1020/12), Math.round(640*2/3));
	
	public UFO u = new UFO(this); // Add an instance of the ball object

	public void move() {
		u.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		//bg colour of black
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1020, 640);

		//cs.paint(g2d);
		b.paint(g2d);
		b1.paint(g2d);
		b2.paint(g2d);
		b3.paint(g2d);
		b4.paint(g2d);
		b5.paint(g2d);
		
		// Smooth’s out the movement
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		u.paint(g2d);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Cityscape");
		frame.setSize(1020, 640);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Cityscape ua = new Cityscape();
		frame.add(ua);
		while (true) {
			ua.move();
			ua.repaint();
			Thread.sleep(10);
		}
	}
}
