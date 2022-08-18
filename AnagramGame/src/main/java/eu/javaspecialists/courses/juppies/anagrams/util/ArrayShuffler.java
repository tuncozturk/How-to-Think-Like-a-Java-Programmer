package eu.javaspecialists.courses.juppies.anagrams.util;

import java.lang.reflect.*;
import java.util.*;

public class ArrayShuffler {
    private ArrayShuffler() {
    }

    public static void shuffle(int[] values) {
        shuffleInternal(values);
    }

    public static void shuffle(char[] values) {
        shuffleInternal(values);
    }

    private static void shuffleInternal(Object array) {
        Random random = new Random();
        for (int i = Array.getLength(array) - 1; i > 0; i--) {
            int swap = random.nextInt(i + 1);
            if (swap != i) {
                Object tmp = Array.get(array, i);
                Array.set(array, i, Array.get(array, swap));
                Array.set(array, swap, tmp);
            }
        }

    }
}
