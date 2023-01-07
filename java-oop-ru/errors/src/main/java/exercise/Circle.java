package exercise;

// BEGIN
class Circle {
    private Point point;
    private int radius;

    Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }
    public int getRadius() {
        return radius;
    }
    public double getSquare() throws NegativeRadiusException {
        if (this.radius < 0) {
            throw new NegativeRadiusException("Error");
        }
        return Math.PI * getRadius() * getRadius();
    }
}
// END
