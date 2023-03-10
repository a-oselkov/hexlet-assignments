package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

    private String tagBody;
    List<Tag> childList;

    public PairedTag(String tagName, Map<String, String> tagAttributes, String tagBody, List<Tag> childList) {
        super(tagName, tagAttributes);
        this.tagBody = tagBody;
        this.childList = childList;
    }

    public String toString() {
        StringBuilder result = new StringBuilder(super.toString() + this.tagBody);
        StringBuilder body = new StringBuilder();
        for (Tag tag : childList) {
            body.append(tag.toString());
        }
        result.append(body).append("</" + this.getTagName() + ">");
        return result.toString();
    }
}

// END
