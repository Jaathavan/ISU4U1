import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
	private ConveyorBelt cb1 = new ConveyorBelt(-5, 370, 295);
	private ConveyorBelt cb2 = new ConveyorBelt(500-5, 167, 530);
	private ConveyorBelt cb3 = new ConveyorBelt(500-5, 370, 530);
	private ConveyorBelt cb4 = new ConveyorBelt(500-5, 567, 530);
	private Switch sw = new Switch();
	
	public ParcelDistributionCenter() {
		for (int i = 0; i < list.length; i++) {
			if (i==0) {
				list[i] = new Parcel(randLH(), randLH(), randW(), randC(), 0);
			}
			else {
				list[i] = new Parcel(randLH(), randLH(), randW(), randC(), list[i-1].getX() - 200 - (list[i-1].getL() + list[i-1].getWXY()));
			}
		}
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				sw.keyPressed(e);
			}
		});

		setFocusable(true);
	}

	public void move() {
		for (Parcel p : list) {
			if(sw.getOn() == true || p.getX() >= 400) {
				p.move();
			}
			if (p.getX() >= 400) {
				if (p.getC() == 2 && p.getX() <= 1020+p.getL()+p.getWXY()) {
					p.setY(500);
					cb4.move();
				}
				if (p.getC() == 1 && p.getX() <= 1020+p.getL()+p.getWXY()) {
					cb3.move();
				}
				if (p.getC() == 0 && p.getX() <= 1020+p.getL()+p.getWXY()) {
					p.setY(100);
					cb2.move();
				}
			}
		}

		if (list[i].getX() > 500 && i < 19) {
			i++;
		}

		if (list[i].getX() >= 300 && list[i].getX() < 500) {
			s.setScan(true);
			s.setColour(list[i].getC());
		}
		else {
			s.setScan(false);
		}
		
		if(sw.getOn() == true) {
			cb1.move();
		}
		
		if (list[i].getX() > 500 && i < 19) {
			list[i].move();
			cb2.move();
			cb3.move();
			cb4.move();
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

		//Overlay of 3d scanner
		g.setColor(Color.GRAY.darker());
		g.fillRect(250, 300-20, 100, 100);
		g.fillRect(350, 300-20-200, 100, 500);

		g.setColor(Color.GRAY.darker().darker().darker().darker().darker().darker());
		g.fillRect(250+10, 300-20+10, 30, 83);

		g.setColor(Color.BLACK);
		g.drawPolygon(new int[] {250, 350, 350, 500, 500, 350, 350, 250}, new int[] {280, 280, 80, 80, 580, 580, 380, 380}, 8);
		
		cb1.paint(g2d);
		cb2.paint(g2d);
		cb3.paint(g2d);
		cb4.paint(g2d);

		g.fillPolygon(new int[] {260, 290, 290}, new int[] {320, 320, 373}, 3);
		// parcels
		for (Parcel p : list) {
			p.paint(g2d);
		}

		//overlay to top
		g.setColor(Color.GRAY.darker());
		g.fillRect(250+10+30, 300-20+10, 10, 85);
		//scanner
		s.paint(g2d);
		g.setColor(Color.BLACK);
		g.drawPolygon(new int[] {300, 400, 400, 500, 500, 400, 400, 300}, new int[] {280, 280, 80, 80, 580, 580, 380, 380}, 8);
		
		sw.paint(g2d);
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
