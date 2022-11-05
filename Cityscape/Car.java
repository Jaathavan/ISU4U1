import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class Car {
    private int x = 0;
    private int y = 100;
    private BufferedImage img = null;
    
    public Car() {
        try {
            img = ImageIO.read(new File("car.webp"));
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
