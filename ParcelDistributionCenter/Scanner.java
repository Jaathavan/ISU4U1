import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class Scanner {
	private boolean scan;
	private int colour;

	private BufferedImage plane = null;
	private BufferedImage truck = null;
	private BufferedImage unknown = null;
	private BufferedImage img = null;

	public Scanner() {
		this.scan = false;
		this.colour = 3;
	    try {
            plane = ImageIO.read(new File("Images/plane.png"));
			truck = ImageIO.read(new File("Images/truck.png"));
			unknown = ImageIO.read(new File("Images/unknown.png"));
        } catch (IOException e)
        {
            System.out.println("No Image");
        }
	}

	public boolean getScan() {
		return scan;
	}

	public int getColour() {
		return colour;
	}

	public BufferedImage getPlane() {
		return plane;
	}

	public BufferedImage getTruck() {
		return truck;
	}

	public BufferedImage getUnknown() {
		return unknown;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setColour(int colour) {
		this.colour = colour;
	}

	public void setScan(boolean scan) {
		this.scan = scan;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	} 
	
	public void paint(Graphics g) {
		//scanner box
		g.setColor(Color.GRAY);
		g.fillRect(200, 300-20, 100, 100);

		//scanner light
		if (getScan() == true) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.BLACK);
		}
		g.fillOval(200+10, 300-20+10, 10, 10);
		g.setColor(Color.BLACK);
		g.drawOval(200+10, 300-20+10, 10, 10);

		//scanner image
		if (getColour() == 0) {
			g.setColor(Color.BLUE);
			setImg(plane);
		}
		if (getColour() == 1) {
			g.setColor(Color.GREEN);
			setImg(truck);
		}
		if (getColour() == 2) {
			g.setColor(Color.YELLOW);
			setImg(unknown);
		}
		if (getColour() == 4) {
			g.setColor(Color.GRAY);
		}

		g.fillRoundRect(90, 290+20+100+50, 120, 120, 30, 30);
		g.drawImage(img, 100, 300+20+100+50, null);
		g.setColor(Color.BLACK);
		g.drawRoundRect(90, 290+20+100+50, 120, 120, 30, 30);
	}
}
