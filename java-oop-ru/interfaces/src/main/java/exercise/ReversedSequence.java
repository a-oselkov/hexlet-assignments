package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    String text;

    public ReversedSequence(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            result = text.charAt(i) + result;
        }
        this.text = result;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        if (index >= text.length()) {
            return '?';
        }
        return text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (end >= text.length()) {
            return text.subSequence(start, text.length());
        }
        return text.subSequence(start, end);
    }
}
// END
