package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public  static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> search) {

        List<Map<String, String>> result = new ArrayList<>();

        for (Map<String, String> book : books) {
            for (Entry<String, String> find: search.entrySet()) {
                if (book.get(find.getKey()).equals(find.getValue())) {
                    if (!result.contains(book)) {
                        result.add(book);
                    }
                } else {
                    result.remove(book);
                    break;
                }
            }
        }
        return result;
    }
}
//END
