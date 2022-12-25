package exercise;

// BEGIN
class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + this.getArea() + " метров на " + this.getFloor() + " этаже";
    }

    @Override

    public double getArea() {
        return this.area + this.balconyArea;
    }
}
// END
