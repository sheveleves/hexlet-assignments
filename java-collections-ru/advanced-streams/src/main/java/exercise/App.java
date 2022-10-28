package exercise;

import java.util.function.Function;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String data) {
        String[] sort = Stream.of(data)
                .map(x -> x.split("\n"))
                .flatMap((Function<String[], Stream<String>>) strings -> Arrays.stream(strings)
                        .filter(x -> x.startsWith("environment"))
                        .filter(s -> s.contains("X_FORWARDED_"))
                        .map(s -> s.replaceAll("\"", "")))
                .toArray(String[]::new);

        String result = new String();
        for (String s: sort) {
            while (s.contains("X_FORWARDED_")) {
                int i = s.indexOf("X_FORWARDED_");
                s = s.substring(i).replaceFirst("X_FORWARDED_", "");
                if (s.contains(",")) {
                    i = s.indexOf(",");
                    result = result.concat(s.substring(0, i)).concat(",");
                    s = s.substring(i);
                } else {
                    result = result.concat(s).concat(",");
                }
            }
        }
        if (result.endsWith(",")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}
//END
