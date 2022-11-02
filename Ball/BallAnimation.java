package BallAnimation;

import java.awt.*;
import javax.swing.*;

public class BallAnimation extends JPanel {

	private Ball b = new Ball(this); // Add an instance of the ball object

	private void move() {
		b.move();
	}

	public void paint(Graphics g) {
		super.paint(g); // Clears the panel, for a fresh start
		Graphics2D g2d = (Graphics2D) g;
		// Smooth’s out the movement
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		b.paint(g2d);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame f = new JFrame("Ball Animation 1");
		f.setSize(300, 300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BallAnimation p = new BallAnimation();
		f.add(p);
		while (true) {
			p.move(); // Updates the coordinates
			p.repaint(); // Calls the paint method
			Thread.sleep(10); // Pauses for a moment
		}
	}

}
