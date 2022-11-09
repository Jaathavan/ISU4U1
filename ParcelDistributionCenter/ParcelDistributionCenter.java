import java.awt.*;
import javax.swing.*;

public class ParcelDistributionCenter extends JPanel {
    private int x= 100;
    private int y = 50;
    private int l = 50;
    private int w = 100;
    private int h = 10;
    private int wx = w*(int)Math.sin(Math.toRadians(45));
    private int wy = w*(int)Math.cos(Math.toRadians(45));

    @Override
    public void paint(Graphics g) {
        super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//bg colour of gray
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 1020, 640);

        g.setColor(Color.ORANGE);
        g.drawPolygon(new int[] {x, x+l, x+l+wx, x+l+wx, x+wx, x }, new int[] {y, y, y+wy, y+wy+h, y+wy+h, y+h}, 6);
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