package eu.javaspecialists.courses.juppies.anagrams.lib;

public abstract class ScrambledWordLibrary implements WordLibrary {
    private final WordLibrary other;

    protected ScrambledWordLibrary(WordLibrary other) {
        this.other = other;
    }

    @Override
    public String getWord(int idx) {
        return other.getWord(idx);
    }

    @Override
    public String getScrambledWord(int idx) {
        char[] letters = other.getScrambledWord(idx).toCharArray();
        scramble(letters);
        return new String(letters);
    }

    protected abstract void scramble(char[] letters);

    @Override
    public int getSize() {
        return other.getSize();
    }
}
