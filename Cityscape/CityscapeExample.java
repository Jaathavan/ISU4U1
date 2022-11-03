import java.awt.*;
import javax.swing.*;

public class CityscapeExample extends JPanel {

	private Cityscape cs = new Cityscape();
	private Building b = new Building(5, Math.round(640/3), 1020/5, Math.round(640/3)*2);

	public UFO u = new UFO(this); // Add an instance of the ball object

	public void move() {
		u.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		cs.paint(g2d);
		b.paint(g2d);

		// Smooth’s out the movement
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		u.paint(g2d);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Cityscape Example");
		frame.setSize(1020, 640);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CityscapeExample ua = new CityscapeExample();
		frame.add(ua);
		while (true) {
			ua.move();
			ua.repaint();
			Thread.sleep(10);
		}
	}
}
