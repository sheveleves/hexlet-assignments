package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String str;

    public ReversedSequence(String str) {
        this.str = str;
    }

    @Override
    public int length() {
        return this.str.length();
    }

    @Override
    public String toString() {
        String newString = "";
        for (int i = this.length() - 1; i >= 0; i--) {
            newString = newString.concat(str.split("")[i]);
        }
        return newString;
    }

    @Override
    public char charAt(int i) {
        int reversIndex = this.length() - i - 1;
        return this.str.charAt(reversIndex);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        int firstIndex = this.str.length() - i1;
        int lastIndex = this.length() - i;
        String subStr = this.str.substring(firstIndex, lastIndex);
        return new ReversedSequence(subStr);
    }
}
// END
