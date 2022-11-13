import java.awt.*;

public class ConveyorBelt {
    private boolean on;
    private int x,y,l,h, xx, a;

    public ConveyorBelt(int x, int y, int l) {
        this.on = true;
        this.x = x;
        this.y = y;
        this.l = l;
        this.h = 12;
        this.xx = x;
        this.a = 30;
    }

    public boolean getOn() {
        return on;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getL() {
        return l;
    }
    
    public int getH() {
        return h;
    }

    public int getXX() {
        return xx;
    }

    public int getA() {
        return a;
    }

    public void setXX(int xx) {
        this.xx = xx;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
    
    public void move() {
        if (getXX() == getX()+20) {
            setXX(getXX() - 20);
        }
        if (getA() == 360) {
            setA(1);
        }
        setXX(getXX() + 1);
        setA(getA() + 1);
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.GRAY.darker().darker().darker().darker());
        g.fillRoundRect(getX(), getY()-50, getL(), getH()+40, 10, 10);
        
        g.setColor(Color.GRAY.darker().darker().darker().darker());
        g.fillRoundRect(getX(), getY()+2, getL(), getH(), 10, 10);
        for (int i=getX(); i < getX()+getL(); i+=15) {
            g.setColor(Color.GRAY);
            g.fillOval(i, getY()+3, 10, 10);
            g.setColor(Color.BLACK);
            g.drawOval(i, getY()+3, 10, 10);
            g.setColor(Color.GRAY.darker());
            g.fillArc(i+3, getY()+6, 5, 5, 180, getA());
            g.setColor(Color.BLACK);
            //g.drawLine(i+5, getY()+8, i, getY()+8);
        }

        for (int i=getXX()-15; i < getXX()+getL(); i+=15) {
            g.drawLine(i, getY()-50, i+20, getY()+2);
        }
        
        g.setColor(Color.BLACK);
        g.drawRoundRect(getX(), getY()-50, getL(), getH()+40, 10, 10);
        g.drawRoundRect(getX(), getY()+2, getL(), getH(), 10, 10);
    }
}