import java.awt.*;
import javax.swing.*;

public class CityscapeExample extends JPanel {

	private Cityscape cs = new Cityscape();
	private Building b = new Building();

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		cs.paint(g2d);
		b.paint(g2d);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Cityscape Example");
		frame.add(new CityscapeExample());
		frame.setSize(1020, 640);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
