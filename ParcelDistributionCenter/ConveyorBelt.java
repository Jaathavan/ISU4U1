import java.awt.*;

public class ConveyorBelt {
    private boolean on;
    private int x,y,l,h, xx;

    public ConveyorBelt(int x, int y, int l) {
        this.on = false;
        this.x = x;
        this.y = y;
        this.l = l;
        this.h = 12;
        this.xx = x;
    }

    public boolean getOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
    
    public void move() {
        if (xx == x+20) {
            xx-=20;
        }
        xx++;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.GRAY.darker().darker().darker().darker());
        g.fillRoundRect(x, y-50, l, h+40, 10, 10);
        
        g.setColor(Color.GRAY.darker().darker().darker().darker());
        g.fillRoundRect(x, y+2, l, h, 10, 10);
        for (int i=x; i < x+l; i+=15) {
            g.setColor(Color.GRAY);
            g.fillOval(i, y+3, 10, 10);
            g.setColor(Color.BLACK);
            g.drawOval(i, y+3, 10, 10);
            g.drawLine(i, y+10, i+5, y+8);
        }
        for (int i=xx; i < xx+l; i+=15) {
            //g.drawLine(i, y+10, i+5, y+8);
            g.drawLine(i, y-50, i+20, y+2);
        }
        
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y-50, l, h+40, 10, 10);
        g.drawRoundRect(x, y+2, l, h, 10, 10);
    }
}