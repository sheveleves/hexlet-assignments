package exercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

// BEGIN
class App {

    public static String[][] enlargeArrayImage(String[][] image) {
        return Arrays.stream(image)
                .map(x -> {
                    return Arrays.stream(x)
                            .map(s -> List.of(s, s))
                            .flatMap(Collection::stream)
                            .toArray(String[]::new);
                })
                .map(strings -> List.of(strings, strings))
                .flatMap(List::stream)
                .toArray(String[][]::new);
    }
}

// END
