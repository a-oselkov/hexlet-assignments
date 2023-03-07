package exercise;

// BEGIN
public class Segment {
    Point beginPoint;
    Point endPoint;

    public Segment(Point begin, Point end) {
        this.beginPoint = begin;
        this.endPoint = end;
    }
    public Point getBeginPoint() {
        return beginPoint;
    }
    public Point getEndPoint() {
        return endPoint;
    }
    public Point getMidPoint() {
        int midX = (beginPoint.getX() + endPoint.getX()) / 2;
        int midY = (beginPoint.getY() + endPoint.getY()) / 2;
        return new Point(midX, midY);
    }
}
// END
