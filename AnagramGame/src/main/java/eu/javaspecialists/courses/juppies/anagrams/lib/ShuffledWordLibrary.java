package eu.javaspecialists.courses.juppies.anagrams.lib;

import eu.javaspecialists.courses.juppies.anagrams.util.*;

import java.util.*;

public class ShuffledWordLibrary extends WordLibrary {
    private final WordLibrary other;
    private final int[] indexes;

    public ShuffledWordLibrary(WordLibrary other) {
        this.other = other;
        this.indexes = new int[this.other.getSize()];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        ArrayShuffler shuffler = new ArrayShuffler();
        shuffler.shuffle(indexes);
    }


    @Override
    public String getWord(int idx) {
        int newIdx = indexes[idx];
        return other.getWord(newIdx);
    }

    @Override
    public String getScrambledWord(int idx) {
        int newIdx = indexes[idx];
        return other.getScrambledWord(newIdx);
    }

    @Override
    public int getSize() {
        return other.getSize();
    }
}
