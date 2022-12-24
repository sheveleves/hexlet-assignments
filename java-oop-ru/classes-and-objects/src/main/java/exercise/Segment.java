package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        int midX = (getBeginPoint().getX() + getEndPoint().getX()) / 2;
        int midY = (getBeginPoint().getX() + getEndPoint().getY()) / 2;
        return new Point(midX, midY);
    }
}
// END
