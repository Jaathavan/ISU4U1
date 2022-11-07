import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BallAnimation extends JPanel {
	Ball b = new Ball();

	public BallAnimation() {
		// This adds the KeyListener to the BallAnimation. It’s in this section that
		// you HAVE to have all three key listener methods whether they are used
		// or not. We place the KeyListener in the JPanel class because as we
		// mentioned before it is the director of all the action, so it receives
		// the keyboard information and then passes it along to the appropriate
		// classes.
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// Passes the KeyEvent e to the ball instance
				b.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// Passes the KeyEvent e to the ball instance
				b.keyPressed(e);
			}
		}); // NOTE THE SEMI-COLON!!!!
		// Making sure our JPanel has the focus and therefor it is the
		// instance that will receive the keyboard input
		setFocusable(true);
	}

	private void move() {
		b.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		b.paint(g2d);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Ball World");
		BallAnimation bw = new BallAnimation();
		frame.add(bw);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (true) {
			bw.move();
			bw.repaint();
			Thread.sleep(10);
		}
	}
}