package eu.javaspecialists.courses.juppies.anagrams.lib;

import java.util.*;

public class SortedScrambledWordLibrary extends ScrambledWordLibrary {
    public SortedScrambledWordLibrary(WordLibrary other) {
        super(other);
    }

    @Override
    protected void scramble(char[] letters) {
        Arrays.sort(letters);
    }
}
