import java.awt.*;

public class Parcel {
    private int l,h, w, c;
    private int x,y,wxy;

    public Parcel (int l, int h, int w, int c, int x) {
        this.l = l;
        this.h = h;
        this.w = w;
        this.c = c;
        this.x = x;
        y= 300;
        wxy = this.w*(int)Math.sqrt(2)/2;
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
    
    public int getW() {
        return w;
    }
    
    public int getC() {
        return c;
    }
    
    public int getWXY() {
        return wxy;
    }

    public void move() {
        x++;
    }
    
    public void paint(Graphics2D g) {
    	if (getC() == 0) g.setColor(Color.BLUE);
    	if (getC() == 1) g.setColor(Color.GREEN);
    	if (getC() == 2) g.setColor(Color.YELLOW);
    	
        g.fillPolygon(new int[] {getX(), getX()+getL(), getX()+getL()+getWXY(), getX()+getL()+getWXY(), getX()+getWXY(), getX()}, new int[] {getY(), getY(), getY()+getWXY(), getY()+getWXY()+getH(), getY()+getWXY()+getH(), getY()+getH()}, 6);
        g.setColor(Color.BLACK);
        g.drawLine(getX(), getY(), getX()+getL(), getY());
        g.drawLine(getX()+getL(), getY(), getX()+getL()+getWXY(), getY()+getWXY());
        g.drawLine(getX()+getL()+getWXY(), getY()+getWXY(), getX()+getL()+getWXY(), getY()+getWXY()+getH());
        g.drawLine(getX()+getL()+getWXY(), getY()+getWXY()+getH(), getX()+getWXY(), getY()+getWXY()+getH());
        g.drawLine(getX()+getWXY(), getY()+getWXY()+getH(), getX(), getY()+getH());
        g.drawLine(getX(), getY()+getH(), getX(), getY());
        g.drawLine(getX()+getWXY(), getY()+getWXY()+getH(), getX()+getWXY(), getY()+getWXY());
        g.drawLine(getX()+getWXY(), getY()+getWXY(), getX(), getY());
        g.drawLine(getX()+getWXY(), getY()+getWXY(), getX()+getL()+getWXY(), getY()+getWXY());
    }
    
}
