import java.awt.*;

public class ConveyorBelt {
    private boolean on;
    private int x,y,l,h;

    public ConveyorBelt(int x, int y, int l) {
        this.on = false;
        this.x = x;
        this.y = y;
        this.l = l;
        this.h = 12;
    }

    public boolean getOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.GRAY.darker().darker().darker().darker());
        g.fillRoundRect(x, y-50, l, h+40, 10, 10);
        
        g.fillRoundRect(x, y, l, h, 10, 10);
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y-50, l, h+40, 10, 10);
        g.drawRoundRect(x, y, l, h, 10, 10);
    }
}