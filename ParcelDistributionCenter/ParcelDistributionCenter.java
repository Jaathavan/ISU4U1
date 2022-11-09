import java.awt.*;
import javax.swing.*;

public class ParcelDistributionCenter extends JPanel {


    @Override
    public void paint(Graphics g) {
        super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//bg colour of black
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 1020, 640);
    }

    public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Cityscape");
		ParcelDistributionCenter pdc = new ParcelDistributionCenter();
		frame.add(pdc);
		frame.setSize(1020, 640);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		while (true) {
			//pdc.move();
			pdc.repaint();
			Thread.sleep(10);
		}
	}
}