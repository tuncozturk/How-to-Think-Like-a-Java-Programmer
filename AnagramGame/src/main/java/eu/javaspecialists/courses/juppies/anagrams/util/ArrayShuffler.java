package eu.javaspecialists.courses.juppies.anagrams.util;

import java.util.*;

public class ArrayShuffler {
    public void shuffle(int[] values) {
        Random random = new Random();
        for (int i = values.length - 1; i > 0 ; i--) {
            int swap = random.nextInt(i + 1) ;
            if (swap !=i) {
                int tmp = values[i];
                values[i] = values[swap];
                values[swap] = tmp;
            }
        }
    }
}
