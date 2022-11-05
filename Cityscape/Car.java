import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class Car {
    private int x = 0;
    private int y = 425;
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
        x++;
    }

    public void paint(Graphics2D g) {
        g.drawImage(img, x, y, null);
    }
}
