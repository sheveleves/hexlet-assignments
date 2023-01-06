package exercise;

import java.util.Map;
import java.util.List;
//import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    private String body;
    List<Tag> list;

    PairedTag(String name, Map<String, String> attributes, String body, List<Tag> list) {
        super(name, attributes);
        this.body = body;
        this.list = list;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += this.body;
        for (Tag singleTag: this.list) {
            result += singleTag.toString();
        }
        result += "</" + super.getName() + ">";
        return result;
    }
}
// END
