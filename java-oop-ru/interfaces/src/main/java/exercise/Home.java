package exercise;

// BEGIN
public interface Home {
    double getArea();
    default int compareTo(Home another) {
        if (this.getArea() == another.getArea()) {
            return 0;
        }
        return (this.getArea() > another.getArea()) ? 1 : -1;
    }
}
// END
