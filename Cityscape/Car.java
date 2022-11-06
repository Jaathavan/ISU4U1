import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class Car {
    private int x = 0;
    private int y = 425;
    private int xa = 2; // Horizontal speed
    private BufferedImage img = null;
    
    public Car() {
        try {
            img = ImageIO.read(new File("car.gif"));
        } catch (IOException e)
        {
            System.out.println("No Image");
        }
    }

    public void move() {
        if ((x + xa < 0-200)  || (x + xa > 1020)) // If the ball exceeds the left
			xa *= -1;
		
		x += xa;
    }

    public void paint(Graphics2D g) {
        if (xa > 0) {
            g.drawImage(img, x, y, null);
        }
        if (xa < 0) {
            g.drawImage(img, x + 200, y, -200, 186, null);
        }
    }
}
