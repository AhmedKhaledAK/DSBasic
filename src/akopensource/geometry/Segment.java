package akopensource.geometry;

public class Segment {

    public static boolean doTheyIntersect(Point p1, Point p2, Point p3, Point p4 ){
        double d1 = getDirection(p3,p4,p1);
        double d2 = getDirection(p3,p4,p2);
        double d3 = getDirection(p1,p2,p3);
        double d4 = getDirection(p1,p2,p4);

        if ( ((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) && ((d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0)) )
            return true;

        if(d1 == 0 && onSegment(p3,p4,p1))
            return true;

        if(d2==0 && onSegment(p3,p4,p2))
            return true;

        if(d3 == 0 && onSegment(p1,p2,p3))
            return true;

        return d4 == 0 && onSegment(p1, p2, p4);

    }

    public static double getDirection(Point pi, Point pj, Point pk){
        return  (pk.getX() - pi.getX()) * (pj.getY() - pi.getY()) - (pj.getX() - pi.getX()) * (pk.getY() - pi.getY());
    }

    public static boolean onSegment(Point pi, Point pj, Point pk){
        return (Double.min(pi.getX(), pj.getX()) <= pk.getX() && pk.getX() <= Double.max(pi.getX(), pj.getX()))
                && (Double.min(pi.getY(), pj.getY()) <= pk.getY() && pk.getY() <= Double.max(pi.getY(), pj.getY()));
    }
}
