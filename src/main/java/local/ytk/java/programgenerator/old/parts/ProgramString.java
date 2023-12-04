package local.ytk.java.programgenerator.old.parts;

public class ProgramString implements CharSequence {
    private final String content;

    public ProgramString(String content) {
        this.content = content;
    }

    public ProgramString append(CharSequence c) {
        return new ProgramString(content + c);
    }

    @Override
    public int length() {
        return content.length();
    }

    @Override
    public char charAt(int index) {
        return content.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return content.subSequence(start, end);
    }

    @Override
    public String toString() {
        return content;
    }
}
