package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
//import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    public static void save(Path path, Car car) {
        try {
            Files.writeString(path, car.serialize());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Car extract(Path path) {
        String fileToString = null;
        try {
            fileToString = Files.readString(path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return Car.unserialize(fileToString);
    }
}
// END
