package eu.javaspecialists.courses.juppies.anagrams.util;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ArrayShufflerTest {
    @Test
    public void testShuffle() {
        int[] indexes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String beforeShuffle = Arrays.toString(indexes);
        System.out.println("before shuffle indexes = " + beforeShuffle);
        ArrayShuffler instance = new ArrayShuffler();
        instance.shuffle(indexes);
        String afterShuffle = Arrays.toString(indexes);
        System.out.println("after shuffle indexes = " + afterShuffle);
        assertNotEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]",
                afterShuffle, "Shuffling did not do anything");
        assertNotEquals("[4, 8, 9, 6, 3, 5, 2, 1, 7, 0]",
                afterShuffle, "Shuffling was in a predictable sequence");

        Arrays.sort(indexes);
        String sorted = Arrays.toString(indexes);
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]",
                sorted, "Not same values as before shuffle");
    }
}