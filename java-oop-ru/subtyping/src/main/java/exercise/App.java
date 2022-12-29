package exercise;

import java.util.HashSet;
import java.util.Map;
//import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage data) {
        Set<String> keys = new HashSet<>(data.toMap().keySet());
        for (String key : keys) {
            data.set(data.get(key, ""), key);
            data.unset(key);
        }
    }

    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
        System.out.println(storage.toMap());

        swapKeyValue(storage);
        System.out.println(storage.toMap());
    }
}
// END
