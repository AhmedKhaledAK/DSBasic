package akopensource.geometry;

public class Segment {

    public static boolean doTheyIntersect(Point p1, Point p2, Point p3, Point p4 ){
        return false;
    }

    public static double getDirection(Point pi, Point pj, Point pk){
        return  (pk.getX() - pi.getX()) * (pj.getY() - pi.getY()) - (pj.getX() - pi.getX()) * (pk.getY() - pi.getY());
    }

    public static boolean onSegment(Point pi, Point pj, Point pk){
        return false;
    }
}
