package exercise;

// BEGIN
class Cottage implements Home {
    private double area;
    private int floorCount;

    Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public int getFloorCount() {
        return floorCount;
    }

    @Override
    public String toString() {
        return this.getFloorCount() + " этажный коттедж площадью " + this.area + " метров";
    }

    @Override
    public double getArea() {
        return this.area;
    }
}
// END
