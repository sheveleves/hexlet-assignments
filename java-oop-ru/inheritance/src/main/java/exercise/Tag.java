package exercise;

//import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
class Tag {
    private String name;
    private Map<String, String> attributes;

    Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        String result = "<" + this.name;
        for (Map.Entry<String, String> attribute: this.attributes.entrySet()) {
            result += " " + attribute.getKey() + "=\"" + attribute.getValue() + "\"";
        }
        result += ">";
        return result;
    }
}
// END
