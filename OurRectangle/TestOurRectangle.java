
public class TestOurRectangle {
    public static void main(String[] args) {
        //create rectangle
        OurRectangle r = new OurRectangle(3, 2, 4, 5);
        
        //test toString Method
        System.out.println(r.toString());

        //test area Method
        System.out.println("Area: " + r.area());

        //test perimeter Method
        System.out.println("Perimeter: " + r.perimeter());

        OurRectangle s = new OurRectangle(1, 2, 5, 7);
        OurRectangle inters = OurRectangle.intersection(r, s);

        //test intersection method
        System.out.println("Intersection: " + inters);

        int perm = OurRectangle.totalPerimeter(r, s);
        
        //test perimeter method
        System.out.println("New Perimeter: " + perm);
        
        OurRectangle n = new OurRectangle(1, 4, 5, 4);
        OurRectangle m = new OurRectangle(3, 5, 2, 1);
        
        OurRectangle newinter = OurRectangle.intersection(n, m);
        int newperm = OurRectangle.totalPerimeter(n, m);

        //test contains
        System.out.println("Inter: " + newinter);
        System.out.println("Newpermi: " + newperm);
        System.out.println("Contains: " + n.contains(m));

        //permi checks
        OurRectangle a = new OurRectangle(1, 3, 5, 2);
        OurRectangle b = new OurRectangle(5, 1, 3, 6);
        int permu = OurRectangle.totalPerimeter(a, b);
        OurRectangle iinter = OurRectangle.intersection(a, b);
        System.out.println("permu: " + permu);
        System.out.println("Iinter: " + iinter);
    }
}