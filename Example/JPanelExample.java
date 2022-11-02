package Example;
import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class JPanelExample extends JPanel {
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.fillOval(0, 0, 30, 30);
		g2d.drawOval(0, 50, 30, 30);
		g2d.fillRect(50, 0, 30, 30);
		g2d.drawRect(50, 50, 30, 30);
		g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Mini Tennis");
		// Add our JPanel to the frame
		frame.add(new JPanelExample());
// if you use setContentPane it will allow you to switch
// easily between multiple panels
// frame.setContentPane(new JPanelExample());
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}