public class Parcel {
    private int l,w,h,c;
    private int x,y;

    public Parcel (int l, int w, int h, int c) {
        this.l = l;
        this.w = w;
        this.h = h;
        this.c = c;
        x = 0;
        y= 300;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        x++;
    }

    
}