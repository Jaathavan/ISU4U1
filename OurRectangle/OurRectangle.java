/*
 * Jaathavan Ranjanathan
 * ISU4U1
 */

public class OurRectangle {
    //attributes
    private int x;
    private int y;
    private int width;
    private int height;

    //constructor
    public OurRectangle (int xx, int yy, int w, int h) {
        //set initial values to 0
        x = 0; 
        y = 0;
        width = 0;
        height = 0;

        //sets correct value if !negative
        if (xx >= 0) {
            x = xx;
        }

        if (yy >= 0) {
            y = yy;
        }
        if (w >= 0) {
            width = w;
        }
        if (h >= 0) {
            height = h;
        }
    }


    //mutators

    public void setX(int xx) {
        x = xx;
    }

    public void setY(int yy) {
        y = yy;
    }

    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }


    //accessors

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    //returns string with all info
    public String toString() {
        return "base: (" + getX() + "," + getY() + ") w:" + getWidth() + " h:" + getHeight();
    }

    //returns area
    public int area() {
        return getWidth() * getHeight();
    }

    //returns perimeter
    public int perimeter() {
        return 2 * (getWidth() + getHeight());
    }
    
    //returns a boolean telling if the rectangle can be contained within it
    public boolean contains(OurRectangle rec1) {
        //bottom left corner (x, y) coordinate of container rectangle  
        int[] a1 = { this.getX(), this.getY() };
        //top right corner (x, y) coordinate of container rectangle
        int[] a2 = { (this.getX()+this.getWidth()), (this.getY()+this.getHeight()) };
        
        //bottom left corner (x, y) coordinate of inner rectangle
        int[] b1 = { rec1.getX(), rec1.getY() };
        //top right corner (x, y) coordinate of inner rectangle
        int[] b2 = { (rec1.getX()+rec1.getWidth()), (rec1.getY()+rec1.getHeight()) };
        
        //true if a1 values are smaller than b1 & a2 values are greater than b2; else false
        return (a1[0] <= b1[0] && a1[1] <= b1[1] && a2[0] >= b2[0]  && a2[1] >= b2[1]);
    }
    
    //returns the rectangle formed from the intersection of two rectangles
    public static OurRectangle intersection(OurRectangle rec1, OurRectangle rec2) {
        //initialize new rectangle with all values at 0
        OurRectangle inter = new OurRectangle(0, 0, 0, 0);
        
        //create an array that holds the (X,Y) coordinates of bottom left and top right of both rectangles
        //l=bottom left, r=top right
        int[] l1 = { rec1.getX(), rec1.getY() };
        int[] r1 = { (rec1.getX()+rec1.getWidth()), (rec1.getY()+rec1.getHeight()) };
        int[] l2 = { rec2.getX(), rec2.getY() };
        int[] r2 = { (rec2.getX()+rec2.getWidth()), (rec2.getY()+rec2.getHeight()) };
        
        //find width and height of intersection
        //when you take coordinate closest to the left/bottom from the right/top and
        //subtract it by the coordinate closest to the right/top from the left/bottom you can get the dimensions
        //if the value is - then the rectangles do not intersection
        int width = Math.min(r1[0], r2[0]) - Math.max(l1[0], l2[0]);
        int height = Math.min(r1[1], r2[1]) - Math.max(l1[1], l2[1]);

        //set new rectangle width if +
        if (width > 0) {
            inter.width = width;
        }

        //set new rectangle height if +
        if (height > 0) {
            inter.height = height;
        }

        //sets (x,y) if intersection is true
        if (width > 0 || height > 0) {
            //gets the bottom left corner coordinates
            //subtract the leftmost x coordinate at the top right by the width to get the coordinate
            inter.x = Math.min(r1[0], r2[0]) - width;
            //subtract the leftmost y coordinate at the top right by the width to get the coordinate
            inter.y = Math.min(r1[1], r2[1]) - height;
        }

        //return new rectangle
        return inter;
    }

    //returns perimeter of shape formed in intersection
    public static int totalPerimeter(OurRectangle rec1, OurRectangle rec2) {
        //create an array that holds the (X,Y) coordinates of bottom left and top right of both rectangles
        //l=bottom left, r=top right
        int[] l1 = { rec1.getX(), rec1.getY() };
        int[] r1 = { (rec1.getX()+rec1.getWidth()), (rec1.getY()+rec1.getHeight()) };
        int[] l2 = { rec2.getX(), rec2.getY() };
        int[] r2 = { (rec2.getX()+rec2.getWidth()), (rec2.getY()+rec2.getHeight()) };
        
        //when two rectangles intersect you can move around the sides to
        //form a larger rectangle based on the longest width and height of the shape

        //finds width/height by finding the largest possible length & width between the 2 corners
        int width = Math.max(r1[0], r2[0]) - Math.min(l1[0], l2[0]);
        int height = Math.max(r1[0], r2[0]) - Math.min(l1[0], l2[0]);
        
        //uses intersection height/width formula to find height/width
        int doesIntersectW = Math.min(r1[0], r2[0]) - Math.max(l1[0], l2[0]);
        int doesIntersectH = Math.min(r1[1], r2[1]) - Math.max(l1[1], l2[1]);
        
        //if height and weight are >=0 then return the perimeter using new length and width
        if (doesIntersectW >= 0 && doesIntersectH >= 0) {
          return 2*(width+height);
        }
        
        //otherwise return sum of both perimeters
        return rec1.perimeter() + rec2.perimeter();
    }
}