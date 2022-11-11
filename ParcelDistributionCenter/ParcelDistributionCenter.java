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

	private Parcel p = new Parcel(randLH(), randLH(), randW(), randC(), 0);
	private Parcel p1 = new Parcel(randLH(), randLH(), randW(), randC(),
			p.getX() - 200 - (p.getX() + p.getL() + p.getWXY()));
	private Parcel p2 = new Parcel(randLH(), randLH(), randW(), randC(), p1.getX() - 200 - (p1.getL() + p1.getWXY()));
	private Parcel p3 = new Parcel(randLH(), randLH(), randW(), randC(), p2.getX() - 200 - (p2.getL() + p2.getWXY()));
	private Parcel p4 = new Parcel(randLH(), randLH(), randW(), randC(), p3.getX() - 200 - (p3.getL() + p3.getWXY()));
	private Parcel p5 = new Parcel(randLH(), randLH(), randW(), randC(), p4.getX() - 200 - (p4.getL() + p4.getWXY()));
	private Parcel p6 = new Parcel(randLH(), randLH(), randW(), randC(), p5.getX() - 200 - (p5.getL() + p5.getWXY()));
	private Parcel p7 = new Parcel(randLH(), randLH(), randW(), randC(), p6.getX() - 200 - (p6.getL() + p6.getWXY()));
	private Parcel p8 = new Parcel(randLH(), randLH(), randW(), randC(), p7.getX() - 200 - (p7.getL() + p7.getWXY()));
	private Parcel p9 = new Parcel(randLH(), randLH(), randW(), randC(), p8.getX() - 200 - (p8.getL() + p8.getWXY()));
	private Parcel p10 = new Parcel(randLH(), randLH(), randW(), randC(), p9.getX() - 200 - (p.getL() + p9.getWXY()));
	private Parcel p11 = new Parcel(randLH(), randLH(), randW(), randC(),
			p10.getX() - 200 - (p10.getL() + p10.getWXY()));
	private Parcel p12 = new Parcel(randLH(), randLH(), randW(), randC(),
			p11.getX() - 200 - (p11.getL() + p11.getWXY()));
	private Parcel p13 = new Parcel(randLH(), randLH(), randW(), randC(),
			p12.getX() - 200 - (p12.getL() + p12.getWXY()));
	private Parcel p14 = new Parcel(randLH(), randLH(), randW(), randC(),
			p13.getX() - 200 - (p13.getL() + p13.getWXY()));
	private Parcel p15 = new Parcel(randLH(), randLH(), randW(), randC(),
			p14.getX() - 200 - (p14.getL() + p14.getWXY()));
	private Parcel p16 = new Parcel(randLH(), randLH(), randW(), randC(),
			p15.getX() - 200 - (p15.getL() + p15.getWXY()));
	private Parcel p17 = new Parcel(randLH(), randLH(), randW(), randC(),
			p16.getX() - 200 - (p16.getL() + p16.getWXY()));
	private Parcel p18 = new Parcel(randLH(), randLH(), randW(), randC(),
			p17.getX() - 200 - (p17.getL() + p17.getWXY()));
	private Parcel p19 = new Parcel(randLH(), randLH(), randW(), randC(),
			p18.getX() - 200 - (p18.getL() + p18.getWXY()));
	
	private Scanner s = new Scanner();
	
	public void move() {
		p.move();
		p1.move();
		p2.move();
		p3.move();
		p4.move();
		p5.move();
		p6.move();
		p7.move();
		p8.move();
		p9.move();
		p10.move();
		p11.move();
		p12.move();
		p13.move();
		p14.move();
		p15.move();
		p16.move();
		p17.move();
		p18.move();
		p19.move();
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
		p.paint(g2d);
		p1.paint(g2d);
		p2.paint(g2d);
		p3.paint(g2d);
		p4.paint(g2d);
		p5.paint(g2d);
		p6.paint(g2d);
		p7.paint(g2d);
		p8.paint(g2d);
		p9.paint(g2d);
		p10.paint(g2d);
		p11.paint(g2d);
		p12.paint(g2d);
		p13.paint(g2d);
		p14.paint(g2d);
		p15.paint(g2d);
		p16.paint(g2d);
		p17.paint(g2d);
		p18.paint(g2d);
		p19.paint(g2d);
		
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
