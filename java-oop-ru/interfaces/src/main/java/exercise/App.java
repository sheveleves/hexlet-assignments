package exercise;

//import java.util.Comparator;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> buildings, int count) {
        return buildings.stream()
                .sorted(Home::compareTo)
                .limit(count)
                .map(Object::toString)
                .toList();
    }
}
// END
