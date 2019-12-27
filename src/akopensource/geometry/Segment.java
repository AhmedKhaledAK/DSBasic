package akopensource.geometry;

public class Segment {

    public static boolean doTheyIntersect(Point p1, Point p2, Point p3, Point p4 ){
        return false;
    }

    public static double getDirection(Point pi, Point pj, Point pk){
        return  (pk.getX() - pi.getX()) * (pj.getY() - pi.getY()) - (pj.getX() - pi.getX()) * (pk.getY() - pi.getY());
    }

    public static boolean onSegment(Point pi, Point pj, Point pk){
        return (Double.min(pi.getX(), pj.getX()) <= pk.getX() && pk.getX() <= Double.max(pi.getX(), pj.getX()))
                && (Double.min(pi.getY(), pj.getY()) <= pk.getY() && pk.getY() <= Double.max(pi.getY(), pj.getY()));
    }
}
