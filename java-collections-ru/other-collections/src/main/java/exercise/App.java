package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> diffList = new LinkedHashMap<>();
        Map<String, Object>  addMap = new LinkedHashMap<>(data1);

        for (String s: data2.keySet()) {
            if (addMap.containsKey(s) && addMap.get(s).equals(data2.get(s))) {
                diffList.put(s, "unchanged");
                addMap.remove(s);
            } else if (addMap.containsKey(s) && !addMap.get(s).equals((data2.get(s)))) {
                diffList.put(s, "changed");
                addMap.remove(s);
            } else if (!addMap.containsKey(s)) {
                diffList.put(s, "added");
            }
        }
        for (String s: addMap.keySet()) {
            diffList.put(s, "deleted");
        }

        return diffList.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> x, LinkedHashMap::new));
    }
}
//END
