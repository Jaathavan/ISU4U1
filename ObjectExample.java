package HappyFace;
import java.awt.*;
import javax.swing.*;

public class ObjectExample extends JPanel {
	private HappyFace hf = new HappyFace(50, 50);
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		hf.paint(g2d);
	}
	
	public static void main(String [] args) {
		JFrame frame = new JFrame("Object Example");
		frame.add(new ObjectExample());
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
