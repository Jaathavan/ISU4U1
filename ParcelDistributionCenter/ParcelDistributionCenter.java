import java.awt.*;
import javax.swing.*;

public class ParcelDistributionCenter extends JPanel {
	public int randLH() {
		return (int) (Math.random() * 30) + 20;
	}

	public int randW() {
		return (int) (Math.random() * 40) + 10;
	}

	public int randC() {
		return (int) (Math.random() * 3);
	}

	Parcel[] list = new Parcel[20];
	private int i = 0;
	private Scanner s = new Scanner();


	public ParcelDistributionCenter() {
		for (int i = 0; i < list.length; i++) {
			if (i==0) {
				list[i] = new Parcel(randLH(), randLH(), randW(), randC(), 0);
			}
			else {
				list[i] = new Parcel(randLH(), randLH(), randW(), randC(), list[i-1].getX() - 200 - (list[i-1].getL() + list[i-1].getWXY()));
			}
		}
	}

	public void move() {
		for (Parcel p : list) {
			p.move();
		}

		if (list[i].getX() > 300 && i < 20) {
			i++;
		}

		if (list[i].getX() >= 200 && list[i].getX() <= 300) {
			s.setScan(true);
		}
		else {
			s.setScan(false);
		}
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// bg colour of gray
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 1020, 640);

		// parcels
		for (Parcel p : list) {
			p.paint(g2d);
		}
		
		//scanner
		s.paint(g2d);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Parcel Distribution Center");
		ParcelDistributionCenter pdc = new ParcelDistributionCenter();
		frame.add(pdc);
		frame.setSize(1020, 640);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			pdc.move();
			pdc.repaint();
			Thread.sleep(10);
		}
	}
}
