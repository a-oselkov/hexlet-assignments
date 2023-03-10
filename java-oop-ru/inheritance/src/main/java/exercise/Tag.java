package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private String tagName;
    private Map<String, String> tagAttributes;

    public Tag(String tagName, Map<String, String> tagAttributes) {
        this.tagName = tagName;
        this.tagAttributes = tagAttributes;
    }

    public String getTagName() {
        return tagName;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("<" + this.tagName);
        for (Map.Entry<String, String> entry : this.tagAttributes.entrySet()) {
            result.append(" " + entry.getKey() + "=\"" + entry.getValue() + "\"");
        }
        result.append(">");
        return result.toString();
    }
}
// END
