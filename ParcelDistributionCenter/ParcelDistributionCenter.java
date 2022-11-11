import java.awt.*;
import javax.swing.*;

public class ParcelDistributionCenter extends JPanel {
    public int randLH() {
    	return (int)(Math.random()*30) +20;
    }
    
    public int randW() {
    	return (int)(Math.random()*40) +10;
    }
    
    public int randC() {
    	return (int) (Math.random()*3);
    }
    
	
	private Parcel p = new Parcel(randLH(), randLH(), randW(), randC(), 0);
	private Parcel p1 = new Parcel(randLH(), randLH(), randW(), randC(), p.getX()-200-(p.getX()+p.getL()+p.getWXY()));
	
	public void move() {
		p.move();
	}
	
    @Override
    public void paint(Graphics g) {
    	super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//bg colour of gray
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 1020, 640);
        p.paint(g2d);

    }

    public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Parcel Distribution Center");
		ParcelDistributionCenter pdc = new ParcelDistributionCenter();
		frame.add(pdc);
		frame.setSize(1020, 640);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		while (true) {
			pdc.move();
			pdc.repaint();
			Thread.sleep(10);
		}
	}
}
