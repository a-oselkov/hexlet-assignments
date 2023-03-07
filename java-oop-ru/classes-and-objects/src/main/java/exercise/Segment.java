package exercise;

// BEGIN
public class Segment {
    Point begin;
    Point end;

    public Segment(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }
    public Point getBeginPoint() {
        return begin;
    }
    public Point getEndPoint() {
        return end;
    }
    public Point getMidPoint() {
        Point beginPoint = getBeginPoint();
        Point endPoint = getEndPoint();
        int midX = (beginPoint.getX() + endPoint.getX()) / 2;
        int midY = (beginPoint.getY() + endPoint.getY()) / 2;
        return new Point(midX, midY);
    }
}
// END
