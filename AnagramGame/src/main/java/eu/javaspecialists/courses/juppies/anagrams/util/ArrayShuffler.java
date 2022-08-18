package eu.javaspecialists.courses.juppies.anagrams.util;

import java.util.*;

public class ArrayShuffler {
    private ArrayShuffler() {}
    public static void shuffle(int[] values) {
        Random random = new Random();
        for (int i = values.length - 1; i > 0; i--) {
            int swap = random.nextInt(i + 1);
            if (swap != i) {
                values[i] ^= values[swap]; // violates POLA
                values[swap] ^= values[i];
                values[i] ^= values[swap];
            }
        }
    }
    public static void shuffle(char[] values) {
        Random random = new Random();
        for (int i = values.length - 1; i > 0; i--) {
            int swap = random.nextInt(i + 1);
            if (swap != i) {
                values[i] ^= values[swap]; // violates POLA
                values[swap] ^= values[i];
                values[i] ^= values[swap];
            }
        }
    }
}
