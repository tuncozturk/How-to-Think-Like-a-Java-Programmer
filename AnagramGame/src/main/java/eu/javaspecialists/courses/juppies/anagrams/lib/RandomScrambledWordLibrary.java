package eu.javaspecialists.courses.juppies.anagrams.lib;

import eu.javaspecialists.courses.juppies.anagrams.util.*;

public final class RandomScrambledWordLibrary extends ScrambledWordLibrary {
    public RandomScrambledWordLibrary(WordLibrary other) {
        super(other);
    }

    @Override
    protected void scramble(char[] letters) {
        ArrayShuffler.shuffle(letters);
    }
}
